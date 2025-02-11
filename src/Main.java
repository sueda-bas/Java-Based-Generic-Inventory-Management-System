/**
 * The Main class serves as the entry point for the application.
 * It reads input from a file, processes commands, and writes output to a file.
 */
public class Main {

    /**
     * The main method is the entry point of the application.
     * It reads input from a file, processes each line, and executes commands.
     *
     * @param args the command line arguments where:
     *             args[0] is the input file path,
     *             args[1] is the output file path.
     */
    public static void main(String[] args) {
        String[] inputFile = FileInput.readFile(args[0], true, true);
        FileOutput.writeToFile(args[1], "", false, false);
        Management management = new Management();
        for (String line : inputFile){
            String[] parts = line.split("\t");
            management.manageCommand(parts, args);
        }
    }
}