package services;

import models.Client;

public interface ClientSrevices {

    Client findClient(String idCard);
    Client createClient(String name, String idCard);
    boolean blockClient(String idCard);

}
