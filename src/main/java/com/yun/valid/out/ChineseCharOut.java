package com.yun.valid.out;

import com.yun.valid.service.ChineseCharService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@RestController
@Slf4j
@RequestMapping("/chinese/char")
public class ChineseCharOut {

    @Autowired
    private ChineseCharService chineseCharService;

    @GetMapping("/draw")
    public void charOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        BufferedImage draw = chineseCharService.draw();
        // 将图形写给浏览器
        response.setContentType("image/jpeg");
        // 控制浏览器不要缓存
        response.setDateHeader("expries", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        ImageIO.write(draw, "jpeg", response.getOutputStream());
    }
}
