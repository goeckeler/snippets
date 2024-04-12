package com.goeckeler;

import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EncryptedApplication.class)
public class EncryptedApplicationTests
{
  @BeforeAll
  public static void setup() {
    System.setProperty("jasypt.encryptor.password", "junit");
    System.out.println("Running test with jasypt password 'junit'.");
  }

  @AfterAll
  public static void tearDown() {
    System.clearProperty("secret");
  }

  @Test
  public void contextLoads() {
    System.out.println("Spring context was loaded.");
  }
}
