package com.rashmi.springbootframework.dto.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,
        property = "typeId"
)
public class CreateEvent implements AccStatusEvent {

    private final String id;
    private final String accountId;
    private final String name;
    private final Integer credit;

    @JsonCreator
    public CreateEvent(@JsonProperty("id") String id,
                       @JsonProperty("accountId") String accountId,
                       @JsonProperty("name") String name,
                       @JsonProperty("credit") Integer credit) {
        this.id = id;
        this.accountId = accountId;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public Integer getCredit() {
        return credit;
    }

}