package kg.megacom.models;

import kg.megacom.enums.OperationStatus;

import java.util.ArrayList;
import java.util.Date;

public class Operation {
    private double id;
    private Date startDate;
    private Date endDate;
    private OperationStatus status;
    private ArrayList<Product> products;
    private double totalPrice;

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public double getId() {
        return id;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public OperationStatus getStatus() {
        return status;
    }

    public void setStatus(OperationStatus status) {
        this.status = status;
    }
}
