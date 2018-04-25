package com.itacademy.presentation;

import junit.framework.Assert;


public class Test {

    @org.junit.Test
    public void test(){
        int a = 2 + 2;

        //сравнивание значений
        Assert.assertEquals(4, a);
    }
    public int plus(int a, int b){
        return a + b;
    }
}
