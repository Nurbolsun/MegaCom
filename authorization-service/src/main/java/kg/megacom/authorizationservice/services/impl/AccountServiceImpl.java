package kg.megacom.authorizationservice.services.impl;

import kg.megacom.authorizationservice.dao.AccountRep;
import kg.megacom.authorizationservice.models.Account;
import kg.megacom.authorizationservice.models.enums.AccountStatus;
import kg.megacom.authorizationservice.models.request.AuthRequest;
import kg.megacom.authorizationservice.services.AccountService;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRep rep;

    @Override
    public Account save(Account account) {
            return rep.save(account);
    }

    @Override
    public Account findById(Long id) {
        return rep.findById(id).orElseThrow(()->new RuntimeException("Аккаунт не найден"));
    }

    @Override
    public Account delete(Long id) {
        Account account=findById(id);
        account.setActive(false);
        return save(account);
    }

    @Override
    public List<Account> findAll() {
        return rep.findAll();
    }



    @Override
    public String auth(AuthRequest request) {
        Account account=rep.findByLogin(request.getLogin()).orElseThrow(()->new RuntimeException("Пользователь не найден"));
        switch (account.getStatus()){
            case ACTIVE:
                break;
            case BLOCKED:
                if (!checkDate(account.getUpdateDate())){
                    account.setCount(0);
                    account.setStatus(AccountStatus.ACTIVE);
                    break;
                }
                throw new RuntimeException("Ваш аккаунт заблокирован");
            case DELETED:
                throw new RuntimeException("Ваш аккаунт удален");
        }
        if (account.getPassword().equals(request.getPassword())){
            account.setCount(0);
            save(account);
            return "Success";
        }else {

            if (account.getCount()>=3){
                account.setStatus(AccountStatus.BLOCKED);
                save(account);
                throw new RuntimeException("Вы заблокированы.Повторите попытку через час");
            }
            account.setCount(account.getCount()+1);
            save(account);
            throw new RuntimeException("Вы ввели неверный пароль");
        }

    }

    private boolean checkDate(Date updateDate) {
        return updateDate.getTime()<=new Date().getTime()-3600;
    }
}
