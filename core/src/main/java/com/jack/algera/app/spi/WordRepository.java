package com.jack.algera.app.spi;

import com.jack.algera.app.entities.Word;
import java.util.List;

public interface WordRepository {

  List<Word> getWords(int count, String hash);
}
