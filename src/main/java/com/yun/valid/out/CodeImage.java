package com.yun.valid.out;

import com.yun.valid.service.OutImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

@Slf4j
@RequestMapping("/codeImage")
@RestController
public class CodeImage {

    @Autowired
    private OutImageService outImageService;

    @GetMapping("/getCode")
    public void getCodeImage(HttpServletResponse httpServletResponse, HttpSession httpSession){
        BufferedImage image=outImageService.getImage(httpSession);
        try {
            ServletOutputStream outputStream = httpServletResponse.getOutputStream();
            ImageIO.write(image, "png", outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
