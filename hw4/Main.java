package hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        Scanner fileNameScanner = new Scanner(System.in);

        System.out.println("Enter your input file name: ");
        String inputFileName = fileNameScanner.nextLine();

        System.out.println("Enter output file name (Cannot be an existing file name in the working directory): ");
        String outputFileName = fileNameScanner.nextLine();
        Printer printer;

        // try create new output file
        try {
            File outputFile = new File(outputFileName);
            if (outputFile.createNewFile()) {
                System.out.println("File created: " + outputFileName);

                // try create a new file writer
                try {
                    FileWriter fileWriter = new FileWriter(outputFileName);
                    printer = new Printer(fileWriter);
                } catch (IOException e) {
                    e.printStackTrace();
                    printer = null;
                }

            } else {
                System.out.println("File already exists.");
                printer = null;
            }
        } catch (IOException e) {
            System.out.println("An error occurred with creating " + outputFileName);
            e.printStackTrace();
            printer = null;
        }

        // main execution for the homework, try creating adjacency list representation of graph
        try {
            AdjacencyList adjacencyList = new AdjacencyList(inputFileName);

            List<Integer> sameInOut = adjacencyList.sameInOut();
            printer.writeSameInOut(sameInOut);

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found");
        }

        if (printer != null){
            printer.closeOutputFile();
        }
    }
}