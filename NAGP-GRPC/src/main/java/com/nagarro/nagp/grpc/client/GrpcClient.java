package com.nagarro.nagp.grpc.client;

import com.nagarro.nagp.grpc.HelloServiceGrpc;
import com.nagarro.nagp.grpc.HelloServiceOuterClass.HelloRequest;
import com.nagarro.nagp.grpc.HelloServiceOuterClass.HelloResponse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
            .usePlaintext()
            .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub 
          = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
            .setFirstName("Baeldung")
            .setLastName("gRPC")
            .build());

        System.out.println("Response received from server:\n" + helloResponse);

        channel.shutdown();
    }
}