package kg.megacom.authorizationservice.dao;

import kg.megacom.authorizationservice.models.entities.Account;
import kg.megacom.authorizationservice.models.AccountNameAndDateResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRep extends JpaRepository<Account,Long> {

    Optional<Account> findByLogin(String login);


    @Query(value = "select a from Account a inner join Users u on a.id=u.account.id where u.name=:name and u.active=:active")
    Account findByUserName( String name,boolean active);

    @Query(value = "SELECT * FROM account a INNER join users u on a.id=u.id where u.id=?1",nativeQuery = true)
    Account findByUserId(Long id);

    boolean existsByLogin(String login);

    int countByActive(boolean active);

    @Query("select a.login as login, a.addDate as addDate from Account a where a.active=:active")
    AccountNameAndDateResponse findNameByActive(boolean active);











}
