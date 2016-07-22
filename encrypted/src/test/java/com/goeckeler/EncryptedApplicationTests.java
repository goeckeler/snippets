package com.goeckeler;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EncryptedApplication.class)
public class EncryptedApplicationTests {
    @BeforeClass
    public static void setup() {
        System.setProperty("jasypt.encryptor.password", "junit");
    }

    @AfterClass
    public static void tearDown() {
        System.clearProperty("secret");
    }

    @Test
    public void contextLoads() {
    }
}
