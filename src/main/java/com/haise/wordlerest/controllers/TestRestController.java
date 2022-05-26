package com.haise.wordlerest.controllers;

import com.haise.wordlerest.persist.UserWord;
import com.haise.wordlerest.services.InputLetterService;
import com.haise.wordlerest.services.InputWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/test", produces="application/json")
public class TestRestController {
    private InputWordService inputWordService;
    private InputLetterService inputLetterService;



    @PatchMapping(path = "/{wordId}", consumes = "application/json")
    public UserWord changeWord(@PathVariable("wordId") Long wordId,
                               @RequestBody UserWord patch){
        UserWord tmpWord = inputWordService.findById(wordId).orElse(new UserWord());
        tmpWord.setWord(patch.getWord());
        tmpWord.setWordOfLetters(inputLetterService.addLetters(patch));
        return inputWordService.addWordWithoutLetters(tmpWord);

    }




    @Autowired
    public void setInputWordService(InputWordService inputWordService) {
        this.inputWordService = inputWordService;
    }
    @Autowired
    public void setInputLetterService(InputLetterService inputLetterService) {
        this.inputLetterService = inputLetterService;
    }
}
