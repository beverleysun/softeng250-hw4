package src.hw4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileCreator{
    private Printer _printer = null;

    public FileCreator(String fileName) {
        try {
            File outputFile = new File(fileName);

            // Create new file
            if (outputFile.createNewFile()) {
                System.out.println("File created: " + fileName);

                // Try create a new file writer
                try {
                    FileWriter fileWriter = new FileWriter(fileName);
                    _printer = new Printer(fileWriter);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(0);
                }
            } else {
                System.out.println("File already exists.");
                System.exit(0);
            }
        } catch (IOException e) {
            System.out.println("An error occurred with creating " + fileName);
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void write(List<? extends Number> list, boolean newLine) {
        _printer.write(list, newLine);
    }

    public void write(String str, boolean newLine) {
        _printer.write(str, newLine);
    }

    public void closeOutputFile () {
        _printer.closeOutputFile();
    }
}
