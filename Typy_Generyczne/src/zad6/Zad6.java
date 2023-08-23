package zad6;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Napisz klasę reprezentującą stos różnego rodzaju przedmiotów, np. Książki, Gazety i Smartfony
//(jednocześnie). Spróbuj zakodować tę klasę przy wykorzystaniu mechanizmu generyków, a
//następnie zastanów się jak mogłaby wyglądać bez ich użycia. Zwróć Optional celem pokazania, że na
//tym stosie może nie być żadnych elementów.
public class Zad6 {

    public static void main(String[] args) {
        Zad6 testy = new Zad6();
        Worek worek = testy.new Worek();

        worek.addData1("gmm");
        worek.addData1("Hehe");
        System.out.println(worek.getData1());
        System.out.println(worek.removeElementData1());
        System.out.println(worek.removeElementData1());
        System.out.println(worek.removeElementData1());

    }

    public class Worek<S extends String, U extends Car,  V extends Number>{
        private List<S> data1 = new ArrayList<>();
        private List<U> data2 = new ArrayList<>();
        private List<V> data3 = new ArrayList<>();

        public void addData1(S data1) {
            this.data1.add(data1);
        }

        public Optional<Boolean> removeElementData1(){
            if(this.data1.isEmpty()){
                return Optional.empty();
            }
            int last = this.data1.size() - 1;
            this.data1.remove(last);
            return Optional.of(true);
        }


        public void addData2(U data2) {
            this.data2.add(data2);
        }
        public Optional<Boolean> removeElementData2(){
            if(this.data2.isEmpty()){
                return Optional.empty();
            }
            int last = this.data2.size() - 1;
            this.data2.remove(last);
            return Optional.of(true);
        }


        public void addData3(V data3) {
            this.data3.add(data3);
        }
        public Optional<Boolean> removeElementData3(){
            if(this.data3.isEmpty()){
                return Optional.empty();
            }
            int last = this.data3.size() - 1;
            this.data3.remove(last);
            return Optional.of(true);
        }

        public List<S> getData1() {
            return data1;
        }

        public List<U> getData2() {
            return data2;
        }

        public List<V> getData3() {
            return data3;
        }
    }

    public class Car{}
}
