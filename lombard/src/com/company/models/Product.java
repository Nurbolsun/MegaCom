package com.company.models;

public class Product {
    private double id;
    private  String name;
    private double price;
    private Client client;

    public Product(String name, double price, Client client) {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", client=" + client +
                '}';
    }

    public Product(String name, double price) {
        this.id = Math.random();
        this.name = name;
        this.price = price;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
