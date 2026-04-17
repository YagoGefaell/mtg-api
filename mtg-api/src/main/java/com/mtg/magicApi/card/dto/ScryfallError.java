package com.mtg.magicApi.card.dto;

public record ScryfallError(
    String status,
    String code,
    String details
) {}