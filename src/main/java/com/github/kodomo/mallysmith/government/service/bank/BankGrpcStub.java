package com.github.kodomo.mallysmith.government.service.bank;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import proto.bank.Bank;
import proto.bank.BankServiceGrpc;

public final class BankGrpcStub {

    private static final String host = "25.112.64.235";
    private static final int port = 10002;

    private final ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
    private final BankServiceGrpc.BankServiceBlockingStub bankStub = BankServiceGrpc.newBlockingStub(channel);

    public Bank.DepositResponse deposit(String fromUuid, String toUuid, long money) {
        Bank.DepositRequest request = Bank.DepositRequest.newBuilder()
                .setFromUserId(fromUuid)
                .setToUserId(toUuid)
                .setMoney(money)
                .build();

        return bankStub.deposit(request);
    }

    public Bank.OpenAccountResponse openAccount() {
        Bank.OpenAccountRequest request = Bank.OpenAccountRequest.newBuilder()
                .setUserId("lugas")
                .build();

        return bankStub.openAccount(request);
    }

}
