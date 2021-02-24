package com.yun.valid.service.impl;

import com.yun.valid.number.LetterNumber;
import com.yun.valid.out.OutServer;
import com.yun.valid.service.OutImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

@Service
public class OutImageServiceImpl implements OutImageService {
    private static final int W = 250;
    private static final int H = 100;


    @Override
    public BufferedImage getImage(HttpSession httpSession) {
        BufferedImage bufferedImage = new BufferedImage(W, H, BufferedImage.TYPE_INT_BGR);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, W, H);
        StringBuffer StringBuffer = new StringBuffer();
        Font font = new Font("微软雅黑", Font.BOLD, 24);
        //随机验证码字符
        for (int i = 0; i < 6; i++) {
            String zm = LetterNumber.make1(1);
            StringBuffer.append(zm);
            graphics.setFont(font);
            graphics.setColor(randomColor());
            graphics.drawString(zm, (1 + i) * (W / 7), H * 3 / 4);
        }
        String code = StringBuffer.toString();
        httpSession.setAttribute("code", code);//将code验证码存入session
        huaXian(graphics);
        return bufferedImage;
    }

    //添加干扰线
    public void huaXian(Graphics graphics) {
        Random random = new Random();
        for(int i=0;i<5;i++) {
            graphics.setColor(randomColor());
            int x1 = random.nextInt(20);
            int y1 = random.nextInt(H);
            int x2=(W-20)+random.nextInt(20);
            int y2=random.nextInt(H);
            graphics.drawLine(x1, y1, x2, y2);
        }
    }

    public Color randomColor() {
        Random random = new Random();
        int R = random.nextInt(256);
        int G = random.nextInt(256);
        int B = random.nextInt(256);
        Color color = new Color(R,G,B);
        return color;
    }
}
