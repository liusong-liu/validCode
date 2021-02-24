package com.yun.valid.number;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数字验证码
 */
@Slf4j
public class OnlyNumber {

    /**
     * 生成对应位数的验证码
     * @return
     */
    public String make(int x){
        System.out.println("位数 " + x);
        String len = "";
        for (int i = 0; i <x ; i++) {
            long random = Math.round(Math.random()*9);
            len+= random+"";
        }
        return len;
    }
}
