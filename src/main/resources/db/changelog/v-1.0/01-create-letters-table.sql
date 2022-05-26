create table letters
(
    id      bigserial not null,
    color   varchar(255),
    value   char(1),
    word_id int8      not null,
    primary key (id)
);





