package projekt;

import projekt.base.Purchase;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static projekt.service.HandleData.groupPurchaseByCompany;
import static projekt.service.HandleFile.loadData;
import static projekt.service.HandleFile.storeDataSplitByCompany;

public class Main {
    private static final String FILE_LOCATION = "src/projekt/data/";
    private static final String FILE_NAME = "client-car-purchase-spreadsheet.csv";
    private static final String FILE_EXTENSION = ".txt";

    public static void main(String[] args) {
        Path pathToFile = Paths.get(FILE_LOCATION + FILE_NAME);

        //1
        List<Purchase> purchaseData = loadData(pathToFile);

        //2
        storeDataSplitByCompany(purchaseData, FILE_LOCATION, FILE_EXTENSION);
        
        storeSaleDataByCompanyAndModel(purchaseData);
    }

    private static void storeSaleDataByCompanyAndModel(List<Purchase> purchaseData) {
        Map<String, List<Purchase>> purchaseByCompany = groupPurchaseByCompany(purchaseData);

    }


}