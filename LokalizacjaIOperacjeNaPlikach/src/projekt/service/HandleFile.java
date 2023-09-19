package projekt.service;

import projekt.base.Purchase;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static projekt.service.HandleData.groupPurchaseByCompany;

public class HandleFile {
    public static final String HEADER = "id,first_name,last_name,email,ip_address,color,car_vin,car_company,car_model,car_model_year,car_price,country,city,date";

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

    public static void storeDataSplitByCompany(List<Purchase> purchaseData, String fileDestination, String fileExtension) {
        Map<String, List<Purchase>> purchaseByCompany = groupPurchaseByCompany(purchaseData);

        for (Map.Entry<String, List<Purchase>> purchase : purchaseByCompany.entrySet()) {
            Path companyFile = Paths.get(fileDestination,  (purchase.getKey() + fileExtension));
            List<String> data = purchase.getValue().stream().map(HandleData::convertToCSV).toList();
            saveToFile(data, HEADER, companyFile);
        }
    }

    private static void saveToFile(List<String> data, String header, Path destination) {
        try (BufferedWriter writer = Files.newBufferedWriter(destination, StandardCharsets.UTF_8)) {
            writer.write(header);
            writer.newLine();
            writer.flush();

            for (String purchase : data) {
                writer.write(purchase);
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            System.out.println("saveToFile error: " + e.getMessage());
        }
        System.out.println("Success: " + destination + " size: " + readFileSize(destination));
    }

    private static long readFileSize(Path path){
        try {
            return Files.size(path);
        } catch (IOException e) {
            System.out.println("readFileSize exception: " + e.getMessage());
            return 0;
        }
    }

//            List<String> carCompanies = getCompanyList(purchaseData);
//        List<Samochod> collect = purchaseData.stream().map(Purchase::getSamochod)
//                .sorted(Comparator.comparing(Samochod::getCar_company))
//                .toList();
//
//        System.out.println(carCompanies);
}
