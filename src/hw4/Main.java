package src.hw4;

import java.util.Scanner;
import java.util.List;

public class Main {
    private String inputFileName;
    private String outputFileName;
    private static final int NUM_TESTS = 28;
    private static final boolean TEST_MODE = false;

    public static void main(String[] args) {
        Main main = new Main();

        // Test cases and Test.java are not provided in submission
        // Run Main first, then run Test.java
        // Some tests will appear to fail, but the program only outputs one cycle.
        // It may not be the cycle that is expected.
        if (TEST_MODE) {
            for (int i = 1; i <= NUM_TESTS; i++) {
                main.inputFileName = "my-tests\\test" + i + ".txt";
                main.outputFileName = "my-tests\\test" + i + "_output.txt";
                main.process();
            }
        } else {
            Scanner fileNameScanner = new Scanner(System.in);

            // Get input file name
            System.out.println("Enter your input file name: ");
            main.inputFileName = fileNameScanner.nextLine();

            // Get output file name
            System.out.println("Enter output file name (Cannot be an existing file name in the working directory): ");
            main.outputFileName = fileNameScanner.nextLine();

            main.process();
        }
    }

    private void process() {
        AdjacencyList adjList = new AdjacencyList(inputFileName);
        FileCreator outputFile = new FileCreator(outputFileName);

        // Get data
        List<Integer> sameInOut = adjList.sameInOut(); // Vertices with the same in and out degree
        List<Double> averageInOut = adjList.averageInOut(); // Avg in and out degrees of all vertices
        DFS dfs = new DFS(adjList); // Test for cycles
        int numCycles = dfs.getNumCycles();

        // Write to output file
        outputFile.write(sameInOut, true);
        outputFile.write(averageInOut, true);

        if (numCycles > 0) {
            outputFile.write("Cycle(s):", true);
            outputFile.write(dfs.getOneCycleStr(), true);
        } else { // No cycles, so there exists a topological order
            outputFile.write("Order:", true);
            outputFile.write(new TopologicalSort(adjList).getTopOrderStr(), true);
        }

        if (numCycles <= 3) { // Output if graph has at most 3 cycles
            outputFile.write("Yes", false);
        } else {
            outputFile.write("No", false);
        }

        // Close
        outputFile.closeOutputFile();
    }
}