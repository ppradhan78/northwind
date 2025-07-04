package com.springboot.northwind.restapi.utlity;

public class Utilityhelper {

    public static Integer getTitleOfCourtesy(String title) {
        switch (title) {
            case "Dr.":
                return 1;
            case "Mrs.":
                return 2;
            case "Ms.":
                return 3;
            default:
                return -1;

        }
    }
}
