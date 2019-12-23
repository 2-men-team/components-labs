package com.twomen.backend;

public class Config {
  public final static String HOST_IP;

  static {
    String hostIp = System.getenv("HOST_IP");
    HOST_IP = hostIp == null ? "localhost" : hostIp;
  }

  public static final String AUTH_API = "http://" + HOST_IP + ":9092/api";
  public static final String FILTERED_API = "http://" + HOST_IP + ":9090/api";
  public static final String NON_FILTERED_API = "http://" + HOST_IP + ":9091/api";
  public static final String BOOKING_API = "http://" + HOST_IP + ":9093/api";
}
