import java.util.Scanner;
import java.sql.*;

public class Main {
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String USERNAME = "root";
    private static final String DATABASE = "TV3";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
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
}