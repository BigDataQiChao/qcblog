package com.qcblog.common;

import java.util.Random;

/**
 * 随机码类
 * @author 赵起超
 * @date 2020.01.15
 */
public class RandomTest {
	public String verifyCode() {
	Random random = new Random();
    String str = "";
   for (int i = 0; i < 6; i++){
       int key = random.nextInt(3);
       switch (key){
           case 0:
               int code1 = random.nextInt(10);
               str += code1;
               break;
           case 1:
               char code2 = (char)(random.nextInt(26)+65);
               str += code2;
               break;
           case 2:
               char code3 = (char)(random.nextInt(26)+97);
               str += code3;
               break;
           default:
               break;
       }
   }
   return str;
}
}
