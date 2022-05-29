package com.resliv.turbot.bot;

import com.resliv.turbot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
public class Bot extends TelegramLongPollingBot {

    private final String botName;
    private final String botToken;

    //UserService userService;


    public Bot(String name, String token) {
        this.botName = name;
        this.botToken = token;
    }

    @Override
    public String getBotUsername() { return this.botName; }

    @Override
    public String getBotToken() { return this.botToken; }

    @Override
    public void onUpdateReceived(Update update) {

        // невозможно работать с чертовой базой данных через userService отсюда.
        // я сдаюсь!

        Long chatId = update.getMessage().getChatId();
        String inputText = update.getMessage().getText();

        //userService.findByChatId(chatId);


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
    }
}
