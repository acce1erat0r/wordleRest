package com.haise.wordlerest.persist;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "letters")
@Getter
@Setter
@RequiredArgsConstructor
public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "value")
    Character value;

    @Column( name = "color")
    String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "word_id", nullable = false)
    @JsonBackReference
    private UserWord userWord;


    public Letter(Character value, String color, UserWord userWord) {
        this.value = value;
        this.color = color;
        this.userWord = userWord;
    }

}

