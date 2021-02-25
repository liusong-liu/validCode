package com.yun.valid.out;

import com.yun.valid.service.CalculatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 计算类验证码
 */
@RestController
@RequestMapping("/calculate")
public class CalculatImage {

    @Autowired
    private CalculatService calculatService;

    @GetMapping("/image")
    public void calculateImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        OutputStream os = response.getOutputStream();
        try {
            BufferedImage image = calculatService.getImage(response);
            //通过ImageIO对象的write静态方法将图片输出。
            ImageIO.write(image, "jpeg", os);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            os.close();
        }
    }

}
