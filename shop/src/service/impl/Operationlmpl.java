package service.impl;

import enums.Measure;
import enums.ProductCategory;
import models.*;
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

    Cashier Aman = new Cashier("Aman", "aman", (byte) 20, 1);
    Cashier Aigul = new Cashier("Aigul", "aigul", (byte) 18, 2);

    Cashier[] cashiers = {Aman,Aigul};

    @Override
    public Receipt getReceipt(Order order) {
        Receipt receipt = new Receipt();
        Details[] details = order.getDetails();
        double totalSum = 0;
        double totalDiscount = 0;
        ReceiptDetails[] receiptDetails = new ReceiptDetails[10];

        for (int i = 0; i < details.length; i++) {
            if (details[i] !=null){
                Product product = details[i].getProduct();
                double cost = product.getCost()*details[i].getAmount();
                double discount = (cost*details[i].getDiscount())/100;
                totalSum = totalSum + (cost-discount);
                totalDiscount = totalDiscount + discount;

                receiptDetails[i] = new ReceiptDetails(product.getName(), cost-discount);
            }
        }
        for (ReceiptDetails iteam:receiptDetails){
            System.out.println(iteam);
        }
        receipt.setName(order.getCashier().getName());
        receipt.setTotalDiscount(totalDiscount);
        receipt.setReceiptDetails(receiptDetails);
        receipt.setTotalSum(totalSum);
        return receipt;
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