package hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Main {

    public static void main(String args[]) {

        AdjacencyList adjList = null;
        Scanner fileNameScanner = new Scanner(System.in);

        System.out.println("Enter your input file name: ");
        String inputFileName = fileNameScanner.nextLine();

        // Try creating adjacency list representation of graph
        try {
            adjList = new AdjacencyList(inputFileName);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found");
            System.exit(0);
        }

        System.out.println("Enter output file name (Cannot be an existing file name in the working directory): ");
        String outputFileName = fileNameScanner.nextLine();
        Printer printer = null;

        // Try create new output file
        try {
            File outputFile = new File(outputFileName);
            if (outputFile.createNewFile()) {
                System.out.println("File created: " + outputFileName);

                // Try create a new file writer
                try {
                    FileWriter fileWriter = new FileWriter(outputFileName);
                    printer = new Printer(fileWriter);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(0);
                }
            } else {
                System.out.println("File already exists.");
                System.exit(0);
            }
        } catch (IOException e) {
            System.out.println("An error occurred with creating " + outputFileName);
            e.printStackTrace();
            System.exit(0);
        }

        List<DFS> dfsList= new ArrayList<DFS>();
        List<Integer> sameInOut = adjList.sameInOut(); // Vertices with the same in and out degree
        List<Double> averageInOut = adjList.averageInOut(); // Avg in and out degrees of all vertices

        // Write to output file
        printer.write(sameInOut);
        printer.write(averageInOut);


        /*
        Test for cycles
         */

        int numCycles = 0;
        Set<Cycle> allCycles = new HashSet<Cycle>();

        // Run DFS on all vertices
        for (int i = 0; i < adjList.getNumVertices(); i++){
            DFS dfs = new DFS(adjList, i);
            numCycles += dfs.getNumCycles();
            dfsList.add(dfs);
        }

        if (numCycles > 0) {
            printer.write("Cycle(s):");
            boolean alreadyPrinted = false;

            // Check each vertex's DFS
            for (DFS dfs: dfsList) {
                if (dfs.getNumCycles() > 0) {
                    Set<Cycle> cycles = dfs.getCycleSet(); // cycle set for each vertex
                    for (Cycle cycle: cycles){
                        allCycles.add(cycle);

                        // Print to file only one of the cycles
                        if (!alreadyPrinted) {
                            alreadyPrinted = true;
                            printer.write(cycle.toString());
                        }
                    }
                }

                numCycles = allCycles.size(); // Update num cycles for to include only unique cycles
            }
        } else { // No cycles, so there exists a topological order
            printer.write("Order:");
            printer.write(new TopologicalSort(adjList).getTopOrderStr());
        }

        printer.closeOutputFile();
    }
}