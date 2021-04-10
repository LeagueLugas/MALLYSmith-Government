package com.github.kodomo.mallysmith.government.stub.user;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import proto.user.User;
import proto.user.UserServiceGrpc;

public class UserGrpcStub {

    private static final String host = "25.112.155.55";
    private static final int port = 8000;

    private final ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
    private final UserServiceGrpc.UserServiceBlockingStub bankStub = UserServiceGrpc.newBlockingStub(channel);

    public boolean isExistsUser(String uuid) {
        User.isExistsRequest request = User.isExistsRequest.newBuilder()
                .setUuid(uuid)
                .build();

        User.isExistsResponse response = bankStub.isExists(request);
        return response.getExists();
    }

}
