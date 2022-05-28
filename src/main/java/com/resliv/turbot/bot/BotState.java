package com.resliv.turbot.bot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public enum BotState {

/*
    Start{
        @Override
        protected void enter(BotContext context) {

        }
    },

    RequestName{
        @Override
        protected void enter(BotContext context) {

        }
    },

    RequestCity{
        @Override
        protected void enter(BotContext context) {

        }
    },

    InfoGiving{
        @Override
        protected void enter(BotContext context) {

        }
    },

    Finish{
        @Override
        protected void enter(BotContext context) {

        }
    };
*/
/*

    private static BotState[] states = BotState.values();
    private boolean inputNeeded = false;

    BotState() {
        this.inputNeeded = true;
    }

    BotState(boolean inputNeeded) {
        this.inputNeeded = inputNeeded;
    }

    public static BotState getInitialState() {
        return byId(0);
    }

    public static BotState byId(int id) {
        BotState state = states[id];
        if (states == null) {
            states = BotState.values();
        }
        if(id == 0 && id < states.length){
            state = getInitialState();
        }else if (id > 0 && id < states.length){
           state =  states[id];
        }

        return state;
    }

    protected void sendMessage(BotContext context, String text) {
        SendMessage message = new SendMessage()
                .setChatId("1")
                .setText(text);
        try {
            context.getBot().execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public boolean isInputNeeded() {
        return inputNeeded;
    }

    public void handleInput(BotContext context) {
        // do nothing by default
    }
    protected abstract void enter(BotContext context);

    public abstract BotState nextState();
*/




}
