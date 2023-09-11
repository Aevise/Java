import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {

        int number = 1_234_567;
        Locale localePL = new Locale("pl", "PL");
        Locale localePL1 = new Locale("pl");
        Locale localePL2 = new Locale("PL");
        Locale localePL3 = new Locale("PL", "pl");
        Locale localeUS = new Locale("en", "US");
        Locale localeGER = Locale.GERMANY;

        System.out.println("NumberFormat.getInstance()");
        System.out.println("PL: " + NumberFormat.getInstance(localePL).format(number));
        System.out.println("US: " + NumberFormat.getInstance(localeUS).format(number));
        System.out.println("GER: " + NumberFormat.getInstance(localeGER).format(number));

        System.out.println("\nNumberFormat.getNumberInstance()");
        System.out.println("PL: " + NumberFormat.getNumberInstance(localePL).format(number));
        System.out.println("US: " + NumberFormat.getNumberInstance(localeUS).format(number));
        System.out.println("GER: " + NumberFormat.getNumberInstance(localeGER).format(number));

        System.out.println("\nNumberFormat.getPercentInstance()");
        System.out.println("PL: " + NumberFormat.getPercentInstance(localePL).format(number));
        System.out.println("US: " + NumberFormat.getPercentInstance(localeUS).format(number));
        System.out.println("GER: " + NumberFormat.getPercentInstance(localeGER).format(number));

        System.out.println("\nNumberFormat.getCurrencyInstance");
        System.out.println("PL: " + NumberFormat.getCurrencyInstance(localePL).format(number));
        System.out.println("US: " + NumberFormat.getCurrencyInstance(localeUS).format(number));
        System.out.println("GER: " + NumberFormat.getCurrencyInstance(localeGER).format(number));

        Locale.setDefault(new Locale("en", "US"));
        LocalDateTime localDateTime = LocalDateTime.of(2006, 5, 1, 16, 23, 58);
        localDateTime = localDateTime.minus(Period.of(1,1,1));
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        System.out.println("wynik: " + localDateTime.format(formatter));

        Locale.setDefault(new Locale("pl", "PL"));
        ResourceBundle bundle = ResourceBundle.getBundle("Zajavka", new Locale("en"));
        System.out.println(bundle.getString("name"));
        System.out.println(bundle.getString("value"));
    }
}