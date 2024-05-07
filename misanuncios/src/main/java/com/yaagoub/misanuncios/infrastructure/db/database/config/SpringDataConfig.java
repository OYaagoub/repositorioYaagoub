package com.yaagoub.misanuncios.infrastructure.db.database.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.yaagoub.misanuncios.infrastructure.db.database.repository")
public class SpringDataConfig {

}
