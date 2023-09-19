package projekt.service;

import projekt.base.Lokalizacja;
import projekt.base.Osoba;
import projekt.base.Purchase;
import projekt.base.Samochod;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HandleData {
    public static Purchase handleRowFromCSVFile(String row) {
        String[] splitRow = row.split(",");

        BigDecimal id = BigDecimal.valueOf(Double.parseDouble(splitRow[0]));
        String firstName = splitRow[1];
        String lastName = splitRow[2];
        String email = splitRow[3];
        String ipAddress = splitRow[4];
        String color = splitRow[5];
        String carVin = splitRow[6];
        String carCompany = splitRow[7];
        String carModel = splitRow[8];
        String carModelYear = splitRow[9];
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(splitRow[10].replaceAll("\"", "").replaceAll("€", "")));
        String country = splitRow[11];
        String city = splitRow[12];
        LocalDate date = LocalDate.parse(splitRow[13]);

        return new Purchase(
                id,
                new Osoba(firstName,
                        lastName,
                        email,
                        ipAddress),
                new Samochod(color,
                        carVin,
                        carCompany,
                        carModel,
                        carModelYear,
                        price),
                new Lokalizacja(country,
                        city),
                date
        );
    }

    public static Map<String, List<Purchase>> groupPurchaseByCompany(List<Purchase> data) {
        return data
                .stream()
                .collect(Collectors.groupingBy(purchase -> purchase.getSamochod().getCar_company()));
    }

    public static List<String> getCompanyList(List<Purchase> data) {
        return data
                .stream()
                .map(Purchase::getSamochod)
                .map(Samochod::getCar_company)
                .sorted(Comparator.naturalOrder())
                .distinct()
                .collect(Collectors.toList());
    }

    public static String convertToCSV(Purchase purchase) {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                purchase.getId(),
                purchase.getOsoba().getFirst_name(),
                purchase.getOsoba().getLast_name(),
                purchase.getOsoba().getEmail(),
                purchase.getOsoba().getIp_address(),
                purchase.getSamochod().getColor(),
                purchase.getSamochod().getCar_vin(),
                purchase.getSamochod().getCar_company(),
                purchase.getSamochod().getCar_model(),
                purchase.getSamochod().getCar_model_year(),
                purchase.getSamochod().getCar_price(),
                purchase.getLokalizacja().getCountry(),
                purchase.getLokalizacja().getCity(),
                purchase.getDate()
        );
    }
}
