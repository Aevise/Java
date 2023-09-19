import base.Purchase;
import base.Samochod;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static service.HandleFile.loadData;

public class Main {
    private static final String FILE_LOCATION = "src/data/";
    private static final String FILE_NAME = "client-car-purchase-spreadsheet.csv";
    private static final String FILE_EXTENSION = ".txt";

    public static void main(String[] args) {
        Path pathToFile = Paths.get(FILE_LOCATION + FILE_NAME);

        //1
        List<Purchase> purchaseData = loadData(pathToFile);
        for (Purchase purchaseDatum : purchaseData) {
            System.out.println(purchaseDatum);
        }

        //2
        splitDataByCompany(purchaseData, FILE_EXTENSION);
    }

    public static void splitDataByCompany(List<Purchase> data, String extension) {
        List<String> carCompanies = getCompanyList(data);
        List<Samochod> collect = data.stream().map(Purchase::getSamochod)
                .sorted(Comparator.comparing(Samochod::getCar_company))
                .collect(Collectors.toList());
        for (Samochod samochod : collect) {
            System.out.println(samochod);
        }
        System.out.println(carCompanies);

    }

    private static List<String> getCompanyList(List<Purchase> data) {
        return data
                .stream()
                .map(Purchase::getSamochod)
                .map(Samochod::getCar_company)
                .sorted(Comparator.naturalOrder())
                .distinct()
                .collect(Collectors.toList());
    }
}