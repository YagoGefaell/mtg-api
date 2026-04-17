package com.mtg.magicApi.card.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    private String id;

    private String name;

    @JsonProperty("mana_cost")
    private String manaCost;

    @JsonProperty("type_line")
    private String typeLine;

    private String rarity;

    @JsonProperty("image_uris")
    private Map<String, String> imageUris;

    public String getImageUrl() {
        if (imageUris != null && imageUris.containsKey("normal")) {
            return imageUris.get("normal");
        }
        return null;
    }
}
