package com.rashmi.springbootframework.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateAccountDto {

    private final String name;
    private final Integer credit;

    @JsonCreator
    public CreateAccountDto(@JsonProperty("name") String name, @JsonProperty("credit") Integer credit) {
        this.name = name;
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    public Integer getCredit() {
        return credit;
    }

}