package kg.megacom.beauties.services.impl;

import kg.megacom.beauties.dao.ClientRep;
import kg.megacom.beauties.mappers.ClientMapper;
import kg.megacom.beauties.models.dtos.ClientDto;
import kg.megacom.beauties.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServicesImpl implements ClientServices {
    @Autowired
    private ClientRep rep;

    ClientMapper mapper = ClientMapper.INSTANCE;

    @Override
    public ClientDto save(ClientDto clientDto) {
        return mapper.toDto(rep.save(mapper.toEntity(clientDto)));
    }

    @Override
    public ClientDto findById(Long id) {
        return mapper.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("Клиент не найден")));
    }

    @Override
    public ClientDto delete(Long id) {
        ClientDto client = findById(id);
        client.setActive(false);
        return save(client);

    }

    @Override
    public List<ClientDto> findAll() {
        return mapper.toDtos(rep.findAll());
    }
}
