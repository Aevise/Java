package zadania.kolekcje.zad3;

import java.time.LocalDate;

public class Invoice {
    private final Integer id;
    private final Double amount;
    private final Integer year;
    private static Integer numberOfInvoices = 0;

    public Invoice(Double amount) {
        this.amount = amount;
        this.id = ++numberOfInvoices;
        this.year = LocalDate.now().getYear();
    }
    public Integer getId() {
        return id;
    }
    public Double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "{" + id + "/" + year + ", amount=" + amount + "}";
    }
}
