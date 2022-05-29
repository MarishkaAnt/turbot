package com.resliv.turbot.controller;

import com.resliv.turbot.model.StateMessage;
import com.resliv.turbot.service.StateMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/state")
@RequiredArgsConstructor
public class StateMessageController {

    private final StateMessageService stateMessageService;

    @GetMapping("/all")
    public ResponseEntity<List<StateMessage>> get() {
        return new ResponseEntity<>(stateMessageService.findAll(), HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<Void> update(@RequestParam String message, String state) {
        if (state == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            stateMessageService.updateMessageByState(message, state);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
