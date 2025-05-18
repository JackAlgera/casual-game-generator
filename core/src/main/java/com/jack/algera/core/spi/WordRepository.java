package com.jack.algera.core.spi;

import java.util.List;
import com.jack.algera.core.entities.Word;

public interface WordRepository {

  List<Word> getWords(String count, String hash);
}
