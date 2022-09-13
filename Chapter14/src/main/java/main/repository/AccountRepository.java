package main.repository;

import main.entity.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long>
{
    List<Account> findByName(String name);

    @Query("SELECT * FROM account WHERE name = :name")
    List<Account> findByNameCustom(String name);

    @Modifying
    @Query("UPDATE acount SET amount = :amount WHERE id = :id")
    void changeAmount(long id, BigDecimal amount);

}
