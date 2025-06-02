package com.jack.algera.app.spi;

import java.util.List;
import com.jack.algera.app.entities.Word;

public interface WordRepository {

  List<Word> getWords(int count, String hash);
}
