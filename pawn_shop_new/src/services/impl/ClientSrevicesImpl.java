package services.impl;

import models.Client;
import services.ClientSrevices;

import java.util.ArrayList;

public class ClientSrevicesImpl implements ClientSrevices {
    ArrayList<Client> clientArrayList = new ArrayList<>();


    @Override
    public Client findClient(String idCard) {
        for (Client client: clientArrayList) {
            if (client.getIdCard().equals(idCard)){
                return client;
            }
        }
        throw new ClassNotFoundException("Клиент в системе не найден!");
    }
    @Override
    public Client createClient(String name, String idCard) {
        return null;
    }

    @Override
    public boolean blockClient(String idCard) {
        return false;
    }
}
