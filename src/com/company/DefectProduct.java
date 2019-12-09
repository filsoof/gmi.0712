package com.company;

import java.io.Serializable;

public class DefectProduct implements Serializable {

String title;
int id;
String model;
String hardware;
String diagnose;
int price;
int date;
int customerId;
int age;
String version;
String password;


    public DefectProduct(String title, int id, String model, String hardware, String diagnose, int price, int date, int customerId, int age, String version, String password) {
        this.title = title;
        this.id = id;
        this.model = model;
        this.hardware = hardware;
        this.diagnose = diagnose;
        this.price = price;
        this.date = date;
        this.customerId = customerId;
        this.age = age;
        this.version = version;
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DefectProduct{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", model='" + model + '\'' +
                ", hardware='" + hardware + '\'' +
                ", diagnose='" + diagnose + '\'' +
                ", price=" + price +
                ", date=" + date +
                ", customerId=" + customerId +
                ", age=" + age +
                ", version='" + version + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
