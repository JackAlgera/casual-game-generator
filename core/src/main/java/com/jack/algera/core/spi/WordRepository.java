package com.jack.algera.core.spi;

import com.jack.algera.core.entities.Word;
import java.util.List;

public interface WordRepository {

  List<Word> getWords(int count, String hash);
}
