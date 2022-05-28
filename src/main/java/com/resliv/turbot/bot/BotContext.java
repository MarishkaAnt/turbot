package com.resliv.turbot.bot;

import com.resliv.turbot.model.User;
import lombok.Getter;

@Getter
public class BotContext {
    private final Bot bot;
    private final User user;
    private final String input;

    public static BotContext of(Bot bot, User user, String text) {
        return new BotContext(bot, user, text);
    }

    private BotContext(Bot bot, User user, String input) {
        this.bot = bot;
        this.user = user;
        this.input = input;
    }

}
