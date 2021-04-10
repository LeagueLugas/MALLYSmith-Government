package proto.government;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.32.1)",
    comments = "Source: government.proto")
public final class GovernmentServiceGrpc {

  private GovernmentServiceGrpc() {}

  public static final String SERVICE_NAME = "proto.government.GovernmentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.government.Government.GetBasicIncomeRequest,
      proto.government.Government.GetBasicIncomeResponse> getGetBasicIncomeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBasicIncome",
      requestType = proto.government.Government.GetBasicIncomeRequest.class,
      responseType = proto.government.Government.GetBasicIncomeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.government.Government.GetBasicIncomeRequest,
      proto.government.Government.GetBasicIncomeResponse> getGetBasicIncomeMethod() {
    io.grpc.MethodDescriptor<proto.government.Government.GetBasicIncomeRequest, proto.government.Government.GetBasicIncomeResponse> getGetBasicIncomeMethod;
    if ((getGetBasicIncomeMethod = GovernmentServiceGrpc.getGetBasicIncomeMethod) == null) {
      synchronized (GovernmentServiceGrpc.class) {
        if ((getGetBasicIncomeMethod = GovernmentServiceGrpc.getGetBasicIncomeMethod) == null) {
          GovernmentServiceGrpc.getGetBasicIncomeMethod = getGetBasicIncomeMethod =
              io.grpc.MethodDescriptor.<proto.government.Government.GetBasicIncomeRequest, proto.government.Government.GetBasicIncomeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBasicIncome"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.government.Government.GetBasicIncomeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.government.Government.GetBasicIncomeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GovernmentServiceMethodDescriptorSupplier("GetBasicIncome"))
              .build();
        }
      }
    }
    return getGetBasicIncomeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GovernmentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GovernmentServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GovernmentServiceStub>() {
        @java.lang.Override
        public GovernmentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GovernmentServiceStub(channel, callOptions);
        }
      };
    return GovernmentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GovernmentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GovernmentServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GovernmentServiceBlockingStub>() {
        @java.lang.Override
        public GovernmentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GovernmentServiceBlockingStub(channel, callOptions);
        }
      };
    return GovernmentServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GovernmentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GovernmentServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GovernmentServiceFutureStub>() {
        @java.lang.Override
        public GovernmentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GovernmentServiceFutureStub(channel, callOptions);
        }
      };
    return GovernmentServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class GovernmentServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getBasicIncome(proto.government.Government.GetBasicIncomeRequest request,
        io.grpc.stub.StreamObserver<proto.government.Government.GetBasicIncomeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBasicIncomeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetBasicIncomeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.government.Government.GetBasicIncomeRequest,
                proto.government.Government.GetBasicIncomeResponse>(
                  this, METHODID_GET_BASIC_INCOME)))
          .build();
    }
  }

  /**
   */
  public static final class GovernmentServiceStub extends io.grpc.stub.AbstractAsyncStub<GovernmentServiceStub> {
    private GovernmentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GovernmentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GovernmentServiceStub(channel, callOptions);
    }

    /**
     */
    public void getBasicIncome(proto.government.Government.GetBasicIncomeRequest request,
        io.grpc.stub.StreamObserver<proto.government.Government.GetBasicIncomeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBasicIncomeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GovernmentServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<GovernmentServiceBlockingStub> {
    private GovernmentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GovernmentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GovernmentServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.government.Government.GetBasicIncomeResponse getBasicIncome(proto.government.Government.GetBasicIncomeRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetBasicIncomeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GovernmentServiceFutureStub extends io.grpc.stub.AbstractFutureStub<GovernmentServiceFutureStub> {
    private GovernmentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GovernmentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GovernmentServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.government.Government.GetBasicIncomeResponse> getBasicIncome(
        proto.government.Government.GetBasicIncomeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBasicIncomeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_BASIC_INCOME = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GovernmentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GovernmentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_BASIC_INCOME:
          serviceImpl.getBasicIncome((proto.government.Government.GetBasicIncomeRequest) request,
              (io.grpc.stub.StreamObserver<proto.government.Government.GetBasicIncomeResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GovernmentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GovernmentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.government.Government.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GovernmentService");
    }
  }

  private static final class GovernmentServiceFileDescriptorSupplier
      extends GovernmentServiceBaseDescriptorSupplier {
    GovernmentServiceFileDescriptorSupplier() {}
  }

  private static final class GovernmentServiceMethodDescriptorSupplier
      extends GovernmentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GovernmentServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GovernmentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GovernmentServiceFileDescriptorSupplier())
              .addMethod(getGetBasicIncomeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
