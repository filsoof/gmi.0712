package com.company;

public class Customer {

        public String name;
        public int telephone;
        public String email;
        public  String adress;
        public int customerId;

   public Customer (String name, int telephone, String email, String adress, int customerId )
   {
        this.adress = adress;
        this.customerId = customerId;
        this.email = email;
        this.name = name;
        this.telephone = telephone;

   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
