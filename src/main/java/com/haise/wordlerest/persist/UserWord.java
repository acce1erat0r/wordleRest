package com.haise.wordlerest.persist;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_words")
@Getter
@Setter
@RequiredArgsConstructor
public class UserWord implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "word", nullable = false, length = 5)
    private String word;


    @OneToMany(mappedBy = "userWord", fetch = FetchType.LAZY, cascade = CascadeType.ALL) //TODO:FIX later cascadeType
    @JsonManagedReference
    private List<Letter> wordOfLetters = new ArrayList<>();

    public UserWord(String word) {
        this.word = word;
    }


}