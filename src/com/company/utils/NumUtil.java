package com.company.utils;

import static com.company.constant.Constant.ROME_MAP_10;

public class NumUtil {

    public static boolean isArabianNumber(String line){

        if(StrUtil.isEmpty(line)){
            return false;
        }

        for (int i = 0; i < line.length(); i++) {
            if(!Character.isDigit(line.charAt(i)));
            return false;
        }
        return true;
    }

    public static boolean isRomeNumber(String line){

        if(StrUtil.isEmpty(line)){
            return false;
        }

        return ROME_MAP_10.containsValue(line.toUpperCase());
    }



}
