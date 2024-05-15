package uz.kiut.kiut_test_bot.service;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


@Service
public class AttachmentService {


    String uploadPath = "/botPhotos";

    public void getFileByName(String name, HttpServletResponse response) throws IOException {
        File file = new File(uploadPath+"/"+name);
        response.setContentType("image/jpeg");
        response.setHeader("Cache-Control","max-age=8640000");
        response.setHeader("Content-Disposition","attachment; filename=\""+name+"\"");
        InputStream in = new FileInputStream(file);
        FileCopyUtils.copy(in, response.getOutputStream());
    }
}
