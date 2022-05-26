package com.haise.wordlerest.services;

import com.haise.wordlerest.persist.UserWord;
import com.haise.wordlerest.persist.UserWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InputWordService {
    private UserWordRepository userWordRepository;
    private InputLetterService inputLetterService;

    @Autowired
    public void setInputLetterService(InputLetterService inputLetterService) {
        this.inputLetterService = inputLetterService;
    }

    @Autowired
    public void setUserWordRepository(UserWordRepository userWordRepository) {
        this.userWordRepository = userWordRepository;
    }

    //TODO: Сделать два разных метода для сохранения и логики букв и слова отдельно
    public UserWord addWordCascadeLetters(UserWord word){
        return userWordRepository.save(inputLetterService.doColor(word));
    }
    public UserWord addWordWithoutLetters(UserWord word){
        return userWordRepository.save(word);
    }
    public Iterable<UserWord> findAll(){
        return userWordRepository.findAll();
    }

    //__________________________TESTS_____________________
    public Optional<UserWord> findById(Long id){
        return userWordRepository.findById(id);
    }



}
