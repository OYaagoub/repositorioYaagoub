package com.yaagoub.misanuncios.infrastructure.config.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.yaagoub.misanuncios.infrastructure")
@EntityScan(basePackages = "com.yaagoub.misanuncios.infrastructure.db.database.model")
public class MisanunciosApplication {

  public static void main(String[] args) {
    SpringApplication.run(MisanunciosApplication.class);
  }
}
