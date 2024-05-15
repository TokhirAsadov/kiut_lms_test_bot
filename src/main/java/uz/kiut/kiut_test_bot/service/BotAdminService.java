package uz.kiut.kiut_test_bot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import uz.kiut.kiut_test_bot.BotRestConstants;
import uz.kiut.kiut_test_bot.feign.TelegramFeign;
import uz.kiut.kiut_test_bot.payload.ResultTelegram;
import uz.kiut.kiut_test_bot.payload.SendPhotoOwn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BotAdminService {
//    private final RestTemplate getRestTemplate;
    private final TelegramFeign telegramFeign;

    private Set<String> userChatIdList = new HashSet<>(Arrays.asList("645257161"));

    public String sendMessage(String message) {
        for (String userChatId : userChatIdList) {
            SendMessage sendMessage = new SendMessage(userChatId,message);
//            ResultTelegram object = getRestTemplate.postForObject(BotRestConstants.TELEGRAM_BASE_URL + BotRestConstants.BOT_TOKEN + "/sendMessage", sendMessage, ResultTelegram.class);
            ResultTelegram resultTelegram = telegramFeign.sendMessageToUser(BotRestConstants.TELEGRAM_FEIGN_PATH, sendMessage);
            System.out.println(resultTelegram);
        }

        return "Message was sent";
    }

    public String sendPhoto(String fileName, String text) {

        for (String userChatId : userChatIdList) {
            SendPhotoOwn sendPhotoOwn = new SendPhotoOwn(
                    userChatId,
                    text,
                    fileName);

            ResultTelegram resultTelegram = telegramFeign.sendPhotoToUser(BotRestConstants.TELEGRAM_FEIGN_PATH, sendPhotoOwn);
            System.out.println(resultTelegram);
        }

        return "Photo was sent";
    }
}
