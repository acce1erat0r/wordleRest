package com.haise.wordlerest.services;

import com.haise.wordlerest.constants.Colors;
import com.haise.wordlerest.persist.Letter;
import com.haise.wordlerest.persist.LetterRepository;
import com.haise.wordlerest.persist.UserWord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class IOLetterService {
    private LetterRepository letterRepository;
    private DictionaryService dictionaryService;
    private final ColorLogic colorLogic = new ColorLogic();



    public List<Letter> addLetters(UserWord word, String answer) {
        word.setWordOfLetters(colorLogic.doColor(word, answer));
        return word.getWordOfLetters();

    }

    /**
     * Inner класс отвечающий за логику выдачи цветов для символов
     */
    private class ColorLogic {

        private  List<Letter> letters;

        private ColorLogic() {
        }

        private List<Letter> doColor(UserWord word, String answer) { //TODO: переименовать метод, вынести answer в другое место
            letters = new ArrayList<>();

            if (!IOLetterService.this.dictionaryService.isWordContainsInDict(word.getWord())){
                log.info("такого слова нет в словаре");
                return null; //TODO: заглушка, нужно будет обработать
            }
            if(word.getWord().equals(answer)){
                log.info("вы выиграли");
                return null; //TODO: заглушка, нужно будет обработать
            }
            paintLetter(word, answer);
            return letters;
        }
        private void paintLetter(UserWord word, String answer){
            for (int i = 0; i < 5; i++) {
                if (word.getWord().charAt(i) == answer.charAt(i)) {
                    letters.add(new Letter(word.getWord().charAt(i), Colors.GREEN.getColor(), word));
                }
                if(!answer.contains(String.valueOf(word.getWord().charAt(i)))){
                    letters.add(new Letter(word.getWord().charAt(i), Colors.RED.getColor(), word));
                }
                if(word.getWord().charAt(i) != answer.charAt(i) &
                        answer.contains(String.valueOf(word.getWord().charAt(i)))){
                    letters.add(new Letter(word.getWord().charAt(i), Colors.YELLOW.getColor(), word));
                }
            }
        }


    }




    @Autowired
    public void setLetterRepository(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }

    @Autowired
    public void setDictionaryService(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

}
