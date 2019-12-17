package com.company;

public class Item {


    String title;
    int id;
    String model;
    String hardware;
    int price;
    int age;


    public Item(String title, int id, String model, String hardware, int price, int age) {
        this.title = title;
        this.id = id;
        this.model = model;
        this.hardware = hardware;
        this.price = price;
        this.age = age;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", model='" + model + '\'' +
                ", hardware='" + hardware + '\'' +
                ", price=" + price +
                ", age=" + age +
                '}';
    }
}
