package com.jack.algera.core.entities;

import lombok.Builder;

@Builder
public record Word(String word, String definition) {}
