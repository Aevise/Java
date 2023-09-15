package materialy.resourceBundle.code;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Store", new Locale(args[0]));

        String mainPage = resourceBundle.getString("mainPage");
        String footer = resourceBundle.getString("footer");

        System.out.println(mainPage);
        System.out.println(footer);

        Map<String, String> collect = resourceBundle.keySet().stream()
                .collect(Collectors.toMap(key -> key, key -> resourceBundle.getString(key)));
        System.out.println(collect);
    }
}
