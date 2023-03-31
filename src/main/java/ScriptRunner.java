import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class ScriptRunner {
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

        System.out.println();
        System.out.print("Type your SQL query: ");
        String query = scan.nextLine(); // Takes input
        System.out.println();

        try {
            Connection connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int columnCount = resultSet.getMetaData().getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + " ");
                }
                System.out.println();
            }

            /*
            resultSet.last();
            int rowCount = resultSet.getRow();

            for(int i = 1; i <= rowCount; i++){
                resultSet.next();
                // Gets the information of the table, and prints it out
                for(int j = 1; j <= columnCount; j++){
                    System.out.print(resultSet.getString(j)+" ");
                }
                System.out.println();
            }
             */

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
            StringBuilder sql = new StringBuilder();

            while (line != null) {
                int i = 0;
                sql.append("(");
                for(String s: line.split(";") ){
                    if(i + 1 == line.split(";").length){
                        sql.append("'"+s+ "'");
                    }
                    else{
                        sql.append("'"+s+ "', ");

                    }
                    i++;
                }
                sql.append("),");
                sql.append("\n");
                line = reader.readLine();
            }

            sql.delete(sql.length() -2, sql.length()); // Deletes the last comma
            sql.append(";");

            //System.out.println(sql);
            executeInsertion(sql.toString());
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
        }
        catch (IOException e) {
            System.out.println("IOException");
        }


    }

    private void executeInsertion(String query){
        String url = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
        System.out.println("Insert the data into PROGRAM");

        try {
            Connection connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM Program");
            statement.executeUpdate("INSERT Program VALUES "+query);

            connection.close(); // closes connection
        }
        catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage()); // Error message
        }
    }
}