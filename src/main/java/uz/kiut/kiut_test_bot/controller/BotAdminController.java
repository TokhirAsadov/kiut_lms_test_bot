package uz.kiut.kiut_test_bot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.kiut.kiut_test_bot.service.BotAdminService;

@RestController
@RequestMapping(BaseUrl.BASE_BOT_URL+"/admin")
@RequiredArgsConstructor
public class BotAdminController {

    private final BotAdminService botAdminService;

    @GetMapping("/sendMessage")
    public String sendMessage(@RequestParam String message) {
         return botAdminService.sendMessage(message);
    }

    @GetMapping("/sendPhoto")
    public String sendPhoto(@RequestParam String fileName, @RequestParam String text) {
        return botAdminService.sendPhoto(fileName,text);
    }
}
