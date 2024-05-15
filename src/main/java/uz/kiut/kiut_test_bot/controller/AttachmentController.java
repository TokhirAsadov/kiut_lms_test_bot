package uz.kiut.kiut_test_bot.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.kiut.kiut_test_bot.service.AttachmentService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping(BaseUrl.BASE_BOT_URL+"/attachment")
@RequiredArgsConstructor
public class AttachmentController {
    private final AttachmentService attachmentService;
    String uploadPath = "/botPhotos";

    @GetMapping
    public void getFileByName(@RequestParam String name, HttpServletResponse response) throws IOException {
        File file = new File(uploadPath+"/"+name);
        response.setContentType("image/jpeg");
        response.setHeader("Cache-Control","max-age=8640000");
        response.setHeader("Content-disposition","attachment; filename=\""+name+"\"");
        InputStream in = new FileInputStream(file);
        FileCopyUtils.copy(in, response.getOutputStream());
    }


}
