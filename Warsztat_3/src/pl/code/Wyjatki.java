package pl.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Wyjatki {

    public static void main(String[] args) {
        Path path1 = Paths.get("someFile.txt");
        Path path2 = Paths.get("someNewFile.txt");
        try {
            example(path1, path2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        example2(path1, path2);
        System.out.println();
        exampleExceptionSuppression(path1, path2);
        System.out.println("KONIEC");
    }

    public static void example(final Path path1, final Path path2) throws IOException {
        try (
                BufferedReader in = Files.newBufferedReader(path1);
                BufferedWriter out = Files.newBufferedWriter(path2)
        ) {
            String line = in.readLine();
            out.write(line);
        }
//        System.out.println(in); out of scope
        System.out.println("SUCCESS");
    }

    public static void example2(final Path path1, final Path path2) {
        try (Door door = new Door()) {
            System.out.println("Opening door");
        } catch (IOException e) {
            System.out.println("Exception" + e.getMessage());
        } finally {
            System.out.println("Finally");
        }
    }

    static class Door implements AutoCloseable {
        public Door() {
            System.out.println("Door constructor");
        }

        @Override
        public void close() throws IOException {
            System.out.println("Door close");
            //idempotentność - tą samą metodę możemy wywołać dowolną ilość razy, a efekt zawsze będzie taki sam.
        }
    }

    public static void exampleExceptionSuppression(final Path path1, final Path path2) {
        try (Door2 door = new Door2()) {
            System.out.println("Openinng door2");
            throw new RuntimeException("Exception while opening Door");
        } catch (Exception e) {
            System.out.println("Main exception: " + e.getMessage());
            for (Throwable throwable : e.getSuppressed()) {
                System.out.println("Suppressed exception: " + throwable.getMessage());
            }
        } finally {
            throw new RuntimeException("Exception in Finally");
        }
    }

    static class Door2 implements AutoCloseable {
        public Door2() {
            System.out.println("Door2 constructor");
        }

        @Override
        public void close() throws IOException {
            System.out.println("Door2 close");
            throw new RuntimeException("Closing doors2");
            //idempotentność - tą samą metodę możemy wywołać dowolną ilość razy, a efekt zawsze będzie taki sam.
        }
    }
}
