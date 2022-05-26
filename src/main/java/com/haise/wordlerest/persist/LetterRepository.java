package com.haise.wordlerest.persist;

import com.haise.wordlerest.persist.Letter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LetterRepository extends JpaRepository<Letter, Long> {
}