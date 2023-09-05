package com.rashmi.springbootframework.dto.events;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface AccStatusEvent extends StatusEvent {

    String getId();

    @JsonIgnore
    String keyMessageKey();

}