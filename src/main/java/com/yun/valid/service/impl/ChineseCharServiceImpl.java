package com.yun.valid.service.impl;

import com.yun.valid.chineseChar.ChineseChar;
import com.yun.valid.service.ChineseCharService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

@Service
@Slf4j
public class ChineseCharServiceImpl implements ChineseCharService {

    public static final int WIDTH = 120;
    public static final int HEIGHT = 30;

    @Override
    public BufferedImage draw() {
        // 创建缓存
        BufferedImage bi = new BufferedImage(WIDTH, HEIGHT,
                BufferedImage.TYPE_INT_RGB);
        // 获得画布
        Graphics g = bi.getGraphics();
        // 设置背影色
        setBackGround(g);
        // 设置边框
        setBorder(g);
        // 画干扰线
        drawRandomLine(g);
        // 写随机数
        ChineseChar.hanzi((Graphics2D) g);
        //释放此图形的上下文以及它使用的所有系统资源，类似于关闭流
        g.dispose();
        return bi;
    }

    /**
     * 设置背景色
     *
     * @param g
     */
    private void setBackGround(Graphics g) {
        // 设置颜色
        g.setColor(Color.WHITE);
        // 填充区域
        g.fillRect(0, 0, WIDTH, HEIGHT);

    }

    /**
     * 设置边框
     *
     * @param g
     */
    private void setBorder(Graphics g) {
        // 设置边框颜色
        g.setColor(Color.BLUE);
        // 边框区域
        g.drawRect(1, 1, WIDTH - 2, HEIGHT - 2);
    }

    /**
     * 画随机线条
     *
     * @param g
     */
    private void drawRandomLine(Graphics g) {
        // 设置颜色
        g.setColor(Color.GREEN);
        // 设置线条个数并画线
        for (int i = 0; i < 5; i++) {
            int x1 = new Random().nextInt(WIDTH);
            int y1 = new Random().nextInt(HEIGHT);
            int x2 = new Random().nextInt(WIDTH);
            int y2 = new Random().nextInt(HEIGHT);
            g.drawLine(x1, y1, x2, y2);
        }

    }

}
