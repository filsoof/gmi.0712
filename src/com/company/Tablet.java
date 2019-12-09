package com.company;

public class Tablet extends DefectProduct {


    boolean Ipad;

    public Tablet(String title, int id, String model, String hardware, String diagnose, int price, int date, int customerId, int age, String version, String password, boolean Ipad) {

        super(title, id, model, hardware, diagnose, price, date, customerId, age, version, password);

        this.Ipad = Ipad;


    }



}
