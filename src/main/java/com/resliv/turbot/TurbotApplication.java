package com.resliv.turbot;

import com.resliv.turbot.bot.Bot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class TurbotApplication {

	private static final String BOT_NAME = "bot_TurBot";
	private static  final String BOT_TOKEN = "5313838550:AAEg87Zn9mwEInZeealhynD3hfc1EUJF1ZM";

	public static void main(String[] args) {
		SpringApplication.run(TurbotApplication.class, args);
		try {
			TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
			botsApi.registerBot(new Bot(BOT_NAME, BOT_TOKEN));
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

}
