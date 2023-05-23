package com.drf.qa.util;

import com.drf.qa.base.TestBase;

import java.util.Random;

public class Utilities extends TestBase {

    public Utilities() {
        super();
    }

    public int retunARandomNumber (int size) {
        Random random = new Random();
        int day = random.nextInt(size);
        return day;
    }







}
