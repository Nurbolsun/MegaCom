package kg.megacom.authorizationservice.services.impl;

import kg.megacom.authorizationservice.dao.AccountRep;
import kg.megacom.authorizationservice.mappers.AccountMapper;
import kg.megacom.authorizationservice.models.dtos.AccountDto;
import kg.megacom.authorizationservice.models.entities.Account;
import kg.megacom.authorizationservice.models.AccountNameAndDateResponse;
import kg.megacom.authorizationservice.models.enums.AccountStatus;
import kg.megacom.authorizationservice.models.request.AuthRequest;
import kg.megacom.authorizationservice.services.AccountService;
import org.hibernate.exception.ConstraintViolationException;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRep rep;


    public AccountServiceImpl(AccountRep rep) {
        this.rep = rep;
    }

    @Override
    public AccountDto save(AccountDto account) {
        try {
            return AccountMapper.INSTANCE.toDto(
                    rep.save(AccountMapper.INSTANCE.toEntity(account)));
        }catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Логин уже существует");
        }
    }

    @Override
    public AccountDto findById(Long id) {
        return AccountMapper.INSTANCE.toDto(rep.findById(id).orElseThrow(() -> new RuntimeException("Аккаунт не найден")));
    }

    @Override
    public AccountDto delete(Long id) {
        AccountDto account = findById(id);
        account.setActive(false);
        return save(account);
    }

    @Override
    public List<AccountDto> findAll() {
        return AccountMapper.INSTANCE.toDtos(rep.findAll());
    }


    @Override
    public String auth(AuthRequest request) {
        AccountDto account =
                AccountMapper.INSTANCE.toDto(rep.findByLogin(request.getLogin())
                        .orElseThrow(() -> new RuntimeException("Пользователь не найден")));
        switch (account.getStatus()) {
            case ACTIVE:
                break;
            case BLOCKED:
                if (checkDate(account.getUpdateDate())) {
                    account.setCount(0);
                    account.setStatus(AccountStatus.ACTIVE);
                    save(account);
                    break;
                }
                throw new RuntimeException("Ваш аккаунт заблокирован");
            case DELETED:
                throw new RuntimeException("Ваш аккаунт удален");
        }
        if (account.getPassword().equals(request.getPassword())) {
            account.setCount(0);
            save(account);
            return "Success";
        } else {
            if (account.getCount() >= 3) {
                account.setStatus(AccountStatus.BLOCKED);
                save(account);
                throw new RuntimeException("Вы заблокированы.Повторите попытку через час");
            }
            account.setCount(account.getCount() + 1);
            save(account);
            throw new RuntimeException("Вы ввели неверный пароль");
        }


    }

    @Override
    public AccountDto findByUserName(String name, boolean active) {
        boolean result = rep.existsByLogin("login");
        System.out.println(result);

        int count = rep.countByActive(true);

        System.out.println(count);


        AccountNameAndDateResponse name1 = rep.findNameByActive(true);

        System.out.println(name1.getAddDate());
        System.out.println(name1.getLogin());

        return AccountMapper.INSTANCE.toDto(rep.findByUserName(name, active));
    }

    @Override
    public AccountDto getByUserId(Long id) {

        return AccountMapper.INSTANCE.toDto(rep.findByUserId(id));
    }

    @Override
    public String create(AuthRequest request) {
        try {
            AccountDto accountDto = new AccountDto();
            accountDto.setPassword(request.getPassword());
            accountDto.setLogin(request.getLogin());
            save(accountDto);
            return "Succes";
        }catch (DataIntegrityViolationException e){
            throw new RuntimeException("Аккаунт с таким логином уже существует");
        }catch (Exception e){
            throw new RuntimeException("Произошла неизвестная ошибка");
        }
    }

    private boolean checkDate(Date updateDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(updateDate);
        calendar.add(Calendar.HOUR, 1);
        return new Date().after(calendar.getTime());
    }
}
