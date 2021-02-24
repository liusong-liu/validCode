package com.yun.valid.number;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LetterNumber {

    public static String make1(int x){
        String[] str = {"0","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String len = "";
        for (int i = 0; i < x; i++) {
            int index = (int) Math.round(Math.random() * (str.length-1));
            len+=str[index];
        }
        return len;
    }

    public static String make2(int x){
        String dict = "023456789abcdefghijkmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String len = "";
        for (int i = 0; i < x; i++) {
            int index = (int) Math.round(Math.random() * (dict.length()-1));
            len+=dict.charAt(index);
        }
        return len;
    }
}
