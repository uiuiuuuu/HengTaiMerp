package com.example.hengtaimerp.utils;


import org.springframework.util.ObjectUtils;
import org.thymeleaf.util.StringUtils;

public class StrUtils {
    public static boolean IsNull(Integer i) {
        if (i != null && i != 0) {
            return true;
        } else {
            return false;
        }


    }

    public static boolean IsNull(String s) {
        if (StringUtils.isEmpty(s)) {
            return false;
        } else {
            return true;
        }

    }

    public static boolean IsNull(Object o) {
        if (ObjectUtils.isEmpty(o)) {
            return false;
        } else {
            return true;
        }

    }
}
