package com.haise.wordlerest.services;

import com.haise.wordlerest.persist.Letter;
import com.haise.wordlerest.persist.LetterRepository;
import com.haise.wordlerest.persist.UserWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InputLetterService {
    private LetterRepository letterRepository;
    @Autowired
    public void setLetterRepository(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }

    public UserWord doColor(UserWord userWord){ // TODO: добавить класс логики, который будет обрабатывать символы

        for (int i = 0; i < userWord.getWord().length(); i++) {
            userWord.getWordOfLetters().add(new Letter(userWord.getWord().charAt(i), "green", userWord));
        }
        return userWord;
    }

    public List<Letter> addLetters(UserWord word){
        for (int i = 0; i < word.getWord().length(); i++) {
            word.getWordOfLetters().add(new Letter(word.getWord().charAt(i), "green", word));
        }
        return word.getWordOfLetters();
    }

}
