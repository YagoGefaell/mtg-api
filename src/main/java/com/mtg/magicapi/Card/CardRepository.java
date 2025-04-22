package com.mtg.magicapi.Player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, String>{
    List<Card> findByNameContainingIgnoreCase(String name);
    List<Card> findByTypeLineContainingIgnoreCase(String typeLine);
    List<Card> findByRarity(String rarity);
    Optional<Card> findByName(String name);
    void deleteByName(String name);
}