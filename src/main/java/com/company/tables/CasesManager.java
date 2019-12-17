package com.company.tables;

import com.company.beans.Onecase;

import java.sql.*;

public class CasesManager {

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
            rs = stmt.executeQuery("SELECT * FROM cases");
            Cases.displayData(rs);


        } catch (
                SQLException e) {
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


    public static Onecase getRow(int caseId) throws SQLException {
        final String USERNAME = "root";
        final String PASSWORD = "root";
        final String CONN_STRING = "jdbc:mysql://localhost:8888/greenmind";

        String sql = "SELECT * FROM cases WHERE id = ?";
        ResultSet rs = null;

        try (

                Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1, caseId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Onecase bean = new Onecase();
                bean.setTitle(rs.getString("title"));
                bean.setId(caseId);
                bean.setModel(rs.getString("model"));
                bean.setHardware(rs.getString("hardware"));
                bean.setDiagnose(rs.getString("diagnose"));
                bean.setPrice(rs.getInt("price"));
                bean.setDate(rs.getInt("date"));
                bean.setCustomerId(rs.getInt("id"));
                bean.setAge(rs.getInt("age"));
                bean.setVersion(rs.getString("version"));
                bean.setPassword(rs.getString("password"));
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

    public static boolean insert(Onecase bean) throws Exception {


        final String USERNAME = "root";
        final String PASSWORD = "root";
        final String CONN_STRING = "jdbc:mysql://localhost:8888/greenmind";


        String sql = "INSERT into cases (title, id, model, hardware, diagnose, price, date, customerId, age, version, password) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ResultSet keys = null;


        try (

                Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            stmt.setString(1, bean.getTitle());
            stmt.setInt(2, bean.getId());
            stmt.setString(3, bean.getModel());
            stmt.setString(4, bean.getHardware());
            stmt.setString(5, bean.getDiagnose());
            stmt.setInt(6, bean.getPrice());
            stmt.setInt(7, bean.getDate());
            stmt.setInt(8, bean.getCustomerId());
            stmt.setInt(9, bean.getAge());
            stmt.setString(10, bean.getVersion());
            stmt.setString(11, bean.getPassword());
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
        } finally {

            if (keys != null) keys.close();

        }
        return true;
    }

    public static boolean delete(int caseId) throws Exception {


        final String USERNAME = "root";
        final String PASSWORD = "root";
        final String CONN_STRING = "jdbc:mysql://localhost:8888/greenmind";


        String sql = "DELETE FROM cases WHERE id =?";


        try (

                Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            stmt.setInt(1, caseId);
            int affected = stmt.executeUpdate();


            if (affected == 1) {
                return true;

            } else {
                return false;

            }

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }

    }

    public static boolean update(Onecase bean) throws Exception {

        final String USERNAME = "root";
        final String PASSWORD = "root";
        final String CONN_STRING = "jdbc:mysql://localhost:8888/greenmind";

        String sql = "UPDATE cases SET " +
                "diagnose = ?";


        try (

                Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {

            stmt.setString(1, bean.getDiagnose());



            int affected = stmt.executeUpdate();
            if (affected == 1) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }

    }


}

