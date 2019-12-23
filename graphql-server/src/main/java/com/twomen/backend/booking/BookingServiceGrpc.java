package com.twomen.backend.booking;

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
    value = "by gRPC proto compiler (version 1.24.0)",
    comments = "Source: Booking.proto")
public final class BookingServiceGrpc {

  private BookingServiceGrpc() {}

  public static final String SERVICE_NAME = "booking.BookingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.twomen.backend.booking.Filter,
      com.twomen.backend.booking.ShowResponse> getGetAllShowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllShows",
      requestType = com.twomen.backend.booking.Filter.class,
      responseType = com.twomen.backend.booking.ShowResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.twomen.backend.booking.Filter,
      com.twomen.backend.booking.ShowResponse> getGetAllShowsMethod() {
    io.grpc.MethodDescriptor<com.twomen.backend.booking.Filter, com.twomen.backend.booking.ShowResponse> getGetAllShowsMethod;
    if ((getGetAllShowsMethod = BookingServiceGrpc.getGetAllShowsMethod) == null) {
      synchronized (BookingServiceGrpc.class) {
        if ((getGetAllShowsMethod = BookingServiceGrpc.getGetAllShowsMethod) == null) {
          BookingServiceGrpc.getGetAllShowsMethod = getGetAllShowsMethod =
              io.grpc.MethodDescriptor.<com.twomen.backend.booking.Filter, com.twomen.backend.booking.ShowResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllShows"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.twomen.backend.booking.Filter.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.twomen.backend.booking.ShowResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BookingServiceMethodDescriptorSupplier("GetAllShows"))
              .build();
        }
      }
    }
    return getGetAllShowsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.twomen.backend.booking.ShowRequest,
      com.twomen.backend.booking.ShowResponse> getGetShowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetShow",
      requestType = com.twomen.backend.booking.ShowRequest.class,
      responseType = com.twomen.backend.booking.ShowResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.twomen.backend.booking.ShowRequest,
      com.twomen.backend.booking.ShowResponse> getGetShowMethod() {
    io.grpc.MethodDescriptor<com.twomen.backend.booking.ShowRequest, com.twomen.backend.booking.ShowResponse> getGetShowMethod;
    if ((getGetShowMethod = BookingServiceGrpc.getGetShowMethod) == null) {
      synchronized (BookingServiceGrpc.class) {
        if ((getGetShowMethod = BookingServiceGrpc.getGetShowMethod) == null) {
          BookingServiceGrpc.getGetShowMethod = getGetShowMethod =
              io.grpc.MethodDescriptor.<com.twomen.backend.booking.ShowRequest, com.twomen.backend.booking.ShowResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetShow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.twomen.backend.booking.ShowRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.twomen.backend.booking.ShowResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BookingServiceMethodDescriptorSupplier("GetShow"))
              .build();
        }
      }
    }
    return getGetShowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.twomen.backend.booking.DeleteRequest,
      com.twomen.backend.booking.DeleteResponse> getDeleteBookingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBooking",
      requestType = com.twomen.backend.booking.DeleteRequest.class,
      responseType = com.twomen.backend.booking.DeleteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.twomen.backend.booking.DeleteRequest,
      com.twomen.backend.booking.DeleteResponse> getDeleteBookingMethod() {
    io.grpc.MethodDescriptor<com.twomen.backend.booking.DeleteRequest, com.twomen.backend.booking.DeleteResponse> getDeleteBookingMethod;
    if ((getDeleteBookingMethod = BookingServiceGrpc.getDeleteBookingMethod) == null) {
      synchronized (BookingServiceGrpc.class) {
        if ((getDeleteBookingMethod = BookingServiceGrpc.getDeleteBookingMethod) == null) {
          BookingServiceGrpc.getDeleteBookingMethod = getDeleteBookingMethod =
              io.grpc.MethodDescriptor.<com.twomen.backend.booking.DeleteRequest, com.twomen.backend.booking.DeleteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBooking"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.twomen.backend.booking.DeleteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.twomen.backend.booking.DeleteResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BookingServiceMethodDescriptorSupplier("DeleteBooking"))
              .build();
        }
      }
    }
    return getDeleteBookingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.twomen.backend.booking.BookingRequest,
      com.twomen.backend.booking.BookingResponse> getMakeBookingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MakeBooking",
      requestType = com.twomen.backend.booking.BookingRequest.class,
      responseType = com.twomen.backend.booking.BookingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.twomen.backend.booking.BookingRequest,
      com.twomen.backend.booking.BookingResponse> getMakeBookingMethod() {
    io.grpc.MethodDescriptor<com.twomen.backend.booking.BookingRequest, com.twomen.backend.booking.BookingResponse> getMakeBookingMethod;
    if ((getMakeBookingMethod = BookingServiceGrpc.getMakeBookingMethod) == null) {
      synchronized (BookingServiceGrpc.class) {
        if ((getMakeBookingMethod = BookingServiceGrpc.getMakeBookingMethod) == null) {
          BookingServiceGrpc.getMakeBookingMethod = getMakeBookingMethod =
              io.grpc.MethodDescriptor.<com.twomen.backend.booking.BookingRequest, com.twomen.backend.booking.BookingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MakeBooking"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.twomen.backend.booking.BookingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.twomen.backend.booking.BookingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BookingServiceMethodDescriptorSupplier("MakeBooking"))
              .build();
        }
      }
    }
    return getMakeBookingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.twomen.backend.booking.BookingRequest,
      com.twomen.backend.booking.BookingResponse> getGetBookingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBooking",
      requestType = com.twomen.backend.booking.BookingRequest.class,
      responseType = com.twomen.backend.booking.BookingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.twomen.backend.booking.BookingRequest,
      com.twomen.backend.booking.BookingResponse> getGetBookingMethod() {
    io.grpc.MethodDescriptor<com.twomen.backend.booking.BookingRequest, com.twomen.backend.booking.BookingResponse> getGetBookingMethod;
    if ((getGetBookingMethod = BookingServiceGrpc.getGetBookingMethod) == null) {
      synchronized (BookingServiceGrpc.class) {
        if ((getGetBookingMethod = BookingServiceGrpc.getGetBookingMethod) == null) {
          BookingServiceGrpc.getGetBookingMethod = getGetBookingMethod =
              io.grpc.MethodDescriptor.<com.twomen.backend.booking.BookingRequest, com.twomen.backend.booking.BookingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBooking"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.twomen.backend.booking.BookingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.twomen.backend.booking.BookingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BookingServiceMethodDescriptorSupplier("GetBooking"))
              .build();
        }
      }
    }
    return getGetBookingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BookingServiceStub newStub(io.grpc.Channel channel) {
    return new BookingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BookingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BookingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BookingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BookingServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class BookingServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * returns all running shows
     * </pre>
     */
    public void getAllShows(com.twomen.backend.booking.Filter request,
        io.grpc.stub.StreamObserver<com.twomen.backend.booking.ShowResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllShowsMethod(), responseObserver);
    }

    /**
     * <pre>
     * returns specific show by film_name and start_time
     * </pre>
     */
    public void getShow(com.twomen.backend.booking.ShowRequest request,
        io.grpc.stub.StreamObserver<com.twomen.backend.booking.ShowResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetShowMethod(), responseObserver);
    }

    /**
     * <pre>
     * delete certain booking
     * </pre>
     */
    public void deleteBooking(com.twomen.backend.booking.DeleteRequest request,
        io.grpc.stub.StreamObserver<com.twomen.backend.booking.DeleteResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteBookingMethod(), responseObserver);
    }

    /**
     * <pre>
     * try to make booking for film
     * </pre>
     */
    public void makeBooking(com.twomen.backend.booking.BookingRequest request,
        io.grpc.stub.StreamObserver<com.twomen.backend.booking.BookingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getMakeBookingMethod(), responseObserver);
    }

    /**
     * <pre>
     * get booking by id
     * </pre>
     */
    public void getBooking(com.twomen.backend.booking.BookingRequest request,
        io.grpc.stub.StreamObserver<com.twomen.backend.booking.BookingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBookingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAllShowsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.twomen.backend.booking.Filter,
                com.twomen.backend.booking.ShowResponse>(
                  this, METHODID_GET_ALL_SHOWS)))
          .addMethod(
            getGetShowMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.twomen.backend.booking.ShowRequest,
                com.twomen.backend.booking.ShowResponse>(
                  this, METHODID_GET_SHOW)))
          .addMethod(
            getDeleteBookingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.twomen.backend.booking.DeleteRequest,
                com.twomen.backend.booking.DeleteResponse>(
                  this, METHODID_DELETE_BOOKING)))
          .addMethod(
            getMakeBookingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.twomen.backend.booking.BookingRequest,
                com.twomen.backend.booking.BookingResponse>(
                  this, METHODID_MAKE_BOOKING)))
          .addMethod(
            getGetBookingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.twomen.backend.booking.BookingRequest,
                com.twomen.backend.booking.BookingResponse>(
                  this, METHODID_GET_BOOKING)))
          .build();
    }
  }

  /**
   */
  public static final class BookingServiceStub extends io.grpc.stub.AbstractStub<BookingServiceStub> {
    private BookingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookingServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * returns all running shows
     * </pre>
     */
    public void getAllShows(com.twomen.backend.booking.Filter request,
        io.grpc.stub.StreamObserver<com.twomen.backend.booking.ShowResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetAllShowsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * returns specific show by film_name and start_time
     * </pre>
     */
    public void getShow(com.twomen.backend.booking.ShowRequest request,
        io.grpc.stub.StreamObserver<com.twomen.backend.booking.ShowResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetShowMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * delete certain booking
     * </pre>
     */
    public void deleteBooking(com.twomen.backend.booking.DeleteRequest request,
        io.grpc.stub.StreamObserver<com.twomen.backend.booking.DeleteResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteBookingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * try to make booking for film
     * </pre>
     */
    public void makeBooking(com.twomen.backend.booking.BookingRequest request,
        io.grpc.stub.StreamObserver<com.twomen.backend.booking.BookingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMakeBookingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * get booking by id
     * </pre>
     */
    public void getBooking(com.twomen.backend.booking.BookingRequest request,
        io.grpc.stub.StreamObserver<com.twomen.backend.booking.BookingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBookingMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BookingServiceBlockingStub extends io.grpc.stub.AbstractStub<BookingServiceBlockingStub> {
    private BookingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookingServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * returns all running shows
     * </pre>
     */
    public java.util.Iterator<com.twomen.backend.booking.ShowResponse> getAllShows(
        com.twomen.backend.booking.Filter request) {
      return blockingServerStreamingCall(
          getChannel(), getGetAllShowsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * returns specific show by film_name and start_time
     * </pre>
     */
    public com.twomen.backend.booking.ShowResponse getShow(com.twomen.backend.booking.ShowRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetShowMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * delete certain booking
     * </pre>
     */
    public com.twomen.backend.booking.DeleteResponse deleteBooking(com.twomen.backend.booking.DeleteRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteBookingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * try to make booking for film
     * </pre>
     */
    public com.twomen.backend.booking.BookingResponse makeBooking(com.twomen.backend.booking.BookingRequest request) {
      return blockingUnaryCall(
          getChannel(), getMakeBookingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * get booking by id
     * </pre>
     */
    public com.twomen.backend.booking.BookingResponse getBooking(com.twomen.backend.booking.BookingRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetBookingMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BookingServiceFutureStub extends io.grpc.stub.AbstractStub<BookingServiceFutureStub> {
    private BookingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookingServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * returns specific show by film_name and start_time
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.twomen.backend.booking.ShowResponse> getShow(
        com.twomen.backend.booking.ShowRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetShowMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * delete certain booking
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.twomen.backend.booking.DeleteResponse> deleteBooking(
        com.twomen.backend.booking.DeleteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteBookingMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * try to make booking for film
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.twomen.backend.booking.BookingResponse> makeBooking(
        com.twomen.backend.booking.BookingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMakeBookingMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * get booking by id
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.twomen.backend.booking.BookingResponse> getBooking(
        com.twomen.backend.booking.BookingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBookingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ALL_SHOWS = 0;
  private static final int METHODID_GET_SHOW = 1;
  private static final int METHODID_DELETE_BOOKING = 2;
  private static final int METHODID_MAKE_BOOKING = 3;
  private static final int METHODID_GET_BOOKING = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BookingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BookingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ALL_SHOWS:
          serviceImpl.getAllShows((com.twomen.backend.booking.Filter) request,
              (io.grpc.stub.StreamObserver<com.twomen.backend.booking.ShowResponse>) responseObserver);
          break;
        case METHODID_GET_SHOW:
          serviceImpl.getShow((com.twomen.backend.booking.ShowRequest) request,
              (io.grpc.stub.StreamObserver<com.twomen.backend.booking.ShowResponse>) responseObserver);
          break;
        case METHODID_DELETE_BOOKING:
          serviceImpl.deleteBooking((com.twomen.backend.booking.DeleteRequest) request,
              (io.grpc.stub.StreamObserver<com.twomen.backend.booking.DeleteResponse>) responseObserver);
          break;
        case METHODID_MAKE_BOOKING:
          serviceImpl.makeBooking((com.twomen.backend.booking.BookingRequest) request,
              (io.grpc.stub.StreamObserver<com.twomen.backend.booking.BookingResponse>) responseObserver);
          break;
        case METHODID_GET_BOOKING:
          serviceImpl.getBooking((com.twomen.backend.booking.BookingRequest) request,
              (io.grpc.stub.StreamObserver<com.twomen.backend.booking.BookingResponse>) responseObserver);
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

  private static abstract class BookingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BookingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.twomen.backend.booking.BookingProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BookingService");
    }
  }

  private static final class BookingServiceFileDescriptorSupplier
      extends BookingServiceBaseDescriptorSupplier {
    BookingServiceFileDescriptorSupplier() {}
  }

  private static final class BookingServiceMethodDescriptorSupplier
      extends BookingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BookingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BookingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BookingServiceFileDescriptorSupplier())
              .addMethod(getGetAllShowsMethod())
              .addMethod(getGetShowMethod())
              .addMethod(getDeleteBookingMethod())
              .addMethod(getMakeBookingMethod())
              .addMethod(getGetBookingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
