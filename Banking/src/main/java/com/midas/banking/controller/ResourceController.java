package com.midas.banking.controller;

import com.midas.banking.dto.BalanceTransfer;
import com.midas.banking.entity.AccountDetails;
import com.midas.banking.entity.TransactionDetails;
import com.midas.banking.entity.UserDetails;
import com.midas.banking.repository.UserRepository;
import com.midas.banking.service.AccountDetailsService;
import com.midas.banking.service.TransactionDetailsService;
import com.midas.banking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ResourceController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountDetailsService accountDetailsService;

    @Autowired
    TransactionDetailsService transactionDetailsService;

    @PostMapping("/signup")
    public ResponseEntity<UserDetails> signup(@RequestBody UserDetails userDetails) {
        UserDetails user = userService.signup(userDetails);
        return new ResponseEntity<>(user ,HttpStatus.CREATED);
    }

    @PostMapping("/balance/{accountNo}")
    public ResponseEntity<AccountDetails> balance(HttpServletRequest req, @PathVariable int accountNo) {
        AccountDetails details = accountDetailsService.getAccountDetails(accountNo);
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

    @PostMapping("/balanceTransfer")
    public ResponseEntity<BalanceTransfer> balanceTransfer(HttpServletRequest req, @RequestBody BalanceTransfer balanceTransfer) {
        BalanceTransfer balance = accountDetailsService.balanceTransfer(balanceTransfer);
        return new ResponseEntity<>(balance, HttpStatus.OK);
    }

    @PostMapping("/transactionHistory")
    public ResponseEntity<List<TransactionDetails>> transactionHistory(HttpServletRequest req, @RequestBody TransactionDetails transactionDetails) {
        List<TransactionDetails> models = transactionDetailsService.transactionHistory(transactionDetails);
        return new ResponseEntity<>(models, HttpStatus.OK);
    }
}
