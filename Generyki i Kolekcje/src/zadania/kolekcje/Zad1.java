package zadania.kolekcje;

import java.util.*;

/*Wyobraź sobie, że idziesz do muzeum motoryzacji i wypisujesz sobie samochody, które chcesz tam
zobaczyć. Wypisujesz informacje takie jak: marka, model oraz rocznik. Idziesz tam z inną osobą i ona też
wypisuje swoje. Przedstaw to co napisaliście w postaci 2 list zawierających obiekty klasy Car. Klasa Car
ma posiadać pola brand, model oraz year. Następnie sklej ze sobą te 2 listy, tak aby wyeliminować
powtarzające się samochody, które dodaliście i przedstaw zawartość na ekranie posortowaną najpierw
po roku rosnąco, potem po marce rosnąco oraz po modelu rosnąco. Załóżmy, że taka byłaby kolejność
oglądania eksponatów w muzeum.
 */
public class Zad1 {

    public static void main(String[] args) {
        List<Car> carList1 = new ArrayList<>();
        carList1.add(new Car("BMW", "E36", 2020));
        carList1.add(new Car("BMW", "E36", 2021));
        carList1.add(new Car("BMW", "E23", 2020));
        carList1.add(new Car("BMW", "E36", 2020));
        carList1.add(new Car("Audi", "A6", 2022));
        carList1.add(new Car("Audi", "A5", 2022));
        carList1.add(new Car("Tarpan", "ProLife", 1942));

        List<Car> carList2 = new ArrayList<>();
        carList2.add(new Car("BMW", "E36", 2020));
        carList2.add(new Car("BMW", "E36", 2019));
        carList2.add(new Car("Audi", "A3", 2020));
        carList2.add(new Car("BMW", "E36", 2020));
        carList2.add(new Car("Audi", "A6", 2021));
        carList2.add(new Car("Audi", "A5", 2022));
        carList2.add(new Car("Tarpan", "ExtraLife", 1956));

        System.out.println(carList1);
        System.out.println(carList2);

        Set<Car> filterDuplicates = new LinkedHashSet<>(carList1);
        filterDuplicates.addAll(carList2);

        List<Car> mutualList = new ArrayList<>(filterDuplicates);

        System.out.println("Our mutual list is:\n" + mutualList);

        Comparator<Car> sortByYearAscending = (car1, car2) -> car1.getYear() - car2.getYear();
        Comparator<Car> sortByBrandAscending = (car1, car2) ->car1.getBrand().compareTo(car2.getBrand());
        Comparator<Car> sortByModelAscending = Comparator.comparing(car -> car.getModel());
        mutualList.sort(sortByYearAscending);
        System.out.println("sortByYearAscending:\n" + mutualList);
        mutualList.sort(sortByBrandAscending);
        System.out.println("sortByBrandAscending:\n" + mutualList);
        mutualList.sort(sortByModelAscending);
        System.out.println("sortByModelAscending:\n" + mutualList);

        Comparator<Car> chainSorting = sortByYearAscending
                .thenComparing(sortByBrandAscending)
                .thenComparing(sortByModelAscending);

        mutualList.sort(chainSorting);
        System.out.println("Visit Plan:\n" + mutualList);
    }


    public static class Car{
        private final String brand;
        private final String model;
        private final Integer year;

        public Car(String brand, String model, Integer year) {
            this.brand = brand;
            this.model = model;
            this.year = year;
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public Integer getYear() {
            return year;
        }

        @Override
        public String toString() {
            return brand + ", " + model +", " + year + "|";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Car car = (Car) o;
            return brand.equals(car.brand) && model.equals(car.model) && year.equals(car.year);
        }

        @Override
        public int hashCode() {
            return Objects.hash(brand, model, year);
        }
    }
}
