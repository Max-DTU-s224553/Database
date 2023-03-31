public class Main {
    public static void main(String[] args) {
        ScriptRunner scriptRunner = new ScriptRunner();
        scriptRunner.csvReader(); // Reads the uploads.csv file, and inserts it into the 'Program' table
        scriptRunner.runQueryReader(); // Runs the Java App that takes SQL SELECT Queries
    }
}