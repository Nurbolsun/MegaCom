package models.products;

import enums.Measure;
import enums.ProductCategory;
import models.Product;

public class Sugar extends Product {


    public Sugar(String name, double cost, Measure measure, ProductCategory productCategory) {
        super(name, cost, measure, productCategory);
    }
}
