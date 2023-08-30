package zadania.lambda.zad3;
//Stwórz interface funkcyjny z metodą przyjmującą int, int oraz String i zwracającą String.
//Zaimplementuj ten interface przy wykorzystaniu lambdy. Spróbuj zapisać lambdę na parę
//pokazanych sposobów.
public class Zad3 {
    public static void main(String[] args) {
        Checkable checkable1 = (num1, num2, text) -> "text";
        Checkable checkable2 = (num1, num2, text) -> {
            return "text";
        };
        Checkable checkable3 = (Integer num1, Integer num2, String text) -> "text";
        Checkable checkable4 = (Integer num1, Integer num2, String text) -> {
            return "text";
        };
    }
}
