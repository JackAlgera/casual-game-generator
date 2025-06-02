package com.jack.algera.app.configurations;

import com.jack.algera.app.api.GamesService;
import com.jack.algera.app.clients.SudokuRepositoryImpl;
import com.jack.algera.app.clients.WordRepositoryImpl;
import com.jack.algera.app.services.GamesServiceImpl;
import com.jack.algera.app.spi.SudokuRepository;
import com.jack.algera.app.spi.WordRepository;
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
  public GamesService wordService(WordRepository wordRepository, SudokuRepository sudokuRepository) {
    return new GamesServiceImpl(wordRepository, sudokuRepository);
  }
}
