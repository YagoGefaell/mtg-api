package com.mtg.magicApi.card.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CardRecord(
    String id,
    String name,
    @JsonProperty("mana_cost") String manaCost,
    @JsonProperty("type_line") String typeLine,
    String rarity,
    @JsonProperty("image_uris") Map<String, String> imageUris
) {}