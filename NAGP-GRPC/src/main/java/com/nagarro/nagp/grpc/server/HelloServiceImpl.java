package com.nagarro.nagp.grpc.server;

import com.nagarro.nagp.grpc.HelloServiceGrpc.HelloServiceImplBase;
import com.nagarro.nagp.grpc.HelloServiceOuterClass.HelloRequest;
import com.nagarro.nagp.grpc.HelloServiceOuterClass.HelloResponse;

import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceImplBase {

    @Override
    public void hello(
      HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println("Request received from client:\n" + request);

        String greeting = new StringBuilder().append("Hello, ")
            .append(request.getFirstName())
            .append(" ")
            .append(request.getLastName())
            .toString();

        HelloResponse response = HelloResponse.newBuilder()
            .setGreeting(greeting)
            .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}