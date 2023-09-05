package com.rashmi.springbootframework.dto.events;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,
        property = "typeId"
)
public interface StatusEvent {
}