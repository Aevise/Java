package zadania.comparing;
//Stwórz klasę Employee, która będzie zawierała pola takie jak, imię, nazwisko, wiek oraz wypłata.
//Stwórz 10 takich pracowników i dodaj ich do listy. Zaimplementuj metodę compareTo(), która
//posortuje pracowników odpowiednio po: imieniu rosnąco, nazwisku malejąco, wieku rosnąco,
//wypłacie malejąco. Następnie zaimplementuj Comparator, który posortuje pracowników
//odpowiednio po: imieniu malejąco, nazwisku malejąco, wieku rosnąco, wypłacie rosnąco. Na koniec
//zaimplementuj Comparator, który posortuje pracowników w kolejności odwrotnej niż poprzedni
//komparator.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Zad1 {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Adam", "Dsea", 21, 2543.32));
        employeeList.add(new Employee("Adam", "Dsea", 21, 2306.32));
        employeeList.add(new Employee("Bartek", "Hehe", 42, 23754.31));
        employeeList.add(new Employee("Stanisław", "Marzec", 64, 2343.32));
        employeeList.add(new Employee("Stanisław", "Marzec", 22, 2343.32));
        employeeList.add(new Employee("Stanisław", "Marzec", 22, 23438.32));
        employeeList.add(new Employee("Stanisław", "Marzec", 22, 234399.32));
        employeeList.add(new Employee("Stanisław", "Marzec", 54, 2343.32));
        employeeList.add(new Employee("Stanisław", "Kwiecień", 54, 2343.32));
        employeeList.add(new Employee("Stanisław", "NotHehe", 63, 857.31));
        employeeList.add(new Employee("MArian", "Dsea", 25, 2343.31));
        employeeList.add(new Employee("Zbyszek", "Truchło", 43, 4223.32));
        employeeList.add(new Employee("Andrzej", "Marianocito", 14, 2331.32));
        employeeList.add(new Employee("Borubvar", "Barbarian", 67, 6423.31));
        employeeList.add(new Employee("Miłosz", "Korczak", 34, 2413.31));
        employeeList.add(new Employee("Kamil", "Polak", 64, 23645.12));

        Comparator<Employee> sortNameDescending = ((employee1, employee2) -> employee2.getName().compareTo(employee1.getName()));
        Comparator<Employee> sortSurnameDescending = ((employee1, employee2) -> employee2.getSurname().compareTo(employee1.getSurname()));
//        Comparator<Employee> sortAgeAscending = ((employee1, employee2) -> employee1.getAge() - employee2.getAge());
        Comparator<Employee> sortAgeAscending = Comparator.comparingInt(employee -> employee.getAge());
        Comparator<Employee> sortSalaryAscending = Comparator.comparingDouble(employee -> employee.getSalary());

        Comparator<Employee> chainCompare = sortNameDescending
                .thenComparing(sortSurnameDescending)
                .thenComparing(sortAgeAscending)
                .thenComparing(sortSalaryAscending);

        Comparator<Employee> chainCompareReversed = sortNameDescending.reversed()
                .thenComparing(sortSurnameDescending).reversed()
                .thenComparing(sortAgeAscending).reversed()
                .thenComparing(sortSalaryAscending).reversed();

//        Collections.sort(employeeList);
        employeeList.sort(chainCompareReversed);
        System.out.println(employeeList);
    }
}
