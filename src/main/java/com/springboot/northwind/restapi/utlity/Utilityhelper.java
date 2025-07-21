package com.springboot.northwind.restapi.utlity;

import com.springboot.northwind.restapi.infrastructure.DbConstant;

public class Utilityhelper {

    public static String getRegion(Integer regionId) {
        switch (regionId) {
            case 1:
                return DbConstant.Eastern;
            case 2:
                return DbConstant.Western;
            case 3:
                return DbConstant.Northern;
            case 4:
                return DbConstant.Southern;
            default:
                return "";
        }
    }
}
