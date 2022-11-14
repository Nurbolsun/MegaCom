package com.company.services.impl;

import com.company.models.Client;
import com.company.models.Operation;
import com.company.models.Product;
import com.company.services.OperationService;

import java.util.ArrayList;
import java.util.Calendar;

public class OperationServiceImpl implements OperationService {

    ArrayList<Operation> operations = new ArrayList<>();

    @Override
    public Operation createOperation(int days, ArrayList<Product> products, Client client) {
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.DAY_OF_MONTH, days);
        double totalPrice = getTotalPrice(products, days);

        Operation operation = new Operation(endDate.getTime(), products, totalPrice, client);

        operations.add(operation);

        return operation;
    }

    @Override
    public Operation closeOperation() {
        return null;
    }

    @Override
    public void getOperationByIdCard(String idCard) {
        for (Operation operation:operations){
            if (operation.getClient().getIdCard().equals(idCard)){
                System.out.println("id = " +operation.getId() + " endDate = " +operation.getEndDate() +
                        "ClientNAme = " + operation.getClient().getName() + "totalPrice = " + operation.getTotalPricce());
            }
        }

    }

    double getTotalPrice(ArrayList<Product> products, int days){
        double totalPrice = 0;
        for (Product product: products){
            totalPrice += product.getPrice();
        }return totalPrice + (totalPrice*days / 100);
    }
}
