package materialy.wbudowaneIF;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {
        List<String> cities = new ArrayList<>();
        cities.add("Zakopane");
        cities.add("Warszawa");
        cities.add("Gdynia");
        cities.add("Szczecin");

        print(cities, city -> {
            System.out.println("Checking city: " + city);
            return city.contains("i");
        });
        System.out.println();
        print(cities, PredicateExample::checkCity);

    }

    private static boolean checkCity(String input){
        System.out.println("Calling checkCity with city: " + input);
        return input.contains("i");
    }

    private static void print(final List<String> cities, Predicate<String> checker){
        for (String city : cities) {
            if(checker.test(city)){
                System.out.println(city);
            }
        }
    }
}
