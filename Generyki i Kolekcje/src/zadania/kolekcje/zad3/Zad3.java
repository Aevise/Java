package zadania.kolekcje.zad3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zad3 {
    public static void main(String[] args) {
        Deque<Invoice> invoiceQueue = new ArrayDeque<>();
        CEO ceo = new CEO();
        Accountant accountant = new Accountant();

        String input = "no";
        Scanner inputStream = new Scanner(System.in);

        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");

        while(!input.equals("end")){
            input = inputStream.nextLine().trim().toUpperCase();
            if(input.contains(ceo.getClass().getSimpleName().toUpperCase()) && input.contains("ADD")){
                Matcher matcher = pattern.matcher(input);
                matcher.find();
                try{
                    ceo.addInvoice(invoiceQueue, Double.parseDouble(matcher.group()));
                }catch (IllegalStateException error){
                    System.out.println("O co chodzi?");
                }
            } else if (input.contains(accountant.getClass().getSimpleName().toUpperCase()) && input.contains("PROCESS")) {
                accountant.processInvoice(invoiceQueue);
            }
            else {
                System.out.println("O co chodzi?");
            }
            accountant.printSummaryOfInvoices(invoiceQueue);

            Queue test = new ArrayDeque();
        }
    }
}
