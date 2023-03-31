import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class SQLScriptRunner {
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String USERNAME = "root";
    private static final String DATABASE = "TV3";
    private static final String PASSWORD = "";


    public void initSQLDatabase(){
        try {
            String url = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
            Connection connection = DriverManager.getConnection(url, USERNAME, PASSWORD);;
            Statement statement = connection.createStatement();

            BufferedReader reader = new BufferedReader(new FileReader("3_02327DatabaseScript1_2023.sql"));
            String line = reader.readLine();
            StringBuilder sql = new StringBuilder();

            while (line != null) {
                sql.append(line);
                if (line.endsWith(";")) {
                    statement.execute(sql.toString());
                    sql.setLength(0);
                }
                line = reader.readLine();
            }

            connection.close();
        }
        catch (Exception e) {
            System.out.println("SQL script execution failed: " + e.getMessage());
        }
    }


    public void runQueryReader(){
        Scanner scan = new Scanner(System.in); // Initialize scanner
        String url = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;

        System.out.println("Type your SQL query below");
        String query = scan.nextLine(); // Takes input

        try {
            Connection connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            while ( resultSet.next() ) {
                // Gets the information of the first 3 columns, and prints it out
                System.out.println(
                        resultSet.getString(1) + " " +
                                resultSet.getString(2) + " " +
                                resultSet.getString(3)
                );
            }
            connection.close(); // closes connection
        }
        catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage()); // Error message
        }
    }

    public void csvReader(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/uploads.csv"));
            String line = reader.readLine();

            while (line != null) {
                line = reader.readLine();
                System.out.println(line);
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
        }
        catch (IOException e) {
            System.out.println("IOException");
        }


    }
}
