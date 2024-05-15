package uz.kiut.kiut_test_bot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.kiut.kiut_test_bot.service.TgService;

@RestController
@RequestMapping(BaseUrl.BASE_BOT_URL+"/telegram")
@RequiredArgsConstructor
public class WebhookController {
    private final TgService tgService;

    @PostMapping
    public void getRequestsFromClients(@RequestBody Update update){
//        System.out.println(update);
        tgService.updateWait(update);
    }

}
