package com.haise.wordlerest.persist;

import com.haise.wordlerest.persist.UserWord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWordRepository extends JpaRepository<UserWord, Long> {
}