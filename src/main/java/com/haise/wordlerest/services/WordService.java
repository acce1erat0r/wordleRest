package com.haise.wordlerest.services;

import com.haise.wordlerest.persist.UserWord;
import com.haise.wordlerest.persist.UserWordRepository;
import org.springframework.stereotype.Service;

@Service
public class WordService {
    private final UserWordRepository userWordRepository;
    private final LetterService letterService;

    public WordService(UserWordRepository userWordRepository, LetterService letterService) {
        this.userWordRepository = userWordRepository;
        this.letterService = letterService;
    }

    /**
     * @param word объект пользовательского слова
     * @return word объект пользовательского слова
     * Данный метод добавляет в объект userWord список Letters из которых он состоит, и сохраняет его в базе данных
     */
    public UserWord addWord(UserWord word, String answer) {
        word.setWordOfLetters(letterService.addLetters(word, answer));
        if (word.getWordOfLetters() != null) {
            return userWordRepository.save(word);
        }
        return new UserWord();
    }

    public Iterable<UserWord> findAll() {
        return userWordRepository.findAll();
    }


}
