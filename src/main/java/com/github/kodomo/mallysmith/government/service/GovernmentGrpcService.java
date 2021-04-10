package com.github.kodomo.mallysmith.government.service;

import com.github.kodomo.mallysmith.government.bean.BeanContainer;
import com.github.kodomo.mallysmith.government.database.repository.publicservant.PublicServant;
import com.github.kodomo.mallysmith.government.database.repository.publicservant.PublicServantRepository;
import com.github.kodomo.mallysmith.government.stub.bank.BankGrpcStub;
import com.github.kodomo.mallysmith.government.stub.user.UserGrpcStub;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import proto.bank.Bank;
import proto.government.Government;
import proto.government.GovernmentServiceGrpc;

import static com.github.kodomo.mallysmith.government.util.Utils.log;

public class GovernmentGrpcService extends GovernmentServiceGrpc.GovernmentServiceImplBase {

    private static final long DEFAULT_BASIC_INCOME = 30000L;
    private static final String ADMIN_UUID = "admin";

    private final UserGrpcStub userGrpc = BeanContainer.getBean(UserGrpcStub.class);
    private final BankGrpcStub bankGrpc = BeanContainer.getBean(BankGrpcStub.class);
    private final PublicServantRepository repository = BeanContainer.getBean(PublicServantRepository.class);

    @Override
    public void getBasicIncome(Government.GetBasicIncomeRequest request, StreamObserver<Government.GetBasicIncomeResponse> responseObserver) {
        String uuid = request.getUuid();
        boolean exists = userGrpc.isExistsUser(uuid);
        if (exists) {
            log(uuid + "님이 기본소득을 신청하였습니다");
            try {
                Bank.DepositResponse depositResponse = bankGrpc.deposit(ADMIN_UUID, uuid, DEFAULT_BASIC_INCOME);
                Government.GetBasicIncomeResponse response = Government.GetBasicIncomeResponse.newBuilder()
                        .setMoney(depositResponse.getDepositMoney())
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                log(uuid + "님의 기본소득이 정상적으로 신청되었습니다");
            } catch (StatusRuntimeException e) {
                Status status = e.getStatus();
                Status.Code code = status.getCode();
                if (code == Status.Code.ALREADY_EXISTS) {
                    log(uuid + "님의 계좌가 이미 있습니다");
                } else if (code == Status.Code.NOT_FOUND) {
                    log(uuid + "님의 계좌가 존재하지 않습니다");
                }
                responseObserver.onError(new StatusRuntimeException(status));
            }
        } else {
            log(uuid + "님이 존재하지 않습니다");
            responseObserver.onError(new StatusRuntimeException(Status.NOT_FOUND));
        }
    }

    public void test() {
        PublicServant publicServant = repository.findById(1);
    }

}
