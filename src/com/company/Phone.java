package com.company;

public class Phone extends DefectProduct {

    String screensize;


    public Phone(String title, int id, String model, String hardware, String diagnose, int price, int date, int customerId, int age, String version, String password, String screensize) {
        super(title, id, model, hardware, diagnose, price, date, customerId, age, version, password);


        this.screensize = screensize;
    }
}
