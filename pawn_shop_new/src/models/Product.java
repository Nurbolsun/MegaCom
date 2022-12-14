package models;

public class Product {
    private double id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = Math.random();
        this.name = name;
        this.price = price;
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
