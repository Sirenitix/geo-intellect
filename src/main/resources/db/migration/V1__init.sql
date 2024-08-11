create table users (
                       id SERIAL NOT NULL ,
                       username TEXT NOT NULL,
                       password TEXT NOT NULL,
                       role TEXT NOT NULL,
                       enabled BOOLEAN,
                       PRIMARY KEY(id)
);
