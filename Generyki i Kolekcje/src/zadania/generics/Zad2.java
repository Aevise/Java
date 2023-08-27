package zadania.generics;

public class Zad2 {

    public static void main(String[] args) {
        Zad2 testy = new Zad2();
        Zad2.Tuple test = testy.new Tuple("hehe", 12);
        Zad2.Tuple test2 = testy.new Tuple(123, "12");
    }

    public class Tuple{
        private Object key;
        private Object value;
        public Tuple(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
        public Object getKey() {
            return key;
        }
        public Object getValue() {
            return value;
        }
        public void setKey(Object key) {
            this.key = key;
        }
        public void setValue(Object value) {
            this.value = value;
        }
    }
}


//    Jak będzie wyglądał poniższy kod po dokonaniu Type Erasure?
//public class Tuple<E1, E2> {
//    private E1 key;
//    private E2 value;
//    public Tuple(E1 key, E2 value) {
//        this.key = key;
//        this.value = value;
//    }
//    public E1 getKey() {
//        return key;
//    }
//    public E2 getValue() {
//        return value;
//    }
//    public void setKey(E1 key) {
//        this.key = key;
//    }
//    public void setValue(E2 value) {
//        this.value = value;
//    }
//}