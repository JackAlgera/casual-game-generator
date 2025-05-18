package com.jack.algera.core.entities;

import java.util.List;
import java.util.Map;

public record GameInstance(List<Word> words, Map<String, Integer> letterCypher) {
}
