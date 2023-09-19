package zadania.zad5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.stream.Collectors;

//5. Napisz program, który znajdzie drugie najdłuższe słowo i drugie słowo o długości 3 w podanym
//przez Ciebie pliku. Do wygenerowania zawartości pliku wykorzystaj https://pl.lipsum.com/.
public class Zad5 {
    public static void main(String[] args) {
        Path path = Paths.get("src/zadania/zad5/random.txt");
        int length = 3;

        Optional<String> secondLongestWord = findSecondLongestWord(path);
        Optional<String> secondWordBasedOnLength = secondWordBasedOnLength(path, length);

        System.out.println(secondLongestWord);
        System.out.println(secondWordBasedOnLength);
    }

    private static Optional<String> secondWordBasedOnLength(Path path, int length) {
        try {
            LinkedHashSet<String> strings = getStrings(path);
            return strings.stream()
                    .filter(s -> s.length() == length)
                    .skip(1)
                    .findFirst();
        } catch (IOException e) {
            System.out.println("error:\n" + e);
            return Optional.empty();
        }
    }


    private static Optional<String> findSecondLongestWord(Path path) {
        try {
            LinkedHashSet<String> collect = getStrings(path);

            return collect.stream()
                    .sorted(Comparator
                            .comparing(String::length,
                                    Comparator.reverseOrder()))
                    .skip(1)
                    .findFirst();
        } catch (IOException e) {
            System.out.println("error:\n" + e);
            return Optional.empty();
        }
    }

    private static LinkedHashSet<String> getStrings(Path path) throws IOException {
        return Files.readAllLines(path).stream()
                .map(s -> s.replaceAll("[^\\p{L}\\s]", ""))
                .map(s -> s.split(" "))
                .filter(s -> !Arrays.toString(s).equals("\n"))
                .flatMap(Arrays::stream)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
