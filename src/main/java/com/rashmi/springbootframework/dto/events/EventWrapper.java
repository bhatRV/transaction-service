package com.rashmi.springbootframework.dto.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EventWrapper<T extends AccStatusEvent> {

    private final T event;

    @JsonCreator
    public EventWrapper(@JsonProperty("event") T event) {
        this.event = event;
    }

    public T getEvent() {
        return event;
    }

    @JsonIgnore
    public Class<? extends StatusEvent> getType() {
        return event.getClass();
    }

}