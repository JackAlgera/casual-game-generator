package com.jack.algera.app.configurations;

import com.jack.algera.clients.SudokuRepositoryImpl;
import com.jack.algera.clients.WordRepositoryImpl;
import com.jack.algera.core.api.GamesService;
import com.jack.algera.core.services.GamesServiceImpl;
import com.jack.algera.core.spi.SudokuRepository;
import com.jack.algera.core.spi.WordRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfiguration {

  @Bean
  public WordRepository wordRepository() {
    return new WordRepositoryImpl();
  }

  @Bean
  public SudokuRepository sudokuRepository() {
    return new SudokuRepositoryImpl();
  }

  @Bean
  public GamesService wordService(
      WordRepository wordRepository, SudokuRepository sudokuRepository) {
    return new GamesServiceImpl(wordRepository, sudokuRepository);
  }
}
