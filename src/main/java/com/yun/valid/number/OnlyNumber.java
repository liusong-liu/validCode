package com.yun.valid.number;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数字验证码
 */
@RestController
@RequestMapping("/onlyNumber")
@Slf4j
public class OnlyNumber {

    /**
     * 生成对应位数的验证码
     * @return
     */
    @GetMapping("/number")
    public String onlyNumber(int x){
        System.out.println("位数 " + x);
        int random = (int) ((Math.random() * 9) * Math.pow(10, x));
        return String.valueOf(random);
    }
}
