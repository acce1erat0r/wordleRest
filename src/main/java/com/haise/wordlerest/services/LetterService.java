package com.haise.wordlerest.services;

import com.haise.wordlerest.constants.Colors;
import com.haise.wordlerest.persist.Letter;
import com.haise.wordlerest.persist.UserWord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class LetterService {
    private final DictionaryService dictionaryService;

    public LetterService(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    private final ColorLogic colorLogic = new ColorLogic();


    public List<Letter> addLetters(UserWord word, String answer) {
        word.setWordOfLetters(colorLogic.doColor(word, answer));
        return word.getWordOfLetters();

    }

    /**
     * Inner класс отвечающий за логику выдачи цветов для символов
     */
    private class ColorLogic {

        private ColorLogic() {
        }

        private List<Letter> doColor(UserWord word, String answer) {
            List<Letter> letters = new ArrayList<>();

            if (!dictionaryService.isWordContainsInDict(word.getWord())) {
                log.info("такого слова нет в словаре");
                return null;
            }
            if (word.getWord().equals(answer)) {
                log.info("вы выиграли");
                return null;
            }
            paintLetter(word, answer, letters);
            return letters;
        }

        private void paintLetter(UserWord word, String answer, List<Letter> letters) {
            for (int i = 0; i < 5; i++) {
                if (word.getWord().charAt(i) == answer.charAt(i)) {
                    letters.add(new Letter(word.getWord().charAt(i), Colors.GREEN.getColor(), word));
                }
                if (!answer.contains(String.valueOf(word.getWord().charAt(i)))) {
                    letters.add(new Letter(word.getWord().charAt(i), Colors.RED.getColor(), word));
                }
                if (word.getWord().charAt(i) != answer.charAt(i) &
                        answer.contains(String.valueOf(word.getWord().charAt(i)))) {
                    letters.add(new Letter(word.getWord().charAt(i), Colors.YELLOW.getColor(), word));
                }
            }
        }


    }


}
