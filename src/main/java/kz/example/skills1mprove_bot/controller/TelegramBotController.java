package kz.example.skills1mprove_bot.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.example.skills1mprove_bot.service.TelegramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/telegram")
public class TelegramBotController {

    @Autowired
    private TelegramService telegramService;

    // ObjectMapper для работы с JSON
    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/update")
    public void receiveUpdate(@RequestBody String update) {
        try {
            // Преобразование строки JSON в объект JsonNode для удобной работы
            JsonNode jsonNode = objectMapper.readTree(update);

            // Извлекаем ID чата и текст сообщения
            Long chatId = jsonNode.path("message").path("chat").path("id").asLong();
            String messageText = jsonNode.path("message").path("text").asText();

            // Проверяем, какую команду или сообщение отправил пользователь
            if (messageText.equals("/start")) {
                telegramService.sendMessage(chatId, "Добро пожаловать! Пожалуйста, зарегистрируйтесь.");
            } else if (messageText.equals("/register")) {
                // Вызов метода регистрации
                telegramService.sendMessage(chatId, "Введите данные для регистрации.");
            } else if (messageText.equals("/login")) {
                // Вызов метода аутентификации
                telegramService.sendMessage(chatId, "Введите данные для входа.");
            } else {
                telegramService.sendMessage(chatId, "Команда не распознана.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

