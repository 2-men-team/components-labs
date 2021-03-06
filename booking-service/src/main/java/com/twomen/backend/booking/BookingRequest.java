// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Booking.proto

package com.twomen.backend.booking;

/**
 * Protobuf type {@code booking.BookingRequest}
 */
public  final class BookingRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:booking.BookingRequest)
    BookingRequestOrBuilder {
  // Use BookingRequest.newBuilder() to construct.
  private BookingRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BookingRequest() {
    id_ = 0;
    startTime_ = 0L;
    firstName_ = "";
    lastName_ = "";
    email_ = "";
    phoneNumber_ = "";
    places_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private BookingRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            id_ = input.readInt32();
            break;
          }
          case 16: {

            startTime_ = input.readInt64();
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            firstName_ = s;
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            lastName_ = s;
            break;
          }
          case 42: {
            java.lang.String s = input.readStringRequireUtf8();

            email_ = s;
            break;
          }
          case 50: {
            java.lang.String s = input.readStringRequireUtf8();

            phoneNumber_ = s;
            break;
          }
          case 56: {
            if (!((mutable_bitField0_ & 0x00000040) == 0x00000040)) {
              places_ = new java.util.ArrayList<java.lang.Integer>();
              mutable_bitField0_ |= 0x00000040;
            }
            places_.add(input.readInt32());
            break;
          }
          case 58: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000040) == 0x00000040) && input.getBytesUntilLimit() > 0) {
              places_ = new java.util.ArrayList<java.lang.Integer>();
              mutable_bitField0_ |= 0x00000040;
            }
            while (input.getBytesUntilLimit() > 0) {
              places_.add(input.readInt32());
            }
            input.popLimit(limit);
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000040) == 0x00000040)) {
        places_ = java.util.Collections.unmodifiableList(places_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.twomen.backend.booking.BookingProto.internal_static_booking_BookingRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.twomen.backend.booking.BookingProto.internal_static_booking_BookingRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.twomen.backend.booking.BookingRequest.class, com.twomen.backend.booking.BookingRequest.Builder.class);
  }

  private int bitField0_;
  public static final int ID_FIELD_NUMBER = 1;
  private int id_;
  /**
   * <code>optional int32 id = 1;</code>
   */
  public int getId() {
    return id_;
  }

  public static final int START_TIME_FIELD_NUMBER = 2;
  private long startTime_;
  /**
   * <code>optional int64 start_time = 2;</code>
   */
  public long getStartTime() {
    return startTime_;
  }

  public static final int FIRST_NAME_FIELD_NUMBER = 3;
  private volatile java.lang.Object firstName_;
  /**
   * <code>optional string first_name = 3;</code>
   */
  public java.lang.String getFirstName() {
    java.lang.Object ref = firstName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      firstName_ = s;
      return s;
    }
  }
  /**
   * <code>optional string first_name = 3;</code>
   */
  public com.google.protobuf.ByteString
      getFirstNameBytes() {
    java.lang.Object ref = firstName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      firstName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int LAST_NAME_FIELD_NUMBER = 4;
  private volatile java.lang.Object lastName_;
  /**
   * <code>optional string last_name = 4;</code>
   */
  public java.lang.String getLastName() {
    java.lang.Object ref = lastName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      lastName_ = s;
      return s;
    }
  }
  /**
   * <code>optional string last_name = 4;</code>
   */
  public com.google.protobuf.ByteString
      getLastNameBytes() {
    java.lang.Object ref = lastName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      lastName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int EMAIL_FIELD_NUMBER = 5;
  private volatile java.lang.Object email_;
  /**
   * <code>optional string email = 5;</code>
   */
  public java.lang.String getEmail() {
    java.lang.Object ref = email_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      email_ = s;
      return s;
    }
  }
  /**
   * <code>optional string email = 5;</code>
   */
  public com.google.protobuf.ByteString
      getEmailBytes() {
    java.lang.Object ref = email_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      email_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PHONE_NUMBER_FIELD_NUMBER = 6;
  private volatile java.lang.Object phoneNumber_;
  /**
   * <code>optional string phone_number = 6;</code>
   */
  public java.lang.String getPhoneNumber() {
    java.lang.Object ref = phoneNumber_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      phoneNumber_ = s;
      return s;
    }
  }
  /**
   * <code>optional string phone_number = 6;</code>
   */
  public com.google.protobuf.ByteString
      getPhoneNumberBytes() {
    java.lang.Object ref = phoneNumber_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      phoneNumber_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PLACES_FIELD_NUMBER = 7;
  private java.util.List<java.lang.Integer> places_;
  /**
   * <code>repeated int32 places = 7;</code>
   */
  public java.util.List<java.lang.Integer>
      getPlacesList() {
    return places_;
  }
  /**
   * <code>repeated int32 places = 7;</code>
   */
  public int getPlacesCount() {
    return places_.size();
  }
  /**
   * <code>repeated int32 places = 7;</code>
   */
  public int getPlaces(int index) {
    return places_.get(index);
  }
  private int placesMemoizedSerializedSize = -1;

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (id_ != 0) {
      output.writeInt32(1, id_);
    }
    if (startTime_ != 0L) {
      output.writeInt64(2, startTime_);
    }
    if (!getFirstNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, firstName_);
    }
    if (!getLastNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, lastName_);
    }
    if (!getEmailBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, email_);
    }
    if (!getPhoneNumberBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 6, phoneNumber_);
    }
    if (getPlacesList().size() > 0) {
      output.writeUInt32NoTag(58);
      output.writeUInt32NoTag(placesMemoizedSerializedSize);
    }
    for (int i = 0; i < places_.size(); i++) {
      output.writeInt32NoTag(places_.get(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (id_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, id_);
    }
    if (startTime_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, startTime_);
    }
    if (!getFirstNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, firstName_);
    }
    if (!getLastNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, lastName_);
    }
    if (!getEmailBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, email_);
    }
    if (!getPhoneNumberBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, phoneNumber_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < places_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt32SizeNoTag(places_.get(i));
      }
      size += dataSize;
      if (!getPlacesList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      placesMemoizedSerializedSize = dataSize;
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.twomen.backend.booking.BookingRequest)) {
      return super.equals(obj);
    }
    com.twomen.backend.booking.BookingRequest other = (com.twomen.backend.booking.BookingRequest) obj;

    boolean result = true;
    result = result && (getId()
        == other.getId());
    result = result && (getStartTime()
        == other.getStartTime());
    result = result && getFirstName()
        .equals(other.getFirstName());
    result = result && getLastName()
        .equals(other.getLastName());
    result = result && getEmail()
        .equals(other.getEmail());
    result = result && getPhoneNumber()
        .equals(other.getPhoneNumber());
    result = result && getPlacesList()
        .equals(other.getPlacesList());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId();
    hash = (37 * hash) + START_TIME_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getStartTime());
    hash = (37 * hash) + FIRST_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getFirstName().hashCode();
    hash = (37 * hash) + LAST_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getLastName().hashCode();
    hash = (37 * hash) + EMAIL_FIELD_NUMBER;
    hash = (53 * hash) + getEmail().hashCode();
    hash = (37 * hash) + PHONE_NUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getPhoneNumber().hashCode();
    if (getPlacesCount() > 0) {
      hash = (37 * hash) + PLACES_FIELD_NUMBER;
      hash = (53 * hash) + getPlacesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.twomen.backend.booking.BookingRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.twomen.backend.booking.BookingRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.twomen.backend.booking.BookingRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.twomen.backend.booking.BookingRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.twomen.backend.booking.BookingRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.twomen.backend.booking.BookingRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.twomen.backend.booking.BookingRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.twomen.backend.booking.BookingRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.twomen.backend.booking.BookingRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.twomen.backend.booking.BookingRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.twomen.backend.booking.BookingRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code booking.BookingRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:booking.BookingRequest)
      com.twomen.backend.booking.BookingRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.twomen.backend.booking.BookingProto.internal_static_booking_BookingRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.twomen.backend.booking.BookingProto.internal_static_booking_BookingRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.twomen.backend.booking.BookingRequest.class, com.twomen.backend.booking.BookingRequest.Builder.class);
    }

    // Construct using com.twomen.backend.booking.BookingRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      id_ = 0;

      startTime_ = 0L;

      firstName_ = "";

      lastName_ = "";

      email_ = "";

      phoneNumber_ = "";

      places_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000040);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.twomen.backend.booking.BookingProto.internal_static_booking_BookingRequest_descriptor;
    }

    public com.twomen.backend.booking.BookingRequest getDefaultInstanceForType() {
      return com.twomen.backend.booking.BookingRequest.getDefaultInstance();
    }

    public com.twomen.backend.booking.BookingRequest build() {
      com.twomen.backend.booking.BookingRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.twomen.backend.booking.BookingRequest buildPartial() {
      com.twomen.backend.booking.BookingRequest result = new com.twomen.backend.booking.BookingRequest(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.id_ = id_;
      result.startTime_ = startTime_;
      result.firstName_ = firstName_;
      result.lastName_ = lastName_;
      result.email_ = email_;
      result.phoneNumber_ = phoneNumber_;
      if (((bitField0_ & 0x00000040) == 0x00000040)) {
        places_ = java.util.Collections.unmodifiableList(places_);
        bitField0_ = (bitField0_ & ~0x00000040);
      }
      result.places_ = places_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.twomen.backend.booking.BookingRequest) {
        return mergeFrom((com.twomen.backend.booking.BookingRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.twomen.backend.booking.BookingRequest other) {
      if (other == com.twomen.backend.booking.BookingRequest.getDefaultInstance()) return this;
      if (other.getId() != 0) {
        setId(other.getId());
      }
      if (other.getStartTime() != 0L) {
        setStartTime(other.getStartTime());
      }
      if (!other.getFirstName().isEmpty()) {
        firstName_ = other.firstName_;
        onChanged();
      }
      if (!other.getLastName().isEmpty()) {
        lastName_ = other.lastName_;
        onChanged();
      }
      if (!other.getEmail().isEmpty()) {
        email_ = other.email_;
        onChanged();
      }
      if (!other.getPhoneNumber().isEmpty()) {
        phoneNumber_ = other.phoneNumber_;
        onChanged();
      }
      if (!other.places_.isEmpty()) {
        if (places_.isEmpty()) {
          places_ = other.places_;
          bitField0_ = (bitField0_ & ~0x00000040);
        } else {
          ensurePlacesIsMutable();
          places_.addAll(other.places_);
        }
        onChanged();
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.twomen.backend.booking.BookingRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.twomen.backend.booking.BookingRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int id_ ;
    /**
     * <code>optional int32 id = 1;</code>
     */
    public int getId() {
      return id_;
    }
    /**
     * <code>optional int32 id = 1;</code>
     */
    public Builder setId(int value) {
      
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 id = 1;</code>
     */
    public Builder clearId() {
      
      id_ = 0;
      onChanged();
      return this;
    }

    private long startTime_ ;
    /**
     * <code>optional int64 start_time = 2;</code>
     */
    public long getStartTime() {
      return startTime_;
    }
    /**
     * <code>optional int64 start_time = 2;</code>
     */
    public Builder setStartTime(long value) {
      
      startTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 start_time = 2;</code>
     */
    public Builder clearStartTime() {
      
      startTime_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object firstName_ = "";
    /**
     * <code>optional string first_name = 3;</code>
     */
    public java.lang.String getFirstName() {
      java.lang.Object ref = firstName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        firstName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string first_name = 3;</code>
     */
    public com.google.protobuf.ByteString
        getFirstNameBytes() {
      java.lang.Object ref = firstName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        firstName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string first_name = 3;</code>
     */
    public Builder setFirstName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      firstName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string first_name = 3;</code>
     */
    public Builder clearFirstName() {
      
      firstName_ = getDefaultInstance().getFirstName();
      onChanged();
      return this;
    }
    /**
     * <code>optional string first_name = 3;</code>
     */
    public Builder setFirstNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      firstName_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object lastName_ = "";
    /**
     * <code>optional string last_name = 4;</code>
     */
    public java.lang.String getLastName() {
      java.lang.Object ref = lastName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        lastName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string last_name = 4;</code>
     */
    public com.google.protobuf.ByteString
        getLastNameBytes() {
      java.lang.Object ref = lastName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        lastName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string last_name = 4;</code>
     */
    public Builder setLastName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      lastName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string last_name = 4;</code>
     */
    public Builder clearLastName() {
      
      lastName_ = getDefaultInstance().getLastName();
      onChanged();
      return this;
    }
    /**
     * <code>optional string last_name = 4;</code>
     */
    public Builder setLastNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      lastName_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object email_ = "";
    /**
     * <code>optional string email = 5;</code>
     */
    public java.lang.String getEmail() {
      java.lang.Object ref = email_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        email_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string email = 5;</code>
     */
    public com.google.protobuf.ByteString
        getEmailBytes() {
      java.lang.Object ref = email_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        email_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string email = 5;</code>
     */
    public Builder setEmail(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      email_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string email = 5;</code>
     */
    public Builder clearEmail() {
      
      email_ = getDefaultInstance().getEmail();
      onChanged();
      return this;
    }
    /**
     * <code>optional string email = 5;</code>
     */
    public Builder setEmailBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      email_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object phoneNumber_ = "";
    /**
     * <code>optional string phone_number = 6;</code>
     */
    public java.lang.String getPhoneNumber() {
      java.lang.Object ref = phoneNumber_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        phoneNumber_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string phone_number = 6;</code>
     */
    public com.google.protobuf.ByteString
        getPhoneNumberBytes() {
      java.lang.Object ref = phoneNumber_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        phoneNumber_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string phone_number = 6;</code>
     */
    public Builder setPhoneNumber(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      phoneNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string phone_number = 6;</code>
     */
    public Builder clearPhoneNumber() {
      
      phoneNumber_ = getDefaultInstance().getPhoneNumber();
      onChanged();
      return this;
    }
    /**
     * <code>optional string phone_number = 6;</code>
     */
    public Builder setPhoneNumberBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      phoneNumber_ = value;
      onChanged();
      return this;
    }

    private java.util.List<java.lang.Integer> places_ = java.util.Collections.emptyList();
    private void ensurePlacesIsMutable() {
      if (!((bitField0_ & 0x00000040) == 0x00000040)) {
        places_ = new java.util.ArrayList<java.lang.Integer>(places_);
        bitField0_ |= 0x00000040;
       }
    }
    /**
     * <code>repeated int32 places = 7;</code>
     */
    public java.util.List<java.lang.Integer>
        getPlacesList() {
      return java.util.Collections.unmodifiableList(places_);
    }
    /**
     * <code>repeated int32 places = 7;</code>
     */
    public int getPlacesCount() {
      return places_.size();
    }
    /**
     * <code>repeated int32 places = 7;</code>
     */
    public int getPlaces(int index) {
      return places_.get(index);
    }
    /**
     * <code>repeated int32 places = 7;</code>
     */
    public Builder setPlaces(
        int index, int value) {
      ensurePlacesIsMutable();
      places_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 places = 7;</code>
     */
    public Builder addPlaces(int value) {
      ensurePlacesIsMutable();
      places_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 places = 7;</code>
     */
    public Builder addAllPlaces(
        java.lang.Iterable<? extends java.lang.Integer> values) {
      ensurePlacesIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, places_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 places = 7;</code>
     */
    public Builder clearPlaces() {
      places_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000040);
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:booking.BookingRequest)
  }

  // @@protoc_insertion_point(class_scope:booking.BookingRequest)
  private static final com.twomen.backend.booking.BookingRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.twomen.backend.booking.BookingRequest();
  }

  public static com.twomen.backend.booking.BookingRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BookingRequest>
      PARSER = new com.google.protobuf.AbstractParser<BookingRequest>() {
    public BookingRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new BookingRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<BookingRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BookingRequest> getParserForType() {
    return PARSER;
  }

  public com.twomen.backend.booking.BookingRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

