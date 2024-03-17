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

public class NotificationTimeCommand extends BotCommand {
    public NotificationTimeCommand() {
        super("times", "Час сповіщень");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        SendMessage message = new SendMessage();
        message.setChatId(chat.getId().toString());
        message.setText("Час сповіщень:");

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
        InlineKeyboardButton Button19 = new InlineKeyboardButton();
        Button19.setText("Вимкнути сповіщення");
        Button19.setCallbackData("button19");
        row11.add(Button19);

        List<InlineKeyboardButton> row12 = new ArrayList<>();
        InlineKeyboardButton backButton = new InlineKeyboardButton();
        backButton.setText("Повернутись до головного меню");
        backButton.setCallbackData("/start");
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

        message.setReplyMarkup(keyboardMarkup);

        try {
            absSender.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
