package com.haise.wordlerest.services;

import com.haise.wordlerest.persist.UserWord;
import com.haise.wordlerest.persist.UserWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IOWordService {
    private UserWordRepository userWordRepository;
    private IOLetterService IOLetterService;



    //TODO: Сделать два разных метода для сохранения и логики букв и слова отдельно

    /**
     *
     * @param word объект пользовательского слова
     * @return word объект пользовательского слова
     * Данный метод добавляет в объект userWord список Letters из которых он состоит, и сохраняет его в базе данных
     */
    public UserWord addWord(UserWord word, String answer){
        word.setWordOfLetters(IOLetterService.addLetters(word,answer));
        if(word.getWordOfLetters() != null) {
            return userWordRepository.save(word);
        }
        return new UserWord();
    }
    public Iterable<UserWord> findAll(){
        return userWordRepository.findAll();
    }




    //__________________________TESTS_____________________
    public Optional<UserWord> findById(Long id){
        return userWordRepository.findById(id);
    }




    @Autowired
    public void setInputLetterService(IOLetterService IOLetterService) {
        this.IOLetterService = IOLetterService;
    }

    @Autowired
    public void setUserWordRepository(UserWordRepository userWordRepository) {
        this.userWordRepository = userWordRepository;
    }

}
