package kg.megacom.authorizationservice.services.impl;

import kg.megacom.authorizationservice.dao.UserRep;
import kg.megacom.authorizationservice.models.Users;
import kg.megacom.authorizationservice.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserRep rep;

    @Override
    public Users save(Users users) {
        return rep.save(users);
    }

    @Override
    public Users findById(Long id) {
        return rep.findById(id).orElseThrow(()->new RuntimeException("Аккаунт не найден"));
    }

    @Override
    public Users delete(Long id) {
       Users users =  findById(id);
       users.setActive(false);
        return save(users);
    }

    @Override
    public List<Users> findAll() {
        return rep.findAll();
    }
}
