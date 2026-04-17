package com.mtg.magicApi.card.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ScryfallList<T>(
    String object,
    @JsonProperty("total_cards") Integer totalCards,
    @JsonProperty("has_more") boolean hasMore,
    @JsonProperty("next_page") String nextPage,
    List<T> data
) {}
