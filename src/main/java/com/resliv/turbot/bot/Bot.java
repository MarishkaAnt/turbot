package com.resliv.turbot.bot;

import com.resliv.turbot.model.User;
import com.resliv.turbot.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class Bot extends TelegramLongPollingBot {

    private String botName;
    private String botToken;

    private UserService userService;

    public Bot(String name, String token) {
        this.botName = name;
        this.botToken = token;
    }
    public Bot(UserService userService) { this.userService = userService; }

    @Override
    public String getBotUsername() { return this.botName; }

    @Override
    public String getBotToken() { return this.botToken; }

    @Override
    public void onUpdateReceived(Update update) {

        Long chatId = update.getMessage().getChatId();
        String inputText = update.getMessage().getText();
        final String GREETINGS = "Привет! Я - туристический бот! " +
                "Я могу рассказать что-ниудь интересное о разных городах. " +
                "Для начала, давай познакомимся. Как я могу к тебе обращаться?";
        if (inputText.startsWith("/start")) {
            SendMessage message = new SendMessage();
            message.setChatId(String.valueOf(chatId));
            message.setText(GREETINGS);

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

/*
        if (!update.hasMessage() || !update.getMessage().hasText())
            return;

        final String text = update.getMessage().getText();
        final long chatId = update.getMessage().getChatId();

        User user = userService.findByChatId(chatId);

        BotContext context;
        BotState state;

        if (user == null) {
            state = BotState.getInitialState();

            user = User.builder()
                    .chatId(chatId)
                    .botState(state)
                    .build();
            userService.addUser(user);

            context = BotContext.of(this, user, text);
            state.enter(context);

            log.info("New user registered: " + chatId);
        } else {
            context = BotContext.of(this, user, text);
            state = BotState.byId(user.getStateId());

            log.info("Update received for user in state: " + state);
        }

        state.handleInput(context);

        do {
            state = state.nextState();
            state.enter(context);
        } while (!state.isInputNeeded());

        user.setStateId(state.ordinal());
        userService.updateUser(user);
*/

    }
}
