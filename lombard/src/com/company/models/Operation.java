package com.company.models;

import com.company.enums.OperationStatus;

import java.util.ArrayList;
import java.util.Date;

public class Operation {
    private double id;
    private Date startDate;
    private Date endDate;
    private OperationStatus status;
    private ArrayList<Product> products;
    private double totalPricce;
    private Client client;

    public Operation( Date endDate,  ArrayList<Product> products, double totalPricce, Client client) {
        this.id = Math.random();
        this.client = client;
        this.startDate =new Date();
        this.endDate = endDate;
        this.status = OperationStatus.OPEN;
        this.products = products;
        this.totalPricce = totalPricce;

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getTotalPricce() {
        return totalPricce;
    }

    public void setTotalPricce(double totalPricce) {
        this.totalPricce = totalPricce;
    }

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
