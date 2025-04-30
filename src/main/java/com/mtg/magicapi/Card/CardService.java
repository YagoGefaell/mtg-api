package com.mtg.magicapi.Card;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CardService {
    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Page<Card> getCards(Pageable pageable) {
        return cardRepository.findAll(pageable);
    }

    public Page<Card> getCardsFromName(String searchText, Pageable pageable) {
        return cardRepository.findByNameContainingIgnoreCase(searchText, pageable);
    }

    public Page<Card> getCardsFromType(String type, Pageable pageable) {
        return cardRepository.findByTypeLineContainingIgnoreCase(type, pageable);
    }

    public Page<Card> getCardsFromRarity(String rarity, Pageable pageable) {
        return cardRepository.findByRarity(rarity, pageable);
    }
}
