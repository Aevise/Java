package projekt;

import projekt.base.Purchase;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static projekt.service.HandleFile.loadData;
import static projekt.service.HandleFile.sortByCarsSoldInDay;

public class Main {
    private static final String FILE_LOCATION = "src/projekt/data/";
    private static final String FILE_NAME = "client-car-purchase-spreadsheet.csv";
    private static final String FILE_EXTENSION = ".txt";

    public static void main(String[] args) {
        Path pathToFile = Paths.get(FILE_LOCATION + FILE_NAME);
        String headerEx3 = "id, car_company, car_model, average_price, amount_sold";
        String headerEx4_1 = "id, date, cars_sold";
        String headerEx4_2 = "id, date, cars_sold";
        //1
        List<Purchase> purchaseData = loadData(pathToFile);

        //2
//        storeDataSplitByCompany(purchaseData, FILE_LOCATION, FILE_EXTENSION);
//
//        //3
//        storeSaleDataByCompanyAndModel(purchaseData, headerEx3, Paths.get(FILE_LOCATION + ("Ex2" + FILE_EXTENSION)));

        //4
//        sortDataByDate(purchaseData, headerEx4_1, Paths.get(FILE_LOCATION + ("Ex4_1" + FILE_EXTENSION)));
        sortByCarsSoldInDay(purchaseData, headerEx4_2, Paths.get(FILE_LOCATION + ("Ex4_2" + FILE_EXTENSION)));
    }

}