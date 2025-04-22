package com.mtg.magicapi.Player;

import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/home")
public class CardViewController {

    @Autowired
    private CardService cardService;

    @GetMapping("/")
    public String showSearchPage(Model model) {

        List<Card> allCards = cardService.getCards();
        model.addAttribute("cards", allCards);
        return "index";
    }

    @GetMapping("/search")
    public String searchCards(@RequestParam String name, Model model) {
        List<Card> cards = cardService.getCardsFromName(name);
        model.addAttribute("cards", cards);
        model.addAttribute("query", name);
        return "index";
    }
}
