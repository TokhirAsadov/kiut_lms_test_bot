package uz.kiut.kiut_test_bot.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Message;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultTelegram {
    private Boolean ok;

    private Message result;

}
