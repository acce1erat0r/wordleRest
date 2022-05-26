package com.haise.wordlerest.controllers;

import com.haise.wordlerest.persist.UserWord;
import com.haise.wordlerest.services.InputWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/wordle", produces="application/json") //produces - формат возвращаемых данных
public class MainController {

    private InputWordService inputWordService;



    @GetMapping
    public Iterable<UserWord> getWords(){
        return inputWordService.findAll();
    }

    //TODO: здесь сделать, чтобы сначала гетилось слово, а потом символы, и уже после шло сохранение слова
    @PostMapping(consumes="application/json") // consumes формат передаваемых в запрос данных
    @ResponseStatus(HttpStatus.CREATED)
    public UserWord inputWord(@RequestBody UserWord word){
        return inputWordService.addWordCascadeLetters(word);
    }



    @Autowired
    public void setInputWordService(InputWordService inputWordService) {
        this.inputWordService = inputWordService;
    }
}
