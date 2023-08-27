package zadania.kolekcje.zad3;

import java.util.Deque;
import java.util.NoSuchElementException;

public class Accountant {

    public void processInvoice(Deque<Invoice> invoices){
        try{
            Invoice currentInvoice = invoices.removeLast();
            System.out.println(this.getClass().getSimpleName() + " processed invoice: " + currentInvoice);
        }catch (NoSuchElementException e){
            System.out.println("Have a break");
        }
    }

    public String summaryOfInvoices(Deque<Invoice> invoices){
        Double summaryCost = 0.0;
        for (Invoice invoice : invoices) {
            summaryCost += invoice.getAmount();
        }
        String summary = "Current invoices amount: " + summaryCost + ". Invoices: " + invoices;
        return summary;
    }

    public void printSummaryOfInvoices(Deque<Invoice> invoices){
        Double summaryCost = 0.0;
        for (Invoice invoice : invoices) {
            summaryCost += invoice.getAmount();
        }
        System.out.println("Current invoices amount: " + summaryCost + ". Invoices: " + invoices);
    }
}
