package com.haise.wordlerest.controllers;

import com.haise.wordlerest.constants.StringConstants;
import com.haise.wordlerest.persist.UserWord;
import com.haise.wordlerest.services.WordService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/wordle", produces = "application/json") //produces - формат возвращаемых данных
public class MainController {

    private final WordService wordService;

    public MainController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping
    public Iterable<UserWord> getWords() {
        return wordService.findAll();
    }

    @PostMapping(consumes = "application/json") // consumes формат передаваемых в запрос данных
    @ResponseStatus(HttpStatus.CREATED)
    public UserWord inputWord(@RequestBody UserWord word) {
        word.setWord(word.getWord());
        return wordService.addWord(word, StringConstants.ANSWER.getStr());
    }


}
