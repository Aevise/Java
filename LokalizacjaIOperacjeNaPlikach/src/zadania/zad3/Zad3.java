package zadania.zad3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//3. Napisz program, który na podstawie podanego pliku wydrukuje jego rozmiar w bajtach, kb, mb.
public class Zad3 {
    public static void main(String[] args) {
        Path path = Paths.get("src/zadania/zad1/hehe1.txt");

        if(Files.exists(path)){
            long lengthB = path.toFile().length();
            double lengthKB = (double)path.toFile().length()/1024;
            double lengthMB = (double)path.toFile().length()/1048576;

            System.out.println(lengthB);
            System.out.println(lengthKB);
            System.out.println(lengthMB);
        }
    }
}
