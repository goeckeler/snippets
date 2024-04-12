package com.goeckeler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class EncryptedApplication implements CommandLineRunner
{
  private static final Logger LOG = LoggerFactory.getLogger(EncryptedApplication.class);

  @Value("${label}")
  private String label;

  @Value("${secret:none}")
  private String secret;

  public static void main(String[] args) {
    SpringApplication.run(EncryptedApplication.class, args);
  }

  @Override
  public void run(String... args)
    throws Exception
  {
    LOG.info("\n\n-----------------------------------------------------------------------------------\n"
             + "Application is running, {} {} "
             + "\n-----------------------------------------------------------------------------------\n",
        label, secret);
  }
}
