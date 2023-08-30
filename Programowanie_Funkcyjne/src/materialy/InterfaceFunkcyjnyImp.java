package materialy;

public class InterfaceFunkcyjnyImp{

    public static void main(String[] args) {
        InterfaceFunkcyjny interfaceFunkcyjnyImpl = (String arg)->{
            System.out.println("calling InterfaceFunkcyjny: " + arg);
        };
        interfaceFunkcyjnyImpl.consume("hehe Cat");
        interfaceFunkcyjnyImpl.someDefault();
        InterfaceFunkcyjny.someStatic();
    }

}
