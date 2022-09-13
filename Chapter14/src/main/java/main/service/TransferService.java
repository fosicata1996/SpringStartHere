package main.service;

import main.entity.Account;
import main.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService
{
    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;
    }

    private static class AccountNotFoundException extends RuntimeException
    {
    }

    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount)
    {
        Account sender = accountRepository.findById(idSender).orElseThrow(AccountNotFoundException::new);
        Account receiver = accountRepository.findById(idReceiver).orElseThrow(AccountNotFoundException::new);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);
    }

    public Iterable<Account> getAllAccounts()
    {
        return accountRepository.findAll();
    }

    public List<Account> findAccountsByName(String name)
    {
        return accountRepository.findByName(name);
    }
}
