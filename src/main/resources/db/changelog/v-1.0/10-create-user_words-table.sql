create table user_words
(
    id   bigserial  not null,
    word varchar(5) not null,
    primary key (id)
);


alter table letters
    add constraint FKob9tbfu08rxnbinlvmdmbgqcv
        foreign key (word_id) references user_words;