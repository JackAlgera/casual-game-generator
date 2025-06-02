package com.jack.algera.app.clients;

import java.util.List;
import com.jack.algera.app.entities.Word;
import com.jack.algera.app.spi.WordRepository;

public class WordRepositoryImpl implements WordRepository {
  @Override
  public List<Word> getWords(int count, String hash) {
    return List.of(Word.builder().word("word").definition("definition").build());
  }
}
