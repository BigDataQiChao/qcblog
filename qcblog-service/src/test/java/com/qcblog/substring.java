package com.qcblog;

import org.junit.Test;

public class substring {
    @Test
    public void sub(){
        String sub = "UM_distinctid=170761e160867-067af878082438-313f68-100200-170761e16092ee; CNZZDATA1277354711=852601216-1582528617-null%7C1582533531; CNZZDATA1277627309=1916326685-1582527085-null%7C1582530873; JSESSIONID=EC61BBE2E61D4D645A64E2DA4DBD9F1D";
        System.out.println(sub.substring(192));
    }
}
