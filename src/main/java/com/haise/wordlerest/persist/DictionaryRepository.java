package com.haise.wordlerest.persist;

import org.springframework.data.repository.CrudRepository;

public interface DictionaryRepository extends CrudRepository<WordFromDictionary, Long> {
    WordFromDictionary findByWord(String word);

}