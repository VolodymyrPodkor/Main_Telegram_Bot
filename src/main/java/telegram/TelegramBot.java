package telegram;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegram.command.StartCommand;

import java.util.ArrayList;
import java.util.List;

public class TelegramBot extends TelegramLongPollingCommandBot {
    public TelegramBot() {
        register(new StartCommand());
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        if (update.hasCallbackQuery()) {
            String callbackQuery = update.getCallbackQuery().getData();
            SendMessage responseMessage = new SendMessage();
            long chatId = update.getCallbackQuery().getMessage().getChatId();
            responseMessage.setChatId(Long.toString(chatId));

            if (callbackQuery.equals("info")) {
                getInfoButton(update);
            } else if (callbackQuery.equals("settings")) {
                settingsButton(update);
            } else if (callbackQuery.equals("bank")) {
                    bankButton(update);
            } else if (callbackQuery.equals("currency")) {
                currencyButton(update);
            } else if (callbackQuery.equals("digits")) {
                commaButton(update);
            } else if (callbackQuery.equals("time")) {
                setTimeButton(update);
            } else if (callbackQuery.equals("back")) {
                backToMenuButton(update);
            }
                try {
                    execute(responseMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }

    private void getInfoButton(Update update) {
        SendMessage responseMessage = new SendMessage();
        long chatId = update.getCallbackQuery().getMessage().getChatId();
        responseMessage.setChatId(Long.toString(chatId));
        responseMessage.setText("Треба добавити функціонал.");
        try {
            execute(responseMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void settingsButton(Update update) {
        SendMessage responseMessage = new SendMessage();
        long chatId = update.getCallbackQuery().getMessage().getChatId();
        responseMessage.setChatId(Long.toString(chatId));
        responseMessage.setText("Виберіть налаштування:");

        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboardButtons = new ArrayList<>();

        keyboardButtons.add(createButtonRow("Банк", "bank"));
        keyboardButtons.add(createButtonRow("Валюта", "currency"));
        keyboardButtons.add(createButtonRow("Кількість знаків після коми", "digits"));
        keyboardButtons.add(createButtonRow("Час сповіщень", "time"));
        keyboardButtons.add(createButtonRow("Повернутись до головного меню", "back"));

        keyboardMarkup.setKeyboard(keyboardButtons);
        responseMessage.setReplyMarkup(keyboardMarkup);

        try {
            execute(responseMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void bankButton(Update update) {
        SendMessage responseMessage = new SendMessage();
        long chatId = update.getCallbackQuery().getMessage().getChatId();
        responseMessage.setChatId(Long.toString(chatId));
        responseMessage.setText("Оберіть банк:");

        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboardButtons = new ArrayList<>();

        keyboardButtons.add(createButtonRow("ПриватБанк", "privatbank"));
        keyboardButtons.add(createButtonRow("МоноБанк", "monobank"));
        keyboardButtons.add(createButtonRow("НБУ", "nbu"));
        keyboardButtons.add(createButtonRow("Повернутись до головного меню", "back"));

        keyboardMarkup.setKeyboard(keyboardButtons);
        responseMessage.setReplyMarkup(keyboardMarkup);

        try {
            execute(responseMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void currencyButton(Update update) {
        SendMessage responseMessage = new SendMessage();
        long chatId = update.getCallbackQuery().getMessage().getChatId();
        responseMessage.setChatId(Long.toString(chatId));
        responseMessage.setText("Оберіть валюту:");

        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboardButtons = new ArrayList<>();

        keyboardButtons.add(createButtonRow("USD", "usd"));
        keyboardButtons.add(createButtonRow("EUR", "eur"));
        keyboardButtons.add(createButtonRow("GPB", "gpb"));
        keyboardButtons.add(createButtonRow("Повернутись до головного меню", "back"));

        keyboardMarkup.setKeyboard(keyboardButtons);
        responseMessage.setReplyMarkup(keyboardMarkup);

        try {
            execute(responseMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void commaButton(Update update) {
        SendMessage responseMessage = new SendMessage();
        long chatId = update.getCallbackQuery().getMessage().getChatId();
        responseMessage.setChatId(Long.toString(chatId));
        responseMessage.setText("Кількість знаків після коми:");

        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>>  keyboardButtons = new ArrayList<>();

        keyboardButtons.add(createButtonRow("2", "twoCommas"));
        keyboardButtons.add(createButtonRow("3", "threeCommas"));
        keyboardButtons.add(createButtonRow("4", "fourCommas"));
        keyboardButtons.add(createButtonRow("Повернутись до головного меню", "back"));

        keyboardMarkup.setKeyboard(keyboardButtons);
        responseMessage.setReplyMarkup(keyboardMarkup);

        try {
            execute(responseMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void setTimeButton(Update update) {
        SendMessage responseMessage = new SendMessage();
        long chatId = update.getCallbackQuery().getMessage().getChatId();
        responseMessage.setChatId(Long.toString(chatId));
        responseMessage.setText("Оберіть час сповіщення:");

        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboardButtons = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        row1.addAll(createButtonRow("9", "button9"));
        row1.addAll(createButtonRow("10", "button10"));
        row1.addAll(createButtonRow("11", "button11"));
        keyboardButtons.add(row1);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        row2.addAll(createButtonRow("12", "button12"));
        row2.addAll(createButtonRow("13", "button13"));
        row2.addAll(createButtonRow("14", "button14"));
        keyboardButtons.add(row2);

        List<InlineKeyboardButton> row3 = new ArrayList<>();
        row3.addAll(createButtonRow("15", "button15"));
        row3.addAll(createButtonRow("16", "button16"));
        row3.addAll(createButtonRow("17", "button17"));
        keyboardButtons.add(row3);

        keyboardButtons.add(createButtonRow("Вимкнути сповіщення", "turnOff"));
        keyboardButtons.add(createButtonRow("Повернутись до головного меню", "back"));

        keyboardMarkup.setKeyboard(keyboardButtons);
        responseMessage.setReplyMarkup(keyboardMarkup);

        try {
            execute(responseMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void backToMenuButton(Update update) {
        SendMessage responseMessage = new SendMessage();
        long chatId = update.getCallbackQuery().getMessage().getChatId();
        responseMessage.setChatId(Long.toString(chatId));
        responseMessage.setText("Ласкаво просимо. Цей бот допоможе відслідковувати актуальні курси валют.");

        InlineKeyboardMarkup keyboardMarkup =new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboardButtons = new ArrayList<>();

        keyboardButtons.add(createButtonRow("Отримати інфо", "info"));
        keyboardButtons.add(createButtonRow("Налаштування", "settings"));

        keyboardMarkup.setKeyboard(keyboardButtons);
        responseMessage.setReplyMarkup(keyboardMarkup);

        try {
            execute(responseMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private List<InlineKeyboardButton> createButtonRow(String buttonText, String callbackData) {
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(buttonText);
        button.setCallbackData(callbackData);
        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(button);
        return row;
    }

    @Override
    public String getBotToken() {
        return BotConstants.BOT_TOKEN;
    }

    @Override
    public String getBotUsername() {
        return BotConstants.BOT_NAME;
    }
}