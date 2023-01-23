package kg.mega.saloon.service;

import kg.mega.saloon.models.dto.ClientDto;
import kg.mega.saloon.models.requests.ClientRequest;

public interface ClientService extends BaseService<ClientDto> {
    ClientDto create(ClientRequest clientRequest);
}
