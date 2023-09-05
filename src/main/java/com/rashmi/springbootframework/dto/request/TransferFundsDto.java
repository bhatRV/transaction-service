package com.rashmi.springbootframework.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransferFundsDto {

    private final String sourceAccountId;
    private final String destinationAccountId;
    private final Integer credit;

    @JsonCreator
    public TransferFundsDto(@JsonProperty("sourceAccountId") String sourceAccountId,
                            @JsonProperty("destinationAccountId") String destinationAccountId,
                            @JsonProperty("credit") Integer credit) {
        this.sourceAccountId = sourceAccountId;
        this.destinationAccountId = destinationAccountId;
        this.credit = credit;
    }

    public String getSourceAccountId() {
        return sourceAccountId;
    }

    public String getDestinationAccountId() {
        return destinationAccountId;
    }

    public Integer getCredit() {
        return credit;
    }
}