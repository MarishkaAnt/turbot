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
    /* Вот здесь проблема, я уже пробовала инжектить,
    * тогда бот падает почему-то, если объявить его класс компонентом.
    * Пробовала передавать в конструкторе, но мне нечего передавать, я не могу создать инстанс сервиса
    * т.к. для new UserService() нужен userRepository, а это интерфейс и я не могу создать его объект.
    * Я пробовала автовайрить, но естественно это тоже не получилось.
    * В общем, не либо я чего-то не понимаю, либо мне просто не хватило времени чтобы разобраться.
    *
    * UserService userService;
    */

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

        /* невозможно работать с базой данных через userService отсюда.
        * мне нужно проверить есть ли юзер в БД, затем, если его нет,
        * засетить его чат-ид, затем уже обрабатывать логику и сообщения.
        * Но всё уперлось в создание юзерсервиса и я зашла в тупик.
         */

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
