package com.andrew.nsimbi.accountservice.service.impl;

import com.andrew.nsimbi.accountservice.exception.NoSuchResourceException;
import com.andrew.nsimbi.accountservice.model.Account;
import com.andrew.nsimbi.accountservice.repository.AccountRepository;
import com.andrew.nsimbi.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;


    @Override
    public Account addAccount(Account account) {

        return accountRepository.save(account);
    }

    @Override
    public Account getAccount(long accountId) throws NoSuchResourceException {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new NoSuchResourceException("No Account found  with", accountId));

        return account;
    }

    @Override
    public List<Account> getAccounts() {

        return accountRepository.findAll();
    }

    @Override
    public Account editAccount(long accountID, Account edit_account) throws NoSuchResourceException {

        Account account = accountRepository.findById(accountID)
                .orElseThrow(() -> new NoSuchResourceException("No account found  with", accountID));

        account.setAccountHolderName(edit_account.getAccountHolderName());
        account.setAccountNumber(edit_account.getAccountNumber());
        account.setEmailAddress(edit_account.getEmailAddress());
        account.setPhoneNumber(edit_account.getPhoneNumber());

        return accountRepository.save(account);
    }

    @Override
    public Account deleteAccount(long accountID) throws NoSuchResourceException {
        Account account = accountRepository.findById(accountID)
                .orElseThrow(() -> new NoSuchResourceException("No Account found  with", accountID));

        accountRepository.save(account);

        return accountRepository.save(account);
    }

    // Emad --- update for order operations
}
