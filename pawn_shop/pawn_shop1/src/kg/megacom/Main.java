package kg.megacom;

import kg.megacom.enums.OperationStatus;
import kg.megacom.exceprions.ClientNotFoundException;
import kg.megacom.models.Client;
import kg.megacom.models.Operation;
import kg.megacom.models.Product;
import kg.megacom.services.ClientService;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        ClientService clientService = ClientService.INSTANCE;

        Client client;
        try {
            client = clientService.findClient("id12345");
        } catch (ClientNotFoundException e) {
            clientService.createClient("Salamat", "id12345");
        }
        clientService.getAllClients();

        ArrayList<Product> products =  new ArrayList<>();
        Product product = new Product("Телевизор", 10000);
        products.add(product);


        Operation operation = new Operation();
        operation.setStartDate(new Date());
        operation.setStatus(OperationStatus.OPEN);
        operation.setProducts(products);
        operation.setStartDate(new Date());

    }
}
