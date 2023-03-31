public class Main {
    public static void main(String[] args) {
        ScriptRunner scriptRunner = new ScriptRunner();
        //scriptRunner.initSQLDatabase(); // Runs the SQL initializing file

        scriptRunner.csvReader(); // Reads the uploads.csv file, and inserts it into the database
        scriptRunner.runQueryReader(); // Runs the Java App that takes SQL SELECT Queries
    }
}