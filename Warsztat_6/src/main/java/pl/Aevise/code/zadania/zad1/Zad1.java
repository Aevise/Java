package pl.Aevise.code.zadania.zad1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

//public class SneakyThrowsExample {
//  @SneakyThrows
//  public static void fileSize(Path path) {
//  System.out.println(Files.size(path));
//  }
//}
public class Zad1 {

    public static void fileSize(Path path){
        try {
            System.out.println(Files.size(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
