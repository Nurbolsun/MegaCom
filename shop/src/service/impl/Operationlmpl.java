package service.impl;

import enums.Measure;
import enums.ProductCategory;
import models.Cashier;
import models.Order;
import models.Product;
import models.Receipt;
import models.products.Milk;
import models.products.Sugar;
import models.products.Tea;
import service.Operation;

public class Operationlmpl implements Operation {
    Sugar sugar = new Sugar("Sugar", 124, Measure.Kg, ProductCategory.SUGAR);
    Sugar sugar2 = new Sugar("Water", 154, Measure.Kg, ProductCategory.SUGAR);

    Milk milk = new Milk("Milk", 145, Measure.Li, ProductCategory.MILK);
    Milk milk2 = new Milk("Кефир", 745, Measure.Li, ProductCategory.MILK);

    Tea tea = new Tea("Ahmad", 155, Measure.Kg, ProductCategory.TEA);
    Tea tea2 = new Tea("Champion", 125, Measure.Kg, ProductCategory.TEA);

    Product[] products = {sugar, sugar2, milk, milk2, tea, tea2};

    Cashier cashier3 = new Cashier("Aman", "aman", (byte) 20, 1);
    Cashier cashier2 = new Cashier("Aigul", "aigul", (byte) 18, 2);

    Cashier[] cashiers = {cashier2,cashier3};

    @Override
    public Receipt getReceipt(Order order) {
        return null;
    }

    @Override
    public void getCategory() {
        for (ProductCategory iteam : ProductCategory.values()) {
            System.out.println(iteam.name());
        }
    }

    @Override
    public Product[] getProductByCategory(String category) {
        Product[] result = new Product[10];
        //for (Product product:products){
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductCategory().equals(ProductCategory.valueOf(category))) {
                result[i] = products[i];
            }

        }
        return result;
    }

    @Override
    public Product getProductByName(String productName) {
        for (Product iteam : products) {
            if (productName.equals(iteam.getName())) {
                return iteam;
            }

        }
        return null;
    }
    @Override
    public Cashier getCashierByName(String cashier) {
        for (Cashier iteam:cashiers){
            if (iteam.getName().equals(cashier))
                return iteam;
        }
        return null;
    }
}