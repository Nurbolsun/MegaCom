package service;

import models.Cashier;
import models.Order;
import models.Product;
import models.Receipt;

public interface Operation {

    Receipt getReceipt(Order order);

    void getCategory();
    Cashier getCashierByName(String cashier);
    Product[] getProductByCategory(String category);
    Product getProductByName(String productName);
}
