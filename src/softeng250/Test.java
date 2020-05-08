package src.softeng250;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Test {
    private static final int NUM_TESTS = 28;

    private static boolean checkResult(String expectedFile, String receivedFile) throws IOException {
        BufferedReader expectedBr = new BufferedReader(new FileReader(expectedFile));
        BufferedReader receivedBr = new BufferedReader(new FileReader(receivedFile));

        boolean passed = true;
        int line = 1;

        String expectedLine;
        String receivedLine;
        while (true) {
            expectedLine = expectedBr.readLine();
            receivedLine = receivedBr.readLine();

            if (expectedLine == null && receivedLine == null) {
                break;
            }

            if (!Objects.equals(expectedLine, receivedLine)) {
                System.out.println("L" + line + ": Expected '" + expectedLine + "', received '" + receivedLine + "'");
                passed = false;
            }
            line++;
        }

        expectedBr.close();
        receivedBr.close();

        return passed;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 28; i++) {
            try {
                System.out.println("Test: " + i);

                String outputFilename = "my-tests\\test" + i + "_output.txt";
                String expectedFilename = "my-tests\\test" + i + "_expected.txt";

                if (checkResult(expectedFilename, outputFilename)) {
                    System.out.println("Check passed!");
                }

                new File(outputFilename).delete();
            }
            catch (Exception e) {
                e.printStackTrace(System.out);
            }
            if (i < NUM_TESTS) {
                System.out.println();
            }
        }
    }
}
