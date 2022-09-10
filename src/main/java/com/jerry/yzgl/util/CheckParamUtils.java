package com.jerry.yzgl.util;

public class CheckParamUtils {
    public CheckParamUtils() {
    }
    public static boolean check(String params){
        if (params==null || params.equals("")){
            return false;
        }else {
            return true;
        }
    }
}
