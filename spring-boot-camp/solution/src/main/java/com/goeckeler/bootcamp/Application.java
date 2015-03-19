package com.goeckeler.bootcamp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import com.goeckeler.bootcamp.service.boot.Catalog;

@SpringBootApplication
public class Application
{
  @Bean
  @Transactional
  CommandLineRunner init(final Catalog catalog) {
    return (event) -> {
      catalog.load();
    };
  }

  public static void main(final String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
