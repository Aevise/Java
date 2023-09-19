package service;

import base.Lokalizacja;
import base.Osoba;
import base.Purchase;
import base.Samochod;

import java.math.BigDecimal;
import java.time.LocalDate;

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
}
