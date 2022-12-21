package kg.megacom.authorizationservice.services;

import kg.megacom.authorizationservice.models.Account;
import kg.megacom.authorizationservice.models.request.AuthRequest;

public interface AccountService extends BaseService<Account>{
    String auth(AuthRequest request);
}
