package com.mtg.magicapi.Card;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, String>{
    Page<Card> findByNameContainingIgnoreCase(String name , Pageable pageable);
    Page<Card> findByTypeLineContainingIgnoreCase(String typeLine, Pageable pageable);
    Page<Card> findByRarity(String rarity, Pageable pageable);
    Optional<Card> findByName(String name);
}