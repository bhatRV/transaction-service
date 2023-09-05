package com.rashmi.springbootframework.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DepositAccountDto {

    private final String accountId;
    private final Integer credit;

    @JsonCreator
    public DepositAccountDto(@JsonProperty("accountId") String accountId,
                             @JsonProperty("credit") Integer credit) {
        this.accountId = accountId;
        this.credit = credit;
    }

    public String getAccountId() {
        return accountId;
    }

    public Integer getCredit() {
        return credit;
    }

}