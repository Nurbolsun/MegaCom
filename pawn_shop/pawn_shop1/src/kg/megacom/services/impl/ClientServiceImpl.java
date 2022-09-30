package kg.megacom.services.impl;

import kg.megacom.exceprions.ClientNotFoundException;
import kg.megacom.models.Client;
import kg.megacom.services.ClientService;

import java.util.ArrayList;

public class ClientServiceImpl implements ClientService {
    ArrayList<Client> clientArrayList = new ArrayList<>();

    @Override
    public Client findClient(String idCard) {

        for (Client client: clientArrayList) {
            if(client.getIdCard().equals(idCard)){
                return client;
            }
        }
        throw new ClientNotFoundException("Клиент в системе не найден!");
    }
    @Override
    public Client createClient(String name, String idCard) {
        Client client = new Client(idCard, name);
        clientArrayList.add(client);
        return client;
    }

    @Override
    public boolean blockClient(String idCard) {
        Client client = findClient(idCard);
        client.setBlocked(true);

        return true;
    }

    @Override
    public void getAllClients() {
        for (Client client : clientArrayList) {
            System.out.println("NAME = " + client.getName() + " ID = " + client.getId() + " IDCARD "
            + client.getIdCard() + " BLOCKED = " + client.isBlocked());
        }
    }
}
