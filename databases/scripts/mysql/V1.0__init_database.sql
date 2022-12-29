CREATE TABLE IF NOT EXISTS currency
(
    id      bigint auto_increment PRIMARY KEY,
    code  varchar(4)           NOT NULL,
    symbol varchar(4) NOT NULL,
    description varchar(30) NOT NULL,
    decimal_places int not null,
    enabled    BOOLEAN  DEFAULT true NOT NULL
);


CREATE TABLE IF NOT EXISTS country
(
    id      bigint auto_increment PRIMARY KEY,
    code  varchar(4)           NOT NULL,
    name  varchar(30)           NOT NULL,
    locale  varchar(6)           NOT NULL,
    time_zone  varchar(10)           NOT NULL,
    currency_id bigint NOT NULL REFERENCES currency(id),
    enabled    BOOLEAN      DEFAULT true         NOT NULL
);

CREATE TABLE IF NOT EXISTS state
(
    id      bigint auto_increment PRIMARY KEY,
    code  varchar(6)           NOT NULL,
    name  varchar(30)           NOT NULL,
    enabled    BOOLEAN      DEFAULT true         NOT NULL,
    country_id bigint NOT NULL REFERENCES country(id)
);

CREATE TABLE IF NOT EXISTS city
(
    id      bigint auto_increment PRIMARY KEY,
    name  varchar(80)           NOT NULL,
    enabled    BOOLEAN      DEFAULT true         NOT NULL,
    state_id bigint NOT NULL REFERENCES state(id)
);

CREATE SEQUENCE hibernate_sequence START 1 INCREMENT 1;
