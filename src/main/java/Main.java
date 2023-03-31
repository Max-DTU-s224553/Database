import java.util.Scanner;
import java.io.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        SQLScriptRunner scriptRunner = new SQLScriptRunner();
        //scriptRunner.initSQLDatabase(); // Runs the SQL initializing file

        //scriptRunner.csvReader(); // Prints the text in the uploads.csv file in the resources folder
        scriptRunner.runQueryReader(); // Runs the Java App that takes SQL Queries
    }
}