package com.gd.test;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2020/1/30.
 */
public class Test {
    @Autowired
    private static TestSpring testSpring;
    public static void main(String[] args) {
        testSpring.testByImport();
    }
}

