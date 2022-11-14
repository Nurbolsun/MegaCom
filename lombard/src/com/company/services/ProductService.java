package com.company.services;

import com.company.models.Client;
import com.company.models.Product;
import com.company.services.impl.ProductServiceImpl;

public interface ProductService {
    ProductService INSTANCE = new ProductServiceImpl();

    Product createProduct(double price, String name, Client client);
}
