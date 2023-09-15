package materialy.systemPlikow;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class IN_OUT_STREAM {
    public static void main(String[] args) throws IOException {

        System.out.println("Charset.default: " + Charset.defaultCharset());
        String someSentence = "żółć";
        byte[] bytes = someSentence.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes));

        File inputFile = new File("znak.jpg");
        File outputFile = new File("znakKopia.jpg");

        justCopyNoBuffer(inputFile, outputFile);

        byte[] bytes1 = "ą".getBytes(StandardCharsets.UTF_8);
        System.out.println("ą bytes: " + Arrays.toString(bytes1));

    }

    private static void justCopyNoBuffer(File inputFile, File outputFile) throws IOException {
        try (
                InputStream input = new FileInputStream(inputFile);
                OutputStream output = new FileOutputStream(outputFile)
        ) {
            int value = input.read();
            System.out.printf("Start reading file: [%s]%n", inputFile);

            while (value != -1){
//                System.out.printf("Writing value: [%s], char: [%s]%n", value, (char)value);
                output.write(value);
                value = input.read();
            }
        }
    }

}
