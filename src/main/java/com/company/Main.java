package com.company;

import com.company.beans.OneItem;
import com.company.beans.Onecase;
import com.company.tables.CasesManager;
import com.company.tables.ItemsManager;

import java.util.Scanner;
public class Main {
    private static Object ArrayList;
    private static DefectProduct DefectProduct;


    public static void main(String[] args) throws Exception {




            boolean loginflag = false;
            while (loginflag == false) {


                System.out.println("Enter username: ");
                Scanner myObj = new Scanner(System.in);
                String userName = myObj.nextLine();  // Read username input
                System.out.println("Enter password for user: " + userName);  // Output user input
                String userPassword = myObj.nextLine();  // Read userpassword input
                Employee employee = new Employee(userName, userPassword, 1);

                if (employee.verifyLogin(employee.getName(), employee.getPassword())) {
                    System.out.println("Successful log in!");
                    loginflag = true;
                } else {
                    System.out.println("Wrong credentials. Try to login again.");

                }
                while (loginflag) {

                    System.out.print("Type \"1\" to create a case." + System.lineSeparator() + "type \"2\" to create a item. " + System.lineSeparator() + "Type \"3\" to view list of cases. "
                            + System.lineSeparator() + "Type \"4\" to view inventory of items for sale. " + System.lineSeparator() + "Type \"5\" to delete item. "
                            + System.lineSeparator() + "Type \"6\" to delete case."
                            + System.lineSeparator() + "Type \"7\" to update diagnose on a case."
                            + System.lineSeparator() + "Type \"8\" to update price of an item.");
                    String choice = myObj.nextLine();  // Read username input

                    if (choice.equalsIgnoreCase("1")) {

                        Onecase bean = new Onecase();

                        System.out.println("Enter title: ");
                        String title = myObj.nextLine();
                        bean.setTitle(title);

                        System.out.println("Enter id: ");
                        int id = myObj.nextInt();
                        bean.setId(id);

                        System.out.println("Enter model: ");
                        String model = myObj.next();
                        bean.setModel(model);

                        System.out.println("Enter hardware: ");
                        String hardware = myObj.next();
                        bean.setHardware(hardware);

                        System.out.println("Enter diagnose: ");
                        String diagnose = myObj.next();
                        bean.setDiagnose(diagnose);

                        System.out.println("Enter price: ");
                        int price = myObj.nextInt();
                        bean.setPrice(price);

                        System.out.println("Enter date: ");
                        int date = myObj.nextInt();
                        bean.setDate(date);


                        System.out.println("Enter customer id: ");
                        int customerid = myObj.nextInt();
                        bean.setCustomerId(customerid);

                        System.out.println("Enter age of product: ");
                        int age = myObj.nextInt();
                        bean.setAge(age);

                        System.out.println("Enter version: ");
                        String version = myObj.next();
                        bean.setVersion(version);

                        System.out.println("Enter password: ");
                        String password = myObj.next();
                        bean.setPassword(password);



                        boolean result = CasesManager.insert(bean);

                        if (result) {
                            System.out.println("Added case with id :" + bean.getId() );
                        }
                    }
                    if (choice.equalsIgnoreCase("2")) {


                        OneItem bean = new OneItem();

                        System.out.println("Enter title: ");
                        String title = myObj.nextLine();
                        bean.setTitle(title);

                        System.out.println("Enter id: ");
                        int id = myObj.nextInt();
                        bean.setId(id);

                        System.out.println("Enter model: ");
                        String model = myObj.next();
                        bean.setModel(model);

                        System.out.println("Enter hardware: ");
                        String hardware = myObj.next();
                        bean.setHardware(hardware);

                        System.out.println("Enter price: ");
                        int price = myObj.nextInt();
                        bean.setPrice(price);

                        System.out.println("Enter age: ");
                        int age = myObj.nextInt();
                        bean.setAge(price);


                        boolean result = ItemsManager.insert(bean);

                        if (result) {
                            System.out.println("Added item: " + bean.getTitle() );
                        }

                    }
                    if (choice.equalsIgnoreCase("3")) {

                        CasesManager.displayAllRows();

                        System.out.println("Type in the case ID you want to view. See the above list for available cases: ");
                        int caseId = myObj.nextInt();
                        Onecase bean = CasesManager.getRow(caseId);

                        if (bean == null) {

                            System.err.println("No case were found with id: " + caseId);

                        } else {

                            System.out.println("Title: " + bean.getTitle());
                            System.out.println("Diagnose: " + bean.getDiagnose());
                            System.out.println("Hardware: " + bean.getHardware());
                            System.out.println("Model: " + bean.getModel());
                            System.out.println("Version: " + bean.getVersion());
                            System.out.println("Age of product: " + bean.getAge());
                            System.out.println("Date: " + bean.getDate());
                            System.out.println("Price: " + bean.getPrice());





                        }



                    }
                    if (choice.equalsIgnoreCase("4")) {

                        ItemsManager.displayAllRows();

                        System.out.println("Type in the ID of the item you want to view. See the above list for available items: ");
                        int itemId = myObj.nextInt();
                        OneItem bean = ItemsManager.getRow(itemId);

                        if (bean == null) {

                            System.err.println("No item were found with id: " + itemId);

                        } else {

                            System.out.println("Title: " + bean.getTitle());
                            System.out.println("Hardware: " + bean.getHardware());
                            System.out.println("Model: " + bean.getModel());
                            System.out.println("Age of product: " + bean.getAge());
                            System.out.println("Price: " + bean.getPrice());





                        }


                    }

                    if (choice.equalsIgnoreCase("5")) {

                        System.out.println("Type in the item ID you want to delete: ");
                        int itemId = myObj.nextInt();


                        if  (ItemsManager.delete(itemId)) {
                            System.out.println("Deleted successfully!");


                        } else {

                            System.out.println("Item does not exist! try another id. ");

                        }

                    }

                    if (choice.equalsIgnoreCase("6")) {

                        System.out.println("Type in the Case ID you want to delete: ");
                        int caseId = myObj.nextInt();


                        if  (CasesManager.delete(caseId)) {
                            System.out.println("Deleted successfully!");


                        } else {

                            System.out.println("Item does not exist! Try another id. ");

                        }

                    }


                    if (choice.equalsIgnoreCase("7")) {

                        System.out.println("Id of case to edit: ");
                        int caseId = myObj.nextInt();


                        Onecase bean = CasesManager.getRow(caseId);


                        String newDiagnose = myObj.next();


                        bean.setDiagnose(newDiagnose);

                        if  (CasesManager.update(bean)) {
                            System.out.println("Updated diagnose!");


                        } else {

                            System.out.println("Updated diagnose!! ");

                        }

                    }


                    if (choice.equalsIgnoreCase("8")) {

                        System.out.println("Id of item to edit: ");
                        int itemId = myObj.nextInt();


                        OneItem bean = ItemsManager.getRow(itemId);

                        System.out.println("Enter new price for item");
                        int newPrice = myObj.nextInt();


                        bean.setPrice(newPrice);

                        if  (ItemsManager.update(bean)) {
                            System.out.println("Updated diagnose!");


                        } else {

                            System.out.println("Updated diagnose!! ");

                        }

                    }

                    }
            }

        }
    }

