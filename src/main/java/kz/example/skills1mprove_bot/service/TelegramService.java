package kz.example.skills1mprove_bot.service;

import org.springframework.web.client.RestTemplate;

public class TelegramService {

    private final String botToken = "7290559943:AAFZXSLjobXELzcdhZy7u-tHTD3DeNmXPIs";
    private final String chatId = "1028253938";

    public void sendMessage(String message) {
        String url = "https://api.telegram.org/bot" + botToken + "/sendMessage?chat_id=" + chatId + "&text=" + message;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(url, String.class);
    }

    public void sendMessage(Long chatId, String s) {
    }
}