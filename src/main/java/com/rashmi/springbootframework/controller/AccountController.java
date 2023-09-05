package com.rashmi.springbootframework.controller;

import com.rashmi.springbootframework.dto.AccountId;
import com.rashmi.springbootframework.dto.events.CreateEvent;
import com.rashmi.springbootframework.dto.events.DeleteAccEvent;
import com.rashmi.springbootframework.dto.events.DepositEvent;
import com.rashmi.springbootframework.dto.events.TransferEvent;
import com.rashmi.springbootframework.dto.request.CreateAccountDto;
import com.rashmi.springbootframework.dto.request.DepositAccountDto;
import com.rashmi.springbootframework.dto.request.TransferFundsDto;
import com.rashmi.springbootframework.service.EventProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/services/accounts")
public class AccountController {

    private final EventProducer eventProducer;

    public AccountController(EventProducer eventProducer) {
        this.eventProducer = eventProducer;
    }

    @PostMapping()
    public ResponseEntity<AccountId> createAccount(@RequestBody CreateAccountDto request) {
        String accountId = UUID.randomUUID().toString();
        CreateEvent createAccountAsyncEvent = new CreateEvent(
                UUID.randomUUID().toString(), accountId, request.getName(), request.getCredit()
        );
        eventProducer.sendAccountMessage(createAccountAsyncEvent);
        return ResponseEntity.ok(new AccountId(accountId));
    }

    @PutMapping("/deposit")
    public ResponseEntity<Void> depositAccount(@RequestBody DepositAccountDto request) {
        DepositEvent depositAccountAsyncEvent = new DepositEvent(
                UUID.randomUUID().toString(), request.getAccountId(), request.getCredit()
        );
        eventProducer.sendAccountMessage(depositAccountAsyncEvent);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{account-id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("account-id") String accountId) {
        DeleteAccEvent deleteAccountAsyncEvent = new DeleteAccEvent(UUID.randomUUID().toString(), accountId);
        eventProducer.sendAccountMessage(deleteAccountAsyncEvent);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<Void> transferFunds(@RequestBody TransferFundsDto request) {
        TransferEvent transferEvent = new TransferEvent(UUID.randomUUID().toString(),
                request.getSourceAccountId(), request.getDestinationAccountId(), request.getCredit());
        eventProducer.sendAccountMessage(transferEvent);
        return ResponseEntity.ok().build();
    }

}