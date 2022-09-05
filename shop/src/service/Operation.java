package service;

import enums.ProductCategory;
import models.Order;
import models.Product;
import models.Receipt;
import service.impl.Operationlmpl;

public interface Operation {

    Receipt getReceipt(Order order);
    void getCategory();
    Product[] getProductByCategory(String category);
}
