package com.rashmi.springbootframework.dto.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,
        property = "typeId"
)
public class DepositEvent implements AccStatusEvent {

    private final String id;
    private final String accountId;
    private final Integer credit;

    @JsonCreator
    public DepositEvent(@JsonProperty("id") String id,
                        @JsonProperty("account") String accountId,
                        @JsonProperty("credit") Integer credit) {
        this.id = id;
        this.accountId = accountId;
        this.credit = credit;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String keyMessageKey() {
        return accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    public Integer getCredit() {
        return credit;
    }

}