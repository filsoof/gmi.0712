package com.company.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Items {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void displayData(ResultSet rs) throws SQLException {


        while (rs.next()) {

            StringBuffer buffer = new StringBuffer();
            buffer.append(ANSI_RED + "Item id: " + ANSI_RESET + rs.getInt("id")) ;
            buffer.append(ANSI_BLUE + "\nTitle: " + ANSI_RESET + rs.getString("title"));
            buffer.append(ANSI_BLUE + "\nModel: " + ANSI_RESET + rs.getString("model"));
            buffer.append(ANSI_BLUE + "\nHardware: " + ANSI_RESET + rs.getString("hardware"));
            buffer.append(ANSI_BLUE + "\nPrice: " + ANSI_RESET + rs.getInt("price")) ;
            buffer.append(ANSI_BLUE + "\nAge of product: " + ANSI_RESET + rs.getInt("age")) ;




            System.out.println(buffer.toString());

        }


    }




}
