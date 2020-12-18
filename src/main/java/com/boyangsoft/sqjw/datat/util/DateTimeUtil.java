package com.boyangsoft.sqjw.datat.util;

public class DateTimeUtil {

    public static String getStr(Object o){
        if(null ==o ){
            return "NULL";
        }
        return "'"+o.toString()+"'";
    }
}
