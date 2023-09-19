package zadania.zad1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Znajdź i wypisz na ekranie wszystkie pliki, które znajdują się w podanej przez Ciebie ścieżce oraz
//mają rozszerzenie zgodne z podanym przez Ciebie rozszerzeniem. Uwzględnij wszystkie pliki w
//katalogach zagnieżdżonych. Zaznaczę, że w zadaniu umieściliśmy pewien easter egg. Zadanie to
//może zostać rozwiązane przy wykorzystaniu metody Files.walk(), która nie została poruszona w
//materiałach. Żeby nie psuć sobie zabawy, spróbuj najpierw rozwiązać to zagadnienie samodzielnie,
//korzystając z metod poruszonych w materiałach - bez używania metody Files.walk() ὠ. Następnie
//zobacz przykładowe rozwiązanie i wykorzystanie metody Files.walk() zanim przejdziesz do
//kolejnych zadań ὠ.
public class Zad1 {

    public static void main(String[] args) {
        Path path = Paths.get("src/zadania/zad1");
        String extension = "txt";

        List<Path> filesWithExtension = findFilesWithExtension(path, extension);
        for (Path path1 : filesWithExtension) {
            System.out.println(path1);
        }

        List<Path> filesWithExtensionWalk = findFilesWithExtensionWalk(path, extension);
        System.out.println(filesWithExtensionWalk);
    }

    private static List<Path> findFilesWithExtensionWalk(Path path, String extension) {
        try (Stream<Path> walk = Files.walk(path)) {
            return walk.filter(Files::isRegularFile)
                    .filter(fileName -> fileName.toString().endsWith("." + extension))
                    .map(Path::toAbsolutePath)
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            System.out.println("error");
        }
        return null;
    }

    private static List<Path> findFilesWithExtension(Path path, String extension){
        List<Path> files = new ArrayList<>();
        File file_path = path.toFile();
        for (File listFile : file_path.listFiles()) {
            String fileName = listFile.getName();
            if (listFile.isFile() && fileName.endsWith(("." + extension))) {
                try {
                    files.add(listFile.toPath().toRealPath());
                } catch (IOException e) {
                    System.out.println("error");
                }
            } else if (listFile.isDirectory()) {
                files.addAll(findFilesWithExtension(listFile.toPath(), extension));
            }
        }
        return files;
    }
}
