package uz.kiut.kiut_test_bot.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import uz.kiut.kiut_test_bot.BotRestConstants;
import uz.kiut.kiut_test_bot.payload.ResultTelegram;
import uz.kiut.kiut_test_bot.payload.SendPhotoOwn;

@FeignClient(url = BotRestConstants.TELEGRAM_BASE_URL_WITHOUT_BOT,name = "TelegramFeign")
public interface TelegramFeign {

    @PostMapping("{path}/sendMessage")
    ResultTelegram sendMessageToUser(@PathVariable String path, @RequestBody SendMessage sendMessage);

    @PostMapping("{path}/sendPhoto")
    ResultTelegram sendPhotoToUser(@PathVariable String path, @RequestBody SendPhotoOwn sendPhotoOwn);
}
