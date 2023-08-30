package materialy;
@FunctionalInterface
public interface InterfaceFunkcyjny {
        public abstract void consume(String arg1);

        default String someDefault(){
            System.out.println("someDefault method in InterfaceFunkcyjny");
            return "someDefault";
        }

        static String someStatic(){
            System.out.println("someStatic method in InterfaceFunkcyjny");
            return "someStatic";
        }
}
