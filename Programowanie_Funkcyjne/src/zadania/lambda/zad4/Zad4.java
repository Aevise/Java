package zadania.lambda.zad4;

import zadania.lambda.zad3.Checkable;

//Dla porównania, zaimplementuj interface z poprzedniego ćwiczenia przy wykorzystaniu klasy
//implementującej interface, a nie lambdy.
public class Zad4{
    public static void main(String[] args) {
        Checkable checker = new Checkable() {
            @Override
            public String checker(Integer num1, Integer num2, String text) {
                return "Anonymous Class";
            }
        };
        Checkable checkerFromClass = new CheckableImpl();
    }

}
