package com.rashmi.springbootframework.service;

import com.rashmi.springbootframework.dto.events.AccStatusEvent;
import com.rashmi.springbootframework.dto.events.DataMessage;
import com.rashmi.springbootframework.exception.EventPublishException;

public interface EventProducer {

    void sendMessage(DataMessage message) throws EventPublishException;

    void sendAccountMessage(AccStatusEvent accountAsyncEvent) throws EventPublishException;

}