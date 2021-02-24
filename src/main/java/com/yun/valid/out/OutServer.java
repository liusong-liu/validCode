package com.yun.valid.out;

import com.yun.valid.number.LetterNumber;
import com.yun.valid.number.OnlyNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validCode")
@Slf4j
public class OutServer {

    /**
     * 生成对应位数的验证码
     * @return
     */
    @GetMapping("/onlyNumber")
    public String onlyNumber(int x){
        OnlyNumber onlyNumber = new OnlyNumber();
        return onlyNumber.make(x);
    }

    /**
     * 字母数字混合一
     * @param x
     * @return
     */
    @GetMapping("/letterAndNum")
    public String letterAndNum1(int x){
        LetterNumber ln = new LetterNumber();
        return ln.make1(x);
    }

    /**
     * 字母数字混合二
     * @param x
     * @return
     */
    @GetMapping("/letterAndNum2")
    public String letterAndNum2(int x){
        LetterNumber ln = new LetterNumber();
        return ln.make2(x);
    }
}
