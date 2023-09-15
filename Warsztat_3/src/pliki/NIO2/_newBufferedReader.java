package pliki.NIO2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _newBufferedReader {
    public static void main(String[] args) {
        Path path = Paths.get("hehe.txt");
        Path writingPath = Paths.get("hehenewCopy.txt");
        Path path1 = Paths.get("/src/pliki/NIO2");
        try(
                BufferedReader reader = Files.newBufferedReader(path);
                BufferedWriter writer = Files.newBufferedWriter(writingPath)
        ){
            String line = null;
            while((line = reader.readLine()) != null){
                System.out.println(line);
                writer.write(line);
            }
            System.out.println(Files.size(path));
            System.out.println(Files.getLastModifiedTime(path));
            System.out.println(Files.getOwner(path));
            System.out.println(Files.isDirectory(path));
            System.out.println(Files.isRegularFile(path));
            System.out.println(Files.isReadable(path));
            System.out.println(Files.isExecutable(path));

            Stream<Path> list = Files.list(path1);
            List<Path> absolutes = list
                    .filter(Files::isRegularFile)
                    .map(Path::toAbsolutePath)
                    .collect(Collectors.toList());
            System.out.println(absolutes);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
