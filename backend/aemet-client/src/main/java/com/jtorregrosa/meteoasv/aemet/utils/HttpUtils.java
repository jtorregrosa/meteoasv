package com.jtorregrosa.meteoasv.aemet.utils;

public class HttpUtils {
    public static boolean isStatusCodeSuccessful(int statusCode) {
        return (statusCode >= 200) && (statusCode <= 299);
    }
}
