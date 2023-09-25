package pl.zajavka;

import org.jsoup.Jsoup;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        System.out.println(Jsoup.connect("https://app.zajavka.pl").get().title());
    }
}