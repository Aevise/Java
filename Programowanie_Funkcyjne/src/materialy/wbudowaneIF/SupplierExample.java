package materialy.wbudowaneIF;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Integer> supplier1 = () -> 123;
        Supplier<Integer> supplier2 = SupplierExample::giveNumber;
        Supplier<String> supplier3 = SupplierExample::giveText;

        System.out.println(supplier1.get());
        System.out.println(supplier2.get());
        System.out.println(supplier3.get());
    }

    private static Integer giveNumber(){
        return 43567;
    }
    private static String giveText(){
        return "Text";
    }
}
