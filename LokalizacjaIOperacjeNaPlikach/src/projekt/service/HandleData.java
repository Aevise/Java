package projekt.service;

import projekt.base.Lokalizacja;
import projekt.base.Osoba;
import projekt.base.Purchase;
import projekt.base.Samochod;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
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

    public static String convertToCSV(String... args) {
        StringBuilder CSV = new StringBuilder("");
        for (String arg : args) {
            CSV.append(arg).append(",");
        }
        return CSV.deleteCharAt(CSV.length() - 1).toString();
    }

    static Map<String, Map<BigDecimal, BigDecimal>> getAverageIncomeByModel(Map.Entry<String, Map<String, List<Purchase>>> companySales) {
        Map<String, BigDecimal> totalIncomeByModel = extractTotalIncomeByModel(companySales);
        Map<String, BigDecimal> amountOfSoldModels = extractAmountOfSoldModels(companySales);

        Map<String, Map<BigDecimal, BigDecimal>> averagePriceByModel = new LinkedHashMap<>();
        for (String key : totalIncomeByModel.keySet()) {
            BigDecimal totalIncome = totalIncomeByModel.get(key);
            BigDecimal amountSold = amountOfSoldModels.get(key);

            if (amountSold != null && amountSold.compareTo(BigDecimal.ZERO) != 0) {
                Map<BigDecimal, BigDecimal> averagePriceToAmountSold = new LinkedHashMap<>();
                BigDecimal averagePrice = totalIncome.divide(amountSold, 2, RoundingMode.HALF_UP);
                averagePriceToAmountSold.put(averagePrice, amountSold);
                averagePriceByModel.put(key, averagePriceToAmountSold);
            }
        }
        return averagePriceByModel;
    }

    private static Map<String, BigDecimal> extractAmountOfSoldModels(Map.Entry<String, Map<String, List<Purchase>>> companySales) {
        return companySales.getValue().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> BigDecimal.valueOf(entry.getValue()
                                .size())));
    }

    private static Map<String, BigDecimal> extractTotalIncomeByModel(Map.Entry<String, Map<String, List<Purchase>>> companySales) {
        return companySales.getValue().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry
                                .getValue()
                                .stream()
                                .map(purchase -> purchase.getSamochod().getCar_price())
                                .reduce(BigDecimal.ZERO, BigDecimal::add)
                ));
    }

    static Map<String, Map<String, List<Purchase>>> groupSalesByCompanyAndModel(Map<String, List<Purchase>> purchaseByCompany) {
        return purchaseByCompany.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .collect(Collectors.groupingBy(purchase -> purchase.getSamochod().getCar_model()))
                ));
    }

    static List<String> prepareRaportEx3(Map<String, Map<String, List<Purchase>>> salesByCompanyAndModel) {
        //        for (Map.Entry<String, Map<String, List<Purchase>>> companySales : salesByCompanyAndModel.entrySet()) {
//            Map<String, Map<BigDecimal, BigDecimal>> averageIncomeByModel = getAverageIncomeByModel(companySales);
//            for (Map.Entry<String, Map<BigDecimal, BigDecimal>> stringMapEntry : averageIncomeByModel.entrySet()) {
//                Map<BigDecimal, BigDecimal> innerMap = stringMapEntry.getValue();
//                for (Map.Entry<BigDecimal, BigDecimal> entry : innerMap.entrySet()) {
//                    System.out.println(convertToCSV(String.valueOf(id.getAndIncrement()), companySales.getKey(), stringMapEntry.getKey(), entry.getKey().toString(), entry.getValue().toString()));
//                }
//            }
//        }
        AtomicInteger id = new AtomicInteger(1);
        return salesByCompanyAndModel.entrySet().stream()
                .flatMap(companySales -> getAverageIncomeByModel(companySales)
                        .entrySet().stream()
                        .flatMap(stringMapEntry -> stringMapEntry.getValue().entrySet().stream()
                                .map(entry -> convertToCSV(String.valueOf(id.getAndIncrement()),
                                        companySales.getKey(),
                                        stringMapEntry.getKey(),
                                        entry.getKey().toString(),
                                        entry.getValue().toString()))))
                .collect(Collectors.toList());
    }

    public static List<String> prepareRaportEx4(Map<LocalDate, Long> collect) {
        AtomicInteger id = new AtomicInteger(1);
        return collect.entrySet().stream()
                .map(entry ->
                        convertToCSV(String.valueOf(
                                        id.getAndIncrement()),
                                entry.getKey().toString(),
                                entry.getValue().toString()))
                .toList();
    }

    public static Map<LocalDate, Long> groupAmountOfSoldCarsByDate(List<Purchase> purchaseData) {
        Map<LocalDate, Long> amountOfSoldCarsByDate = purchaseData.stream()
                .collect(Collectors.groupingBy(
                        Purchase::getDate,
                        TreeMap::new,
                        Collectors.counting()
                ));
        return amountOfSoldCarsByDate;
    }


    static Map<LocalDate, Long> extractSoldCarsInDay(Map<LocalDate, Long> collect) {
        return collect.entrySet()
                .stream()
                .sorted(Map.Entry.<LocalDate, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue(),
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
