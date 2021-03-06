create table authors (
        id int unsigned primary key auto_increment,
        name varchar(100) not null,
        surname varchar(100) not null
);

create table books (
        id int unsigned primary key auto_increment,
        title varchar(100) not null,
        borrowed BIT default 0,
        author_id int NOT NULL
);

ALTER TABLE books
    ADD CONSTRAINT books_author_id
    FOREIGN KEY (author_id) REFERENCES authors(id)


