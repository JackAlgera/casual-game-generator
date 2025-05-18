package com.jack.algera.core.clients;

import java.util.List;
import com.jack.algera.core.entities.Word;

public class WordRepository implements com.jack.algera.core.spi.WordRepository {
  @Override
  public List<Word> getWords(String count, String hash) {
    return List.of();
  }
}
