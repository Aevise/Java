package materialy.systemPlikow;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IN_OUT_WRITER_READER {
    public static void main(String[] args) throws IOException {

        File inputFile = new File("teoria.txt");
        File outputFile = new File("teoriaKopia3.txt");

        List<String> fileRead = readFile(inputFile, outputFile);
        fileRead.forEach(System.out::println);

    }

    private static List<String> readFile(final File inputFile, final File outputFile) throws IOException {
        List<String> fileContent = new ArrayList<>();
        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile, StandardCharsets.UTF_8));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, StandardCharsets.UTF_8))
        ) {
            String line = reader.readLine();
             while (line != null){
                 writer.write(line + "\n");
                 fileContent.add(line);
                 line = reader.readLine();
             }
        }
        return fileContent;
    }


    private static String replaceNewLines(String input) {
        return input.replace("\n", "\\n").replace("\r", "\\r");
    }

    static String byteArrToString(byte[] input) {
        return replaceNewLines(Arrays.toString(input));
    }
}
