package pliki.NIO2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class _Files {
    public static void main(String[] args) {
        Path path = Paths.get("hehe.txt");
        Path path2 = Paths.get("hehecopy.txt");
        System.out.println(Files.exists(path));
        System.out.println(path);

        try {
//            System.out.println(Files.copy(path, path2));
            List<String> stringList = Files.readAllLines(path);
            stringList.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
