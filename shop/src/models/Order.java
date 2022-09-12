package models;

public class Order {
    private Cashier cashier;
    private Details[] details;

    public Order() {
        this.cashier = cashier;
        this.details = details;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }

    public Details[] getDetails() {
        return details;
    }

    public void setDetails(Details[] details) {
        this.details = details;
    }
}
