package com.mtg.magicApi.card.controller;

import org.springframework.web.bind.annotation.*;
import com.mtg.magicApi.card.dto.CardRecord;
import com.mtg.magicApi.card.dto.ScryfallList;
import com.mtg.magicApi.card.service.MtgService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/mtg")
@Tag(name = "Magic Cards", description = "Endpoints para consultar la base de datos de Magic: The Gathering")
public class CardController {

    private final MtgService mtgService;

    public CardController(MtgService mtgService) {
        this.mtgService = mtgService;
    }

    @Operation(summary = "Buscar cartas por nombre", description = "Obtiene una lista de cartas que coinciden total o parcialmente con el nombre proporcionado.")
    @GetMapping("/cards")
    public Mono<ScryfallList<CardRecord>> getCardsByName(
            @Parameter(description = "Nombre de la carta (ej: 'Black Lotus')") @RequestParam String name) {
        return this.mtgService.getCardsByName(name);
    }

    @Operation(summary = "Obtener carta por ID", description = "Busca una única carta utilizando su identificador único de Scryfall.")
    @GetMapping("/cards/{id}")
    public Mono<CardRecord> getCardById(
            @Parameter(description = "ID único de la carta") @PathVariable String id) {
        return this.mtgService.getCardById(id);
    }

    @Operation(summary = "Filtrar cartas", description = "Búsqueda avanzada filtrando por colores, tipo de carta y página.")
    @GetMapping("/cards/filter")
    public Mono<ScryfallList<CardRecord>> getCardsByFilters(
            @Parameter(description = "Colores (ej: 'W', 'U', 'B', 'R', 'G')") @RequestParam String colors,
            @Parameter(description = "Tipo de carta (ej: 'Creature', 'Instant')") @RequestParam String type,
            @Parameter(description = "Número de página para paginación") @RequestParam(defaultValue = "1") int page) {
        return this.mtgService.getCardsByFilters(colors, type, page);
    }

    @Operation(summary = "Listar colecciones (Sets)", description = "Obtiene un listado de todas las expansiones y sets de Magic.")
    @GetMapping("/sets")
    public Mono<String> getAllSets() {
        return this.mtgService.getAllSets();
    }

    @Operation(summary = "Cartas de una colección", description = "Lista todas las cartas que pertenecen a un set específico mediante su código.")
    @GetMapping("/cards/set/{setCode}")
    public Mono<ScryfallList<CardRecord>> getCardsBySet(
            @Parameter(description = "Código del set (ej: 'zen', 'war')") @PathVariable String setCode) {
        return this.mtgService.getCardsBySet(setCode);
    }
}
