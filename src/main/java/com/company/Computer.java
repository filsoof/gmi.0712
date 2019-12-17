package com.company;

public class Computer extends DefectProduct {
String processor;
String graphicscard;

    public Computer(String title, int id, String model, String hardware, String diagnose, int price, int date, int customerId, int age, String version, String password, String processor, String graphicscard) {
        super(title, id, model, hardware, diagnose, price, date, customerId, age, version, password);


        this.graphicscard = graphicscard;
        this.processor = processor;


    }
}
