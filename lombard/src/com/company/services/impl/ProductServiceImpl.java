package com.company.services.impl;

import com.company.models.Client;
import com.company.models.Product;
import com.company.services.ProductService;

import java.util.ArrayList;

public class ProductServiceImpl implements ProductService {

    public static ArrayList<Product> productArrayList = new ArrayList<>();

    @Override
    public Product createProduct(double price, String name, Client client) {

        Product product = new Product(name,price,client);

        productArrayList.add(product);
        return null;
    }
}
