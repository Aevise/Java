package materialy.wbudowaneIF;

import java.util.function.BiFunction;

public class BiFunctionExample {

    public static void main(String[] args) {
        BiFunction<Table, Window, String> biFunction = (tbl, wnd) -> {
            return tbl.toString().concat(wnd.toString());
        };

        System.out.println(biFunction.apply(new Table(), new Window()));

        Caller caller = new Caller();
        BiFunction<Table, Window, String> biFunction1 = caller::concat;
        System.out.println(biFunction1.apply(new Table(), new Window()));
    }

    static class Caller{
        String concat(Table table, Window window){
            return table.toString().concat("%%$%%").concat(window.toString());
        }
    }

    static class Table{

    }

    static class Window{

    }
}
