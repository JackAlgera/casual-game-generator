package com.jack.algera.app.configurations;

import com.jack.algera.core.api.GamesService;
import com.jack.algera.core.services.GamesServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfiguration {

  @Bean
  public GamesService wordService() {
    return new GamesServiceImpl();
  }
}
