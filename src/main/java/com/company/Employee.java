package com.company;

public class Employee {

    public String name;
    public String password;
    public int employeeId;


    public Employee (String name, String password, int employeeId) {
        this.name = name;
        this.password = password;
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public boolean verifyLogin(String username, String password) {
        if (username.equalsIgnoreCase("Peter") && password.equalsIgnoreCase("bangsvej") ) {
            return true; }
                    else {
                        return false;
            }

        }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", employeeId=" + employeeId +
                '}';
    }
}

