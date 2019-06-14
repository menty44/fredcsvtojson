package com.blaqueyard.service;

import java.util.UUID;

public class Test {
    public static void main(String[]ags){
        final String uuid = UUID.randomUUID().toString().replace("-", "");
        System.out.println("uuid = " + uuid);
    }
}
