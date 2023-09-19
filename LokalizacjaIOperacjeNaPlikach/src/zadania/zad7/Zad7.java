package zadania.zad7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

//7. Napisz program, który zliczy ilość słów występujących w pliku. Do wygenerowania zawartości pliku
//wykorzystaj https://pl.lipsum.com/.
public class Zad7 {
    public static void main(String[] args) {
        Path path = Paths.get("src/zadania/zad5/random.txt");

        long words = countAllWords(path);
        System.out.println(words);
    }

    private static long countAllWords(Path path) {
        try {
            return Files.readAllLines(path).stream()
                    .map(s -> s.replaceAll("[^\\p{L}\\s]", ""))
                    .map(s -> s.split(" "))
                    .filter(s -> !Arrays.toString(s).equals("\n"))
                    .flatMap(Arrays::stream)
                    .count();
        } catch (IOException e) {
            System.out.println("Error:\n" + e.getMessage());
            return 0;
        }
    }
}
