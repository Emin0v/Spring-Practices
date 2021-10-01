CREATE SEQUENCE seq_user start 1 increment 1;

CREATE TABLE user
(
    id        bigint       NOT NULL default nextval('seq_user'),
    name  varchar(100) NOT NULL,
    username  varchar(100) NOT NULL,
    password varchar(50)  NOT NULL,
    PRIMARY KEY (id)
);