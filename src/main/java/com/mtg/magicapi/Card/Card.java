package com.mtg.magicapi.Player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cards")
public class Card {
    @Id
    @Column(name="id", unique=true, nullable=false)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="mana_value")
    private int manaValue;

    @Column(name="type_line")
    private String typeLine;

    @Column(name="rarity")
    private String rarity;

    @Column(name = "image_url")
    private String imageUrl;

    public Card() {}

    public Card(Integer id, String name, int manaValue, String typeLine, String rarity, String imageUrl) {
        this.id = id;
        this.name = name;
        this.manaValue = manaValue;
        this.typeLine = typeLine;
        this.rarity = rarity;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManaValue() {
        return manaValue;
    }

    public void setManaValue(int manaValue) {
        this.manaValue = manaValue;
    }

    public String getTypeLine() {
        return typeLine;
    }

    public void setTypeLine(String typeLine) {
        this.typeLine = typeLine;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
