package com.andrew.nsimbi.accountservice.controller;


import com.andrew.nsimbi.accountservice.exception.NoSuchResourceException;
import com.andrew.nsimbi.accountservice.model.Account;
import com.andrew.nsimbi.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping(value = "/")
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {

        HttpHeaders headers = new HttpHeaders();

        if (account == null) {
            return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
        }
        accountService.addAccount(account);

        // headers.add("Account added :", account.);

        return new ResponseEntity<Account>(account, headers, HttpStatus.CREATED);

    }

    // ResponseEntity<List<Account>>
    @GetMapping(value = "/")
    public ResponseEntity<List<Account>> getAccounts() {

        HttpHeaders headers = new HttpHeaders();

//        Product p = new Product(new Category("Fridge", "Haier",false,null), "Refridgerator", "small size", 100.00, LocalDate.now(), "15 inch", "image/fridge", 50, true, false, null);
//        p.setPromotions(
//                Arrays.asList(
//                        new Promotion("Christmas Promotion", new Date(2020, 12, 01), new Date(2020, 12, 30), 0.25),
//                        new Promotion("Easter Promotion", new Date(2020, 03, 01), new Date(2020, 04, 04), 0.15)
//                ));


        List<Account> accounts = accountService.getAccounts();
        if (accounts == null) {
            return new ResponseEntity<List<Account>>(HttpStatus.NOT_FOUND);
        }
//        headers.add("Number of Blocks returned", String.valueOf(accounts.size()));

        return new ResponseEntity<List<Account>>(accounts, headers, HttpStatus.OK);

    }

    @GetMapping(value = "/{accountId}")
    public ResponseEntity<Account> getAccount(@PathVariable long accountId) throws NoSuchResourceException {

        Account account = accountService.getAccount(accountId);

        if (account == null) {

            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Account> editAccount(@RequestBody Account account) throws NoSuchResourceException {

        HttpHeaders headers = new HttpHeaders();
        Account account_toEdit = accountService.getAccount(account.getId());

        if (account_toEdit == null) {

            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }

        Account updatedAccount = accountService.editAccount(account.getId(), account);

//        headers.add("Updated Block : ", String.valueOf(account.getId()));

        return new ResponseEntity<Account>(updatedAccount, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{accountId}")
    public Account deleteProduct(@PathVariable long accountId) throws NoSuchResourceException {

        return accountService.deleteAccount(accountId);

    }

    @GetMapping(value = "/test")
    public String getAccount() {
        return "son";
    }





}

