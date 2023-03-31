public class Main {
    public static void main(String[] args) {
        ScriptRunner scriptRunner = new ScriptRunner();
        //scriptRunner.initSQLDatabase(); // Runs the SQL initializing file

        scriptRunner.csvReader(); // Prints the text in the uploads.csv file in the resources folder
        //scriptRunner.runQueryReader(); // Runs the Java App that takes SQL Queries
    }
}