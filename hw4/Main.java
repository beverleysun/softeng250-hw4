package hw4;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        Scanner fileNameScanner = new Scanner(System.in);
        System.out.println("Enter your file name: ");
        String fileName = fileNameScanner.nextLine();

        try {
            AdjacencyList adjacencyList = new AdjacencyList(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}