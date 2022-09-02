package models;

import enums.Measure;
import enums.ProductCategory;

public abstract class Product {

    private String name;
    private double cost;
    private Measure measure;
    private ProductCategory productCategory;

    public Product(String name, double cost, Measure measure, ProductCategory productCategory) {
        this.name = name;
        this.cost = cost;
        this.measure = measure;
        this.productCategory = productCategory;
    }
}
