package com.yun.valid.number;

import static java.lang.String.*;

public class CalculatNum {

    public static String[] calculate() {
        int round = (int) Math.round(Math.random() * 2);
        System.out.println("round = " + round);
        String[] value = new String[3];
        int captchaNo = 0;
        switch (round){
            case 0:
                value = add();
                captchaNo = Integer.valueOf(value[0]) + Integer.valueOf(value[1]);
                break;
            case 1:
                value = sub();
                captchaNo = Integer.valueOf(value[0]) - Integer.valueOf(value[1]);
                break;
            case 2:
                value = mult();
                captchaNo = Integer.valueOf(value[0]) * Integer.valueOf(value[1]);
                break;
        }
        System.out.println(value[0]+value[2]+value[1]+"=");
        String[] result = new String[2];
        result[0] = value[0]+value[2]+value[1]+"=";
        result[1] = String.valueOf(captchaNo);
        return result;
    }

    public static String[] add() {
        long first = Math.round(Math.random() * (50 - 5) + 5);
        long secord = Math.round(Math.random() * (50 - 5) + 5);
        String[] value = new String[]{valueOf(first), valueOf(secord), "+"};
        return value;
    }

    public static String[] sub() {
        long first = Math.round(40+Math.random() * 90);
        long secord = Math.round(Math.random() * 39);
        String[] value = new String[]{valueOf(first), valueOf(secord), "-"};
        return value;
    }

    public static String[] mult() {
        long first = Math.round(Math.random() * 9);
        long secord = Math.round(Math.random() * 9);
        String[] value = new String[]{valueOf(first), valueOf(secord), "*"};
        return value;
    }


    public static void main(String[] args) {
//        System.out.println("add() = " + add());
//        System.out.println("sub() = " + sub()+" :"+ sub()[0]+sub()[2]+sub()[1]);
//        System.out.println("mult() = " + mult()+" :"+ mult()[0]+mult()[2]+mult()[1]);
        String[] calculate = calculate();
        System.out.println("calculate : " + calculate);
    }


}
