package com.resliv.turbot.service.impl;

import com.resliv.turbot.model.StateMessage;
import com.resliv.turbot.repository.StateMessageRepository;
import com.resliv.turbot.service.StateMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StateMessageServiceImpl implements StateMessageService {

    private final StateMessageRepository stateMessageRepository;

    @Override
    @Transactional
    public void updateMessageByState(String message, String state) {
        stateMessageRepository.setMessageByState(message, state);
    }

    @Override
    public List<StateMessage> findAll() {
        return stateMessageRepository.findAll();
    }
}