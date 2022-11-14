package com.company.services;

import com.company.models.Client;
import com.company.models.Product;
import com.company.services.impl.ClientServiceImpl;

public interface ClientService {
    ClientService INSTANCE = new ClientServiceImpl();

    Client findClient(String idCard);
    Client createClient(String name, String idCard);
    boolean blockclient(String idCard);
    void getAllClients ();
    Product addProduct ();
    void totalPrice();



}

