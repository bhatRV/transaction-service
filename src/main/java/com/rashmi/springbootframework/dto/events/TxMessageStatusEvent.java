package com.rashmi.springbootframework.dto.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,
        property = "typeId"
)
public class TxMessageStatusEvent implements StatusEvent {

    private final String id;
    private final String txId;
    private final String message;

    @JsonCreator
    public TxMessageStatusEvent(@JsonProperty("id") String id,
                                @JsonProperty("txId") String txId,
                                @JsonProperty("message") String message) {
        this.id = id;
        this.txId = txId;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getId() {
        return id;
    }

    public String getTxId() {
        return txId;
    }

}