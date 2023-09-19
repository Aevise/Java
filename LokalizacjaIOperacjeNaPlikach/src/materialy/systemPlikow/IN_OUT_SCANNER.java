package materialy.systemPlikow;

import java.util.Scanner;

public class IN_OUT_SCANNER {
    //BufferedReader czyta dane beznamiętnie
//    Scanner parsuje dane (próbuje zrozumieć)
//    BidDecimal wpisujemy z , przy użyciu klasy Scanner
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Data: " + scanner.nextLine());
    }
}
