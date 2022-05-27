package com.haise.wordlerest.controllers;

import com.haise.wordlerest.constants.StringConstants;
import com.haise.wordlerest.persist.UserWord;
import com.haise.wordlerest.services.IOWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/wordle", produces="application/json") //produces - формат возвращаемых данных
public class MainController {

    private IOWordService IOWordService;



    @GetMapping
    public Iterable<UserWord> getWords(){
        return IOWordService.findAll();
    }

    @PostMapping(consumes="application/json") // consumes формат передаваемых в запрос данных
    @ResponseStatus(HttpStatus.CREATED)
    public UserWord inputWord(@RequestBody UserWord word){
        word.setWord(word.getWord());
        return IOWordService.addWord(word, StringConstants.ANSWER.getStr());
    }



    @Autowired
    public void setInputWordService(IOWordService IOWordService) {
        this.IOWordService = IOWordService;
    }
}
