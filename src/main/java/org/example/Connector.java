package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    private static final String HOST = "localhost";

    private static final int PORT = "oooo";

    private static final String USERNAME = "root";

    private static final String DATABASE = "DatabaseNavn";

    private static final String PASSWORD = "password";

    private static final String DELIMITER = ";;";

    private Connection connection = null;

    Connector() {
        try {
            String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?serverTimezone=UTC";
            Connection connection = DriverManager.getConnection(ulr, USERNAME, PASSWORD);

            System.out.println ("Connection made");
        } catch (SQLExeption | IllegalArgumentException ex ) {
            ex.printStackTrace(System.err);
        } finally {
            if (connection == null) System.exit( -1);
        }
    }

    Connection getConnection(){return connection; }
}
