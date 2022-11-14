package com.company.services.impl;

import com.company.exeptions.ClientNotFoundExeptions;
import com.company.models.Client;
import com.company.models.Operation;
import com.company.models.Product;
import com.company.services.ClientService;

import java.util.ArrayList;
public class ClientServiceImpl implements ClientService {

    ArrayList<Client> clientArrayList = new ArrayList<>();

    @Override
    public Client findClient(String idCard) {
        for (Client client: clientArrayList){
            if (client.getIdCard().equals(idCard)){
                return client;
            }
        }
        throw  new ClientNotFoundExeptions("Клиент в системе не найден!");
    }

    @Override
    public Client createClient(String name, String idCard) {
       Client client = new Client(idCard, name);
       clientArrayList.add(client);
        return client;
    }

    @Override
    public boolean blockclient(String idCard) {
        Client client = findClient(idCard);
        client.setBlocked(true);
        clientArrayList.set(clientArrayList.indexOf(client), client);
        return false;
    }

    @Override
    public void getAllClients() {
        for (Client client: clientArrayList){
            System.out.println("Name = " + client.getName() + " id = " + client.getId() + " idCard = " + client.getIdCard() + " Blocked " + client.isBlocked());
        }
    }
    ArrayList<Product> products = new ArrayList<>();
    Product product = new Product("TV", 154);
    @Override
    public Product addProduct() {

        products.add(new Product("RADIO", 180));
        products.add(new Product("LG", 1500));
        System.out.println(products);
        return null;
    }

    @Override
    public void totalPrice() {

    }


}
