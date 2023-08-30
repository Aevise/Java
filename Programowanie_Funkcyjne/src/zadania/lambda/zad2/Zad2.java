package zadania.lambda.zad2;
//Stwórz interface funkcyjny z metodą przyjmującą int i String i zwracającą String. Zaimplementuj ten
//interface przy wykorzystaniu lambdy. Spróbuj zapisać lambdę na parę pokazanych sposobów.
public class Zad2 {

    public static void main(String[] args) {
        Checkable checker1 = (Integer number, String string) -> "lamdba";
        Checkable checker2 = (Integer number, String string) -> {
            return "lamdba";
        };
        Checkable checker3 = (number, string) -> "lamdba";
        Checkable checker4 = (number, string) -> {
            return "lamdba";
        };
    }
}
