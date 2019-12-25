package com.qcblog.common;

import java.util.Random;

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
       }
   }
   return str;
}
}
