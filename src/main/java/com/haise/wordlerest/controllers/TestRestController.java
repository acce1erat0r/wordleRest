package com.haise.wordlerest.controllers;

import com.haise.wordlerest.persist.UserWord;
import com.haise.wordlerest.services.IOLetterService;
import com.haise.wordlerest.services.IOWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/test", produces="application/json")
public class TestRestController {
    private IOWordService IOWordService;
    private IOLetterService IOLetterService;



//    @PatchMapping(path = "/{wordId}", consumes = "application/json")
//    public UserWord changeWord(@PathVariable("wordId") Long wordId,
//                               @RequestBody UserWord patch){
//        UserWord tmpWord = IOWordService.findById(wordId).orElse(new UserWord());
//        tmpWord.setWord(patch.getWord());
//        tmpWord.setWordOfLetters(IOLetterService.addLetters(patch));
//        return IOWordService.addWord(tmpWord);
//
//    }




    @Autowired
    public void setInputWordService(IOWordService IOWordService) {
        this.IOWordService = IOWordService;
    }
    @Autowired
    public void setInputLetterService(IOLetterService IOLetterService) {
        this.IOLetterService = IOLetterService;
    }
}
