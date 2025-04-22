package com.mtg.magicapi.Player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Card> getCards() {
        return cardRepository.findAll();
    }

    public List<Card> getCardsFromId(Integer id) {
        return cardRepository.findAll().stream()
                .filter(card -> card.getId() == id)
                .collect(Collectors.toList());
    }

    public List<Card> getCardsFromName(String searchText) {
        return cardRepository.findByNameContainingIgnoreCase(searchText);
    }

    public List<Card> getCardsFromType(String type) {
        return cardRepository.findByTypeLineContainingIgnoreCase(type);
    }

    public List<Card> getCardsFromRarity(String rarity) {
        return cardRepository.findByRarity(rarity);
    }

    public Card addCard(Card card) {
        cardRepository.save(card);
        return card;
    }

    public Card updateCard(Card updatedCard) {
        Optional<Card> existingCard = cardRepository.findByName(updatedCard.getName());

        if (existingCard.isPresent()) {
            Card cardToUpdate = existingCard.get();
            cardToUpdate.setManaValue(updatedCard.getManaValue());
            cardToUpdate.setName(updatedCard.getName());
            cardToUpdate.setTypeLine(updatedCard.getTypeLine());
            cardToUpdate.setRarity(updatedCard.getRarity());
            cardToUpdate.setImageUrl(updatedCard.getImageUrl());

            cardRepository.save(cardToUpdate);
            return cardToUpdate;
        }
        return null;
    }

    @Transactional
    public void deleteCard(String name) {
        cardRepository.deleteByName(name);
    }
}
