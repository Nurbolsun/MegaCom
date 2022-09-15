package service;

import models.Cashier;
import models.Order;
import models.Product;
import models.Receipt;

public interface Operation {

    Receipt getReceipt(Order order);

    void getCategory();
    void getName();
    Cashier getCashierByName(String cashier) throws Exception;
    Product[] getProductByCategory(String category);
    Product getProductByName(String productName);
}
