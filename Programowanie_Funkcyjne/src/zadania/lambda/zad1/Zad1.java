package zadania.lambda.zad1;

//Stwórz interface funkcyjny z metodą przyjmującą int i zwracającą String. Zaimplementuj ten
//interface przy wykorzystaniu lambdy. Spróbuj zapisać lambdę na parę pokazanych sposobów
public class Zad1 {

    public static void main(String[] args) {
        Checkable checkable1 = number -> "number";
        Checkable checkable2 = number -> {
            if(number%2 == 0){
                return "Even";
            }
            return "Odd";
        };
        Checkable checkable3 = (number) -> {
            if(number%2 == 0){
                return "Even";
            }
            return "Odd";
        };
        Checkable checkable4 = (Integer number) -> {
            if(number%2 == 0){
                return "Even";
            }
            return "Odd";
        };

        System.out.println(checkable1.checker(534));
        System.out.println(checkable2.checker(2));
        System.out.println(checkable3.checker(1));
        System.out.println(checkable4.checker(4));
    }

}
