package com.example.base;

/**
 * Created by admin on 2015/6/21.
 */
public class BaseConfig {
    public static final String api = "http://192.168.1.103:8080/Cinema";
    public static final String MODEL_PARKET_NAME = "com.example.model.";
    public static final class RequestPath{
        public static final String USER_REQUEST = "/manager/UserServlet";
    }
    public static final class RequestMethod{
        public static final String GETALLDRIVERS = "getAllDrivers";
        public static final String LOGIN = "login";
    }

}
