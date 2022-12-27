package kg.megacom.authorizationservice.services.impl;

import kg.megacom.authorizationservice.dao.UserRep;
import kg.megacom.authorizationservice.mappers.AccountMapper;
import kg.megacom.authorizationservice.mappers.UsersMapper;
import kg.megacom.authorizationservice.models.dtos.AccountDto;
import kg.megacom.authorizationservice.models.dtos.UsersDto;
import kg.megacom.authorizationservice.services.AccountService;
import kg.megacom.authorizationservice.services.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersServiceImpl implements UsersService {


    private final UserRep rep;
    private final AccountService accountService;


    public UsersServiceImpl(UserRep rep, AccountService accountService) {
        this.rep = rep;
        this.accountService = accountService;
    }


    @Override
    public UsersDto save(UsersDto users) {
        return UsersMapper.INSTANCE.toDto(rep.save(UsersMapper.INSTANCE.toEntity(users)));
    }

    @Override
    public UsersDto findById(Long id) {
        return UsersMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(()->new RuntimeException("Аккаунт не найден")));
    }

    @Override
    public UsersDto delete(Long id) {
       UsersDto users =  findById(id);
       users.setActive(false);
        return save(users);
    }

    @Override
    public List<UsersDto> findAll() {
        return UsersMapper.INSTANCE.toDtos(rep.findAll());
    }

    @Override
    public UsersDto findByAccount(AccountDto account) {

        return UsersMapper.INSTANCE.
                toDto(rep.findByAccount(AccountMapper.INSTANCE.toEntity(account)));
    }
}
