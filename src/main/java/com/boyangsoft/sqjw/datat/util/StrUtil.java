package com.boyangsoft.sqjw.datat.util;

public class StrUtil {
    public static String getStr(Object o){
        if(null ==o ){
            return "''";
        }
        return "'"+o.toString()+"'";
    }
}
