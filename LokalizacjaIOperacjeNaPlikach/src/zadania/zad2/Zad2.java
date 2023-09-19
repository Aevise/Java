package zadania.zad2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Wypisz na ekranie ścieżki wszystkich plików które zostały znalezione w podanej przez Ciebie
//ścieżce. Uwzględnij tylko te pliki tekstowe, które zawierają w swojej treści słowo zajavka. Dodaj
//możliwość podania rozszerzeń plików do pominięcia, gdyż niektóre z nich, np. .docx powodują błędy
//przy odczycie. Uwzględnij wszystkie pliki w katalogach zagnieżdżonych.
public class Zad2 {
    public static void main(String[] args) {
        Path path = Paths.get("src/zadania/zad1");
        String word = "zajavka";

        List<Path> list = filesContainingWord(path, word);
        for (Path path1 : list) {
            System.out.println(path1);
        }
    }

    private static List<Path> filesContainingWord(Path path, String word) {
        try (Stream<Path> walk = Files.walk(path)) {
            return walk.filter(Files::isRegularFile)
                    .filter(file -> file.toFile().canRead())
                    .filter(file -> {
                        try {
                            return Files.readAllLines(file)
                                    .stream()
                                    .anyMatch(content -> content.contains(word));
                        } catch (IOException e) {
                            return false;
                        }
                    })
                    .map(Path::toAbsolutePath)
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            System.out.println("error");
            return null;
        }
    }
}
