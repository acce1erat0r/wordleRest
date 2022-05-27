package com.haise.wordlerest.services;

import com.haise.wordlerest.persist.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService {
    private DictionaryRepository dictRepo;

    public boolean isWordContainsInDict(String word){
        return dictRepo.findByWord(word) != null;
    }






    @Autowired
    public void setDictRepo(DictionaryRepository dictRepo) {
        this.dictRepo = dictRepo;
    }
}
