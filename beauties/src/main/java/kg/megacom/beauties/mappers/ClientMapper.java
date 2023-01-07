package kg.megacom.beauties.mappers;

import kg.megacom.beauties.models.dtos.ClientDto;
import kg.megacom.beauties.models.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper extends BaseMapper<Client, ClientDto> {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

}
