package hw4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Writes to a specified file
 */
public class Printer {
    private final FileWriter _fileWriter;

    public Printer(FileWriter fileWriter) {
        _fileWriter = fileWriter;
    }

    public void write(List<? extends Number> list, boolean newLine) {
        StringBuilder stringBuilder = new StringBuilder();

        // Create string representation of vertices with same in and out degrees
        for (Number integer: list) {
            stringBuilder.append(integer).append(" ");
        }

        String str = stringBuilder.toString();

        // Write string to output file
        try {
            _fileWriter.write(str.trim() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String str, boolean newLine) {
        try {
            if (newLine) {
                _fileWriter.write(str.trim() + "\n");
            } else {
                _fileWriter.write(str.trim());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeOutputFile () {
        try {
            _fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
