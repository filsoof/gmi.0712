package com.company.tables;

import com.company.beans.OneItem;

import java.sql.*;

public class ItemsManager {
    public static void displayAllRows() throws SQLException {
        final String USERNAME = "root";
        final String PASSWORD = "root";
        final String CONN_STRING = "jdbc:mysql://localhost:8888/greenmind";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Successfully connected to MYSQL database!");

            stmt = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM items");
            Items.displayData(rs);


        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            if (rs != null) {

                rs.close();
            }
            if (stmt != null) {

                stmt.close();
            }

            if (conn != null) {

                conn.close();
            }
        }

    }








    public static OneItem getRow(int caseId) throws SQLException {
        final String USERNAME = "root";
        final String PASSWORD = "root";
        final String CONN_STRING = "jdbc:mysql://localhost:8888/greenmind";

        String sql = "SELECT * FROM items WHERE id = ?";
        ResultSet rs = null;

        try (

                Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

                PreparedStatement stmt = conn.prepareStatement(sql);
        ){
            stmt.setInt(1, caseId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                OneItem bean = new OneItem();
                bean.setTitle(rs.getString("title"));
                bean.setId(caseId);
                bean.setModel(rs.getString("model"));
                bean.setHardware(rs.getString("hardware"));
                bean.setPrice(rs.getInt("price"));
                bean.setAge(rs.getInt("age"));

                return bean;
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            if (rs != null) {
                rs.close();
            }
        }

    }

    public static boolean insert(OneItem bean) throws Exception {


        final String USERNAME = "root";
        final String PASSWORD = "root";
        final String CONN_STRING = "jdbc:mysql://localhost:8888/greenmind";



        String sql = "INSERT into items (title, id, model, hardware, price, age) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        ResultSet keys = null;


        try (

                Connection  conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            stmt.setString(1, bean.getTitle());
            stmt.setInt(2, bean.getId());
            stmt.setString(3, bean.getModel());
            stmt.setString(4, bean.getHardware());
            stmt.setInt(5, bean.getPrice());
            stmt.setInt(6, bean.getAge());
            int affected = stmt.executeUpdate();


            if (affected == 1) {
                keys = stmt.getGeneratedKeys();
                keys.next();
                int newKey = keys.getInt(1);
                bean.setId(newKey);

            } else {
                System.err.println("no rows affected");
                return false;

            }

        } catch (SQLException e) {

            //Den viser en fejl selvom den indsætter det rigtigt.
            // Til gengæld er det dumt at udkommenterer system.err fordi hvis man f.eks laver en dupplicate,
            // så får man det ikke vide medmindre den er til stede...
            System.err.println(e);
            return false;
        } finally{

            if (keys != null) keys.close();

        }
        return true;
    }




}