package kg.megacom.authorizationservice.services;

import kg.megacom.authorizationservice.models.dtos.AccountDto;
import kg.megacom.authorizationservice.models.dtos.UsersDto;
import kg.megacom.authorizationservice.models.entities.Users;

public interface UsersService extends BaseService<UsersDto>{

    UsersDto findByAccount(AccountDto account);
}
