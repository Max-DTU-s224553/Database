import java.util.Scanner;
import java.io.*;
import java.sql.*;

public class Main {
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String USERNAME = "root";
    private static final String DATABASE = "TV3";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        SQLScriptRunner scriptRunner = new SQLScriptRunner();

        //scriptRunner.initSQLDatabase(); // Runs the SQL initializing file
        scriptRunner.runQueryReader(); // Runs the Java App that takes SQL Queries
    }
}