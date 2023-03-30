package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;

public class Connector {
    private static final String HOST = "localhost";

    private static final String PORT = "3306";

    private static final String USERNAME = "root";

    private static final String DATABASE = "TV3";

    private static final String PASSWORD = " ";

    private static final String DELIMITER = ";;";

    private Connection connection = null;

    public void Connector() {
        String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?characterEncoding=" + connection;
        try {
            Scanner scanner = new Scanner(System.in, "CP850"); //Western Europe Console CodePage
            System.out.println("Type sql manipulation: ");
            String sqlManipulation = scanner.nextLine();
            scanner.close();
            // Get a connection.
            Connection connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
            // Create and execute Update.
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlManipulation);
            ResultSet resultSet = statement.executeQuery(sqlManipulation);
            while( resultSet.next() ){
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
            }
            // Close connection.
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}