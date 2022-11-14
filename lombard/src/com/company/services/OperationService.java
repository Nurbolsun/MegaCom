package com.company.services;

import com.company.models.Client;
import com.company.models.Operation;
import com.company.models.Product;
import com.company.services.impl.OperationServiceImpl;

import java.util.ArrayList;

public interface OperationService {
    OperationService INSTANCE = new OperationServiceImpl();

    Operation createOperation(int days, ArrayList<Product> products, Client client);

    Operation closeOperation();

    void getOperationByIdCard(String idCard);
}
