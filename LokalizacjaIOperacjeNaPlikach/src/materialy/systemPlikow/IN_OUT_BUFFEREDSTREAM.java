package materialy.systemPlikow;

import java.io.*;
import java.util.Arrays;

public class IN_OUT_BUFFEREDSTREAM {

    public static void main(String[] args) throws IOException{

        File inputFile = new File("teoria.txt");
        File outputFile = new File("teoriaKopia3.txt");
        justCopyWithBuffer(inputFile, outputFile);
    }

    private static void justCopyWithBuffer(File inputFile, File outputFile) throws IOException {
        try (
                InputStream input = new BufferedInputStream(new FileInputStream(inputFile));
                OutputStream output = new BufferedOutputStream(new FileOutputStream(outputFile))
        ) {
            byte[] buffer = new byte[1024];
            int length = input.read(buffer);
            System.out.printf("Start buffered reading file: [%s]%n", inputFile);

            while (length > 0) {
                System.out.printf("Writing buffered values: [%s], chars: [%s]%n, length: [%s]",
                        byteArrToString(buffer),
                        toCharString(buffer),
                        length);
                output.write(buffer);
                output.flush();

                length = input.read(buffer);
            }
        }
    }

    private static void justCopyNoBuffer(File inputFile, File outputFile) throws IOException {
        try (
                InputStream input = new FileInputStream(inputFile);
                OutputStream output = new FileOutputStream(outputFile)
        ) {
            int value = input.read();
            System.out.printf("Start reading file: [%s]%n", inputFile);

            while (value != -1) {
//                System.out.printf("Writing value: [%s], char: [%s]%n", value, (char)value);
                output.write(value);
                value = input.read();
            }
        }
    }

    static String toCharString(byte[] input){
        char[] chars = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            chars[i] = (char)input[i];
        }
        return replaceNewLines(Arrays.toString(chars));
    }

    private static String replaceNewLines(String input) {
        return input.replace("\n", "\\n").replace("\r", "\\r");
    }

    static String byteArrToString(byte[] input){
        return replaceNewLines(Arrays.toString(input));
    }
}
