package materialy.systemPlikow.nio2;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInterface {
    public static void main(String[] args) {
//      NIO - non-blocking I/O
//      URI - Uniform Resource Identifier

        Path path = Paths.get("hehe.txt");
        Path path3 = Paths.get("C:/");
        Path path1 = Paths.get("src", "pliki", "NIO2", "someFile.txt");
        System.out.println(path1);
        FileSystem fileSystem = FileSystems.getDefault();
        System.out.println(fileSystem);

        try {
            Path path2 = Paths.get(new URI("file://src/pliki/NIO2/someFile.txt"));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        System.out.println(path.toAbsolutePath());
        System.out.println(path.isAbsolute());
        System.out.println(path.getNameCount());
        System.out.println(path3.getFileName());
        System.out.println(path3.getParent());
        try {
            System.out.println(path.toRealPath()); // sprawdza czy sciezka faktycznie istnieje na dysku
        } catch (IOException e) {
            System.out.println("nie poszlo");
        }

    }
}
