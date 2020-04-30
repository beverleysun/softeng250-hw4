package hw4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Writes to a specified file
 */
public class Printer {
    FileWriter _fileWriter;

    public Printer(FileWriter fileWriter) {
        _fileWriter = fileWriter;
    }


    public void write(List<? extends Number> sameInOutList) {

        StringBuilder stringBuilder = new StringBuilder();

        // Create string representation of vertices with same in and out degrees
        for (Number integer: sameInOutList) {
            stringBuilder.append(integer + " ");
        }

        String sameInOutStr = stringBuilder.toString();

        // Write string to output file
        try {
            _fileWriter.write(sameInOutStr.trim() + "\n");
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
