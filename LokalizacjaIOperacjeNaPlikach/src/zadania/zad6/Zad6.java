package zadania.zad6;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//Napisz program, który zastąpi zawartość pliku tym samym tekstem ale w całości napisanym wielką
//literą. Do wygenerowania zawartości pliku wykorzystaj https://pl.lipsum.com/.
public class Zad6 {
    public static void main(String[] args) {
        Path path = Paths.get("src/zadania/zad5/random.txt");
        writeUpperCaseToFile(path);

    }

    private static List<String> convertToUpperCase(Path path) {
        try{
            return Files.lines(path).map(String::toUpperCase).toList();
        }catch (IOException e){
            System.out.println(e);
        }
        return Collections.emptyList();
    }

    private static void writeUpperCaseToFile(Path path){
        List<String> uppercase = convertToUpperCase(path);
        try(
                BufferedWriter bufferedWriter = Files.newBufferedWriter(path)
                ){
            for (String text : uppercase) {
                bufferedWriter.write(text);
                bufferedWriter.newLine();
            }
        }catch (IOException e){
            System.out.println("error:\n" + e.getMessage());
        }
    }


}
