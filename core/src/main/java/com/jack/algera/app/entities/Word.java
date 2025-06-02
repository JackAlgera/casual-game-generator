package com.jack.algera.app.entities;

import lombok.Builder;

@Builder
public record Word(String word, String definition) {
}
