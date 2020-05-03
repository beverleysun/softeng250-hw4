package hw4;

import java.util.Scanner;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        Scanner fileNameScanner = new Scanner(System.in);
        System.out.println("Enter your input file name: ");
        String inputFileName = fileNameScanner.nextLine();
        AdjacencyList adjList = new AdjacencyList(inputFileName);

        System.out.println("Enter output file name (Cannot be an existing file name in the working directory): ");
        String outputFileName = fileNameScanner.nextLine();
        FileCreator outputFile= new FileCreator(outputFileName);

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

        // Output if graph has, at most, 3 cycles
        if (numCycles <= 3) {
            outputFile.write("Yes", false);
        } else {
            outputFile.write("No", false);
        }

        outputFile.closeOutputFile();
    }
}