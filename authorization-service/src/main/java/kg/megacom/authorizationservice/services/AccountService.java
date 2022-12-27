package kg.megacom.authorizationservice.services;

import kg.megacom.authorizationservice.models.dtos.AccountDto;
import kg.megacom.authorizationservice.models.entities.Account;
import kg.megacom.authorizationservice.models.request.AuthRequest;

public interface AccountService extends BaseService<AccountDto>{
    String auth(AuthRequest request);

    AccountDto findByUserName(String name, boolean active);

    AccountDto getByUserId(Long id);

    String create(AuthRequest request);
}
