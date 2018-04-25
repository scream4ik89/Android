package com.itacademy.presentation;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class Test {

    @org.junit.Test
        public void test(){

            Context appContext = InstrumentationRegistry.getTargetContext();

            assertEquals("com.it_academy", appContext.getPackageName());
        }
}
