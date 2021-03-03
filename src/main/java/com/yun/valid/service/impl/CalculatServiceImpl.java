package com.yun.valid.service.impl;

import com.yun.valid.number.CalculatNum;
import com.yun.valid.service.CalculatService;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Random;

@Service
public class CalculatServiceImpl implements CalculatService {
    @Override
    public BufferedImage getImage(HttpServletResponse response) throws Exception{
        int width = 100, height = 30;
        //创建BufferedImage对象，设置图片的长度宽度和色彩。
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //取得Graphics对象，用来绘制图片
        Graphics g = image.getGraphics();

        //绘制图片背景和文字,释放Graphics对象所占用的资源。
        g.setColor(getRandColor(50, 100));

        //设置内容生成的位置
        g.fillRect(0, 0, width, height);

        //设置内容的字体和大小
        g.setFont(new Font("Times New Roman", Font.BOLD, 20));

        //图片背景上随机生成100干扰线，避免通过图片识别破解验证码
        for (int i = 0; i < 100; i++) {
            Random random = new Random();
            //设置内容的颜色：主要为生成图片背景的线条
            g.setColor(getRandColor(100, 200));
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(width);
            int yl = random.nextInt(height);
            g.drawLine(x, y, x+1, y+1);
        }
        g.setColor(getRandColor(100, 250));
        String[] value = calculatStr();
        //计算结果
        String result = value[1];
        System.out.println("result = " + result);
        // 将运算式绘到图片中
        g.drawString(value[0], 2, 22);
        //释放此图形的上下文以及它使用的所有系统资源，类似于关闭流
        g.dispose();
        return image;

//        os.close();
    }

    /**
     * 得到随机数和计算结果
     * @return String[] [0] 计算公式 [1]计算结果
     */
    public String[] calculatStr(){
        return CalculatNum.calculate();
    }

    /**
     * 生成随机颜色
     * @param fc
     * @param bc
     * @return
     */
    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}
