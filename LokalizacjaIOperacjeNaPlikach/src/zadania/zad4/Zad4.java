package zadania.zad4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

//4. Napisz program, który w podanym przez Ciebie katalogu znajdzie dowolny plik, z najstarszą i
//najmłodszą datą modyfikacji. Przeszukaj wszystkie pliki w katalogu, również te zagłębione.
public class Zad4 {
    public static void main(String[] args) {
        Path path = Paths.get("src/zadania/zad1");

        Path oldest = getOldestFile(path);
        Path youngest = getYoungestFiles(path);
        System.out.println(oldest);
        System.out.println(youngest);
    }

    private static Path getYoungestFiles(Path path) {
        try (Stream<Path> walk = Files.walk(path)) {
            return walk.filter(Files::isRegularFile)
                    .max(Comparator.comparingLong(file -> {
                        try {
                            return Files.getLastModifiedTime(file).toMillis();
                        } catch (IOException e) {
                            return 0;
                        }
                    }))
                    .orElse(path);
        } catch (IOException e) {
            System.out.println("error");
            return null;
        }
    }

    private static Path getOldestFile(Path path) {
        try (Stream<Path> walk = Files.walk(path)) {
            return walk.filter(Files::isRegularFile)
                    .min(Comparator.comparingLong(file -> {
                        try {
                            return Files.getLastModifiedTime(file).toMillis();
                        } catch (IOException e) {
                            return 0;
                        }
                    }))
                    .orElse(path);
        } catch (IOException e) {
            System.out.println("error");
            return null;
        }
    }
}
