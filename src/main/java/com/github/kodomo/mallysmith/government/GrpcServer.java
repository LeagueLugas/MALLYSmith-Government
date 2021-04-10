package com.github.kodomo.mallysmith.government;

import com.github.kodomo.mallysmith.government.service.GovernmentGrpcService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {

    private final Server server;

    public GrpcServer(int port) {
         server = ServerBuilder
                 .forPort(port)
                 .addService(new GovernmentGrpcService())
                 .build();
    }

    public void start() throws IOException {
        System.out.println("GRPC server starting...");
        server.start();
        System.out.println("GRPC server started, listening to " + server.getPort());
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("*** shutting down gRPC server since JVM is shutting down");
            this.stop();
            System.out.println("*** server shut down");
        }));

    }

    public void stop() {
        server.shutdown();
    }

    public void blockUntilShutdown() throws InterruptedException {
        server.awaitTermination();
    }

}
