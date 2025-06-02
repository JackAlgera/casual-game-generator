package com.jack.algera.app.entities;

import java.util.List;
import java.util.Map;
import lombok.Builder;

@Builder
public record GameInstance(List<Word> words, Map<String, Integer> letterCypher) {
}
