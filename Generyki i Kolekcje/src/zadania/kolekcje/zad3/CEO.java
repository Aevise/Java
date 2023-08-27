package zadania.kolekcje.zad3;

import java.util.*;

public class CEO extends Accountant{
    public<T extends Number> void addInvoice(Deque<Invoice> invoices, T amount){
        invoices.add(new Invoice(amount.doubleValue()));
        Invoice newInvoice = invoices.peekLast();
        System.out.println(newInvoiceInformation(newInvoice));
    }

    private String newInvoiceInformation(Invoice newInvoice){
        return this.getClass().getSimpleName() + " added invoice: " + newInvoice;
    }
}
