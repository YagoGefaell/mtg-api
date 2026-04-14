package com.mtg.magicApi.card.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.mtg.magicApi.card.dto.CardRecord;
import com.mtg.magicApi.card.dto.ScryfallList;

import reactor.core.publisher.Mono;

@Service
public class MtgService {

    private static final ParameterizedTypeReference<ScryfallList<CardRecord>> CARD_LIST_TYPE =
            new ParameterizedTypeReference<>() {};

    private final WebClient webClient;

    public MtgService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<ScryfallList<CardRecord>> getCardsByName(String name) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/cards/search")
                        .queryParam("q", name) // Scryfall usa 'q' para búsquedas
                        .build())
                .retrieve()
                .bodyToMono(CARD_LIST_TYPE)
                .onErrorResume(e -> Mono.empty()); // Si no hay resultados, devuelve vacío en lugar de 500
    }

    public Mono<CardRecord> getCardById(String id) {
        return this.webClient.get()
                .uri("/cards/{id}", id)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        response -> Mono.error(new RuntimeException("Carta con ID " + id + " no encontrada")))
                .bodyToMono(CardRecord.class);
    }

    public Mono<ScryfallList<CardRecord>> getCardsByFilters(String colors, String type, int page) {
        StringBuilder query = new StringBuilder();
        if (colors != null && !colors.isEmpty()) query.append("c:").append(colors).append(" ");
        if (type != null && !type.isEmpty()) query.append("t:").append(type);

        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/cards/search")
                        .queryParam("q", query.toString().trim())
                        .queryParam("page", page)
                        .build())
                .retrieve()
                .bodyToMono(CARD_LIST_TYPE);
    }

    public Mono<String> getAllSets() {
        return this.webClient.get()
                .uri("/sets")
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<ScryfallList<CardRecord>> getCardsBySet(String setCode) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/cards/search")
                        .queryParam("q", "set:" + setCode)
                        .build())
                .retrieve()
                .bodyToMono(CARD_LIST_TYPE);
    }
}