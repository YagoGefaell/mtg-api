package com.mtg.magicapi.Card;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mtg")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("")
    public String home(Model model, @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 30);
        Page<Card> allCards = cardService.getCards(pageable);
        model.addAttribute("cards", allCards.getContent());
        model.addAttribute("totalPages", allCards.getTotalPages());
        model.addAttribute("currentPage", page);
        return "home";
    }

    @GetMapping("/search")
    public String searchCards(Model model, @RequestParam("name") String name, @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 30);
        Page<Card> cards = cardService.getCardsFromName(name, pageable);
        model.addAttribute("cards", cards.getContent());
        model.addAttribute("totalPages", cards.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("searchText", name);
        return "home";
    }
}
