package hw4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Printer {
    FileWriter _fileWriter;

    public Printer(FileWriter fileWriter) {
        _fileWriter = fileWriter;
    }


    public void writeSameInOut(List<Integer> sameInOutList) {

        StringBuilder stringBuilder = new StringBuilder();

        for (Integer integer: sameInOutList) {
            stringBuilder.append(integer + " ");
        }

        String sameInOutStr = stringBuilder.toString();
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
