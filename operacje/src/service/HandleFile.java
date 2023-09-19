package service;

import base.Purchase;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HandleFile {

    public static List<Purchase> loadData(Path pathToFile) {

        try (Stream<String> data = Files.lines(pathToFile, StandardCharsets.UTF_8)) {
            return data
                    .skip(1)
                    .map(HandleData::handleRowFromCSVFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("loadData exception: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
