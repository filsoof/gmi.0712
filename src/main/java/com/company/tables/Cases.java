package com.company.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Cases {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void displayData(ResultSet rs) throws SQLException {


        while (rs.next()) {

            StringBuffer buffer = new StringBuffer();
            buffer.append(ANSI_RED + "Case id: " + ANSI_RESET + rs.getInt("id")) ;
            buffer.append(ANSI_BLUE + "\nTitle: " + ANSI_RESET + rs.getString("title"));
            buffer.append(ANSI_BLUE + "\nModel: " + ANSI_RESET + rs.getString("model"));
            buffer.append(ANSI_BLUE + "\nHardware: " + ANSI_RESET + rs.getString("hardware"));
            buffer.append(ANSI_BLUE + "\nDiagnose: " + ANSI_RESET + rs.getString("diagnose"));
            buffer.append(ANSI_BLUE + "\nPrice: " + ANSI_RESET + rs.getInt("price")) ;
            buffer.append(ANSI_BLUE + "\nDate: " + ANSI_RESET + rs.getInt("date")) ;
            buffer.append(ANSI_BLUE + "\nCustomerId: " + ANSI_RESET + rs.getInt("customerid")) ;
            buffer.append(ANSI_BLUE + "\nAge of product: " + ANSI_RESET + rs.getInt("age")) ;
            buffer.append(ANSI_BLUE + "\nVersion: " + ANSI_RESET + rs.getString("version"));
            buffer.append(ANSI_BLUE + "\nPassword: " + ANSI_RESET + rs.getString("password"));




            System.out.println(buffer.toString());

        }


    }




}
