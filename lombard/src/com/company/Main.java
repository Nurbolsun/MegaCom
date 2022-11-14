package com.company;

import com.company.enums.OperationStatus;
import com.company.exeptions.ClientNotFoundExeptions;
import com.company.models.Client;
import com.company.models.Operation;
import com.company.models.Product;
import com.company.services.ClientService;
import com.company.services.OperationService;
import com.company.services.ProductService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        ClientService clientService = ClientService.INSTANCE;
        ProductService product = ProductService.INSTANCE;
        OperationService operationService = OperationService.INSTANCE;

        Client client;
        try {
            client = clientService.findClient("id12345");
        } catch (ClientNotFoundExeptions e){
            clientService.createClient("Aman", "id12345");
        }
        clientService.getAllClients();

        ArrayList<Product> products = new ArrayList<>();

        products.add(product.createProduct(1000, "TV", client));
    }
}
