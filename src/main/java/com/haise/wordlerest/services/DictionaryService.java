package com.haise.wordlerest.services;

import com.haise.wordlerest.persist.DictionaryRepository;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService {
    private final DictionaryRepository dictRepo;

    public DictionaryService(DictionaryRepository dictRepo) {
        this.dictRepo = dictRepo;
    }

    public boolean isWordContainsInDict(String word) {
        return dictRepo.findByWord(word) != null;
    }


}
