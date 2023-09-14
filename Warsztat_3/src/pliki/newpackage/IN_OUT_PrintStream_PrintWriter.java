package pliki.newpackage;

import java.io.*;

public class IN_OUT_PrintStream_PrintWriter {
    public static void main(String[] args) throws IOException{

        OutputStream stream = new BufferedOutputStream(new FileOutputStream("hmhm"));

        File file = new File("hefgde.txt");
        try (
                PrintWriter writer = new PrintWriter(
                        new BufferedWriter(
                                new FileWriter(file)
                        )
                )
        ) {
            writer.print(1L);
            writer.write(String.valueOf(5L));
            Car car = new Car("Mruczek");
            writer.print(car);
            writer.println();
            writer.println("not hehe");
            writer.printf("hehe: [%s]", new Car("Wojtek"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}