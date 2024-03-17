package telegram.buttons_menu;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class CurrencyCommand extends BotCommand {
    public CurrencyCommand() {
        super("currency", "Валюта");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        SendMessage message = new SendMessage();
        message.setChatId(chat.getId().toString());
        message.setText("Оберіть валюту:");

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
        backButton.setCallbackData("/start");
        row4.add(backButton);

        // Добавляємо кнопки
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboard.add(row4);
        keyboardMarkup.setKeyboard(keyboard);

        message.setReplyMarkup(keyboardMarkup);

        try {
            absSender.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
