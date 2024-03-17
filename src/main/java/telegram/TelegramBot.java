package telegram;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegram.buttons_menu.*;
import telegram.command.StartCommand;

import java.util.ArrayList;
import java.util.List;

public class TelegramBot extends TelegramLongPollingCommandBot {
    public TelegramBot() {
        register(new StartCommand());
        //register(new InfoCommand());
        //register(new SettingsCommand());
        //register(new BankCommand());
        //register(new CurrencyCommand());
        //register(new NumberOfPlacesCommand());
        //register(new NotificationTimeCommand());
        // register(new HelpCommand());
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
                getInfoButton(update);
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

        // Створюємо кнопки
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        InlineKeyboardButton bankButton = new InlineKeyboardButton();
        bankButton.setText("Банк");
        bankButton.setCallbackData("bank");
        row2.add(bankButton);

        List<InlineKeyboardButton> row3 = new ArrayList<>();
        InlineKeyboardButton currencyButton = new InlineKeyboardButton();
        currencyButton.setText("Валюта");
        currencyButton.setCallbackData("currency");
        row3.add(currencyButton);

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton digitsButton = new InlineKeyboardButton();
        digitsButton.setText("Кількість знаків після коми");
        digitsButton.setCallbackData("digits");
        row1.add(digitsButton);

        List<InlineKeyboardButton> row4 = new ArrayList<>();
        InlineKeyboardButton timeButton = new InlineKeyboardButton();
        timeButton.setText("Час сповіщень");
        timeButton.setCallbackData("time");
        row4.add(timeButton);

        List<InlineKeyboardButton> row5 = new ArrayList<>();
        InlineKeyboardButton backButton = new InlineKeyboardButton();
        backButton.setText("Повернутись до головного меню");
        backButton.setCallbackData("back");
        row5.add(backButton);

        // Добавляємо кнопки
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(row2);
        keyboard.add(row3);
        keyboard.add(row1);
        keyboard.add(row4);
        keyboard.add(row5);
        keyboardMarkup.setKeyboard(keyboard);

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

        // Створюємо кнопки
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton digitsButton = new InlineKeyboardButton();
        digitsButton.setText("ПриватБанк");
        digitsButton.setCallbackData("privatbank");
        row1.add(digitsButton);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        InlineKeyboardButton bankButton = new InlineKeyboardButton();
        bankButton.setText("МоноБанк");
        bankButton.setCallbackData("monobank");
        row2.add(bankButton);

        List<InlineKeyboardButton> row3 = new ArrayList<>();
        InlineKeyboardButton currencyButton = new InlineKeyboardButton();
        currencyButton.setText("НБУ");
        currencyButton.setCallbackData("nbu");
        row3.add(currencyButton);

        List<InlineKeyboardButton> row4 = new ArrayList<>();
        InlineKeyboardButton backButton = new InlineKeyboardButton();
        backButton.setText("Повернутись до головного меню");
        backButton.setCallbackData("back");
        row4.add(backButton);

        // Добавляємо кнопки
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboard.add(row4);
        keyboardMarkup.setKeyboard(keyboard);

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
        // Створюємо клавіатуру
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();

        // Створюємо кнопки
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton USDButton = new InlineKeyboardButton();
        USDButton.setText("USD");
        USDButton.setCallbackData("usd");
        row1.add(USDButton);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        InlineKeyboardButton EURButton = new InlineKeyboardButton();
        EURButton.setText("EUR");
        EURButton.setCallbackData("eur");
        row2.add(EURButton);

        List<InlineKeyboardButton> row3 = new ArrayList<>();
        InlineKeyboardButton GPBButton = new InlineKeyboardButton();
        GPBButton.setText("GPB");
        GPBButton.setCallbackData("gpb");
        row3.add(GPBButton);

        List<InlineKeyboardButton> row4 = new ArrayList<>();
        InlineKeyboardButton backButton = new InlineKeyboardButton();
        backButton.setText("Повернутись до головного меню");
        backButton.setCallbackData("back");
        row4.add(backButton);

        // Добавляємо кнопки
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboard.add(row4);
        keyboardMarkup.setKeyboard(keyboard);

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

        // Створюємо клавіатуру
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();

        // Створюємо кнопки
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton twoPlaceButton = new InlineKeyboardButton();
        twoPlaceButton.setText("2");
        twoPlaceButton.setCallbackData("twoPlaces");
        row1.add(twoPlaceButton);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        InlineKeyboardButton threePlaceButton = new InlineKeyboardButton();
        threePlaceButton.setText("3");
        threePlaceButton.setCallbackData("threePlaces");
        row2.add(threePlaceButton);

        List<InlineKeyboardButton> row3 = new ArrayList<>();
        InlineKeyboardButton fourPlacesButton = new InlineKeyboardButton();
        fourPlacesButton.setText("4");
        fourPlacesButton.setCallbackData("fourPlaces");
        row3.add(fourPlacesButton);

        List<InlineKeyboardButton> row4 = new ArrayList<>();
        InlineKeyboardButton backButton = new InlineKeyboardButton();
        backButton.setText("Повернутись до головного меню");
        backButton.setCallbackData("back");
        row4.add(backButton);

        // Добавляємо кнопки
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboard.add(row4);
        keyboardMarkup.setKeyboard(keyboard);

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
        responseMessage.setText("Оберіть банк:");

// Створюємо клавіатуру
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();

        // Створюємо кнопки
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton Button9 = new InlineKeyboardButton();
        Button9.setText("9");
        Button9.setCallbackData("button9");
        row1.add(Button9);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        InlineKeyboardButton Button10 = new InlineKeyboardButton();
        Button10.setText("10");
        Button10.setCallbackData("button10");
        row2.add(Button10);

        List<InlineKeyboardButton> row3 = new ArrayList<>();
        InlineKeyboardButton Button11 = new InlineKeyboardButton();
        Button11.setText("11");
        Button11.setCallbackData("button11");
        row3.add(Button11);

        List<InlineKeyboardButton> row4 = new ArrayList<>();
        InlineKeyboardButton Button12 = new InlineKeyboardButton();
        Button12.setText("12");
        Button12.setCallbackData("button12");
        row4.add(Button12);

        List<InlineKeyboardButton> row5 = new ArrayList<>();
        InlineKeyboardButton Button13 = new InlineKeyboardButton();
        Button13.setText("13");
        Button13.setCallbackData("button13");
        row5.add(Button13);

        List<InlineKeyboardButton> row6 = new ArrayList<>();
        InlineKeyboardButton Button14= new InlineKeyboardButton();
        Button14.setText("14");
        Button14.setCallbackData("button14");
        row6.add(Button14);

        List<InlineKeyboardButton> row7 = new ArrayList<>();
        InlineKeyboardButton Button15 = new InlineKeyboardButton();
        Button15.setText("15");
        Button15.setCallbackData("button16");
        row7.add(Button15);

        List<InlineKeyboardButton> row8 = new ArrayList<>();
        InlineKeyboardButton Button16 = new InlineKeyboardButton();
        Button16.setText("16");
        Button16.setCallbackData("button16");
        row8.add(Button16);

        List<InlineKeyboardButton> row9 = new ArrayList<>();
        InlineKeyboardButton Button17 = new InlineKeyboardButton();
        Button17.setText("17");
        Button17.setCallbackData("button17");
        row9.add(Button17);

        List<InlineKeyboardButton> row11 = new ArrayList<>();
        InlineKeyboardButton Button18 = new InlineKeyboardButton();
        Button18.setText("Вимкнути сповіщення");
        Button18.setCallbackData("button18");
        row11.add(Button18);

        List<InlineKeyboardButton> row12 = new ArrayList<>();
        InlineKeyboardButton backButton = new InlineKeyboardButton();
        backButton.setText("Повернутись до головного меню");
        backButton.setCallbackData("back");
        row12.add(backButton);

        // Додаємо кнопки
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboard.add(row4);
        keyboard.add(row5);
        keyboard.add(row6);
        keyboard.add(row7);
        keyboard.add(row8);
        keyboard.add(row9);
        keyboard.add(row11);
        keyboard.add(row12);
        keyboardMarkup.setKeyboard(keyboard);

        responseMessage.setReplyMarkup(keyboardMarkup);

        try {
            execute(responseMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void backToMenu(Update update) {
        SendMessage responseMessage = new SendMessage();
        long chatId = update.getCallbackQuery().getMessage().getChatId();
        responseMessage.setChatId(Long.toString(chatId));
        responseMessage.setText("Повернення на головне меню");
        try {
            execute(responseMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
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