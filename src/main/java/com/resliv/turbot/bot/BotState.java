package com.resliv.turbot.bot;

import com.resliv.turbot.model.City;
import com.resliv.turbot.model.User;
import com.resliv.turbot.service.UserService;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public enum BotState {

    Start{
        @Override
        protected void enter(BotContext context) {
            sendMessage(context, "Hello!");
        }

        @Override
        public BotState nextState() {
            return RequestName;
        }
    },

    RequestName{
        @Override
        protected void enter(BotContext context) {
            sendMessage(context, "What is yor name?");
        }

        @Override
        public void handleInput(BotContext context) {
            context.getUser().setName(context.getInput());
        }

        @Override
        public BotState nextState() {
            return RequestCity;
        }
    },

    RequestCity{
        @Override
        protected void enter(BotContext context) {
            sendMessage(context, "Enter the city name:");
        }

        @Override
        public void handleInput(BotContext context) {
            String input = context.getInput();
            User user = context.getUser();
        }

        @Override
        public BotState nextState() {
            return InfoGiving;
        }
    },

    InfoGiving{
        @Override
        protected void enter(BotContext context) {
            sendMessage(context, "Info:");
        }

        @Override
        public BotState nextState() {
            return Finish;
        }
    },

    Finish{
        @Override
        protected void enter(BotContext context) {
            sendMessage(context, "Finish!");
        }

        @Override
        public BotState nextState() {
            return Start;
        }
    };
    private UserService userService;
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
        SendMessage message = new SendMessage();
        message.setChatId("1");
        message.setText(text);
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





}
