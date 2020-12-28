package com.andrew.nsimbi.accountservice.service;

import com.andrew.nsimbi.accountservice.exception.NoSuchResourceException;
import com.andrew.nsimbi.accountservice.model.Account;

import java.util.List;

public interface AccountService {
//Account
    public Account addAccount(Account account);

    public Account getAccount(long accountId) throws NoSuchResourceException;

    public List<Account> getAccounts();

    public Account editAccount(long accountID, Account edit_account) throws NoSuchResourceException;

    public Account deleteAccount(long accountId) throws NoSuchResourceException;

    // Andrew Advanced Search
}
