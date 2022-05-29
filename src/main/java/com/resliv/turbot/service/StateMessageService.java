package com.resliv.turbot.service;

import com.resliv.turbot.model.StateMessage;

import java.util.List;

public interface StateMessageService {

    void updateMessageByState(String message, String state);

    List<StateMessage> findAll();
}