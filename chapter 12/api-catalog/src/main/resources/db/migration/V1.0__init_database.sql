CREATE TABLE IF NOT EXISTS currency
(
    id      bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    code  varchar(4)           NOT NULL,
    symbol varchar(4) NOT NULL,
    description varchar(30) NOT NULL,
    decimal_places int not null,
    enabled    BOOLEAN  DEFAULT true NOT NULL
);


CREATE TABLE IF NOT EXISTS country
(
    id      bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    code  varchar(4)           NOT NULL,
    name  varchar(30)           NOT NULL,
    locale  varchar(6)           NOT NULL,
    time_zone  varchar(10)           NOT NULL,
    currency_id bigint NOT NULL REFERENCES currency(id),
    enabled    BOOLEAN      DEFAULT true         NOT NULL
);

CREATE TABLE IF NOT EXISTS state
(
    id      bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    code  varchar(6)           NOT NULL,
    name  varchar(30)           NOT NULL,
    enabled    BOOLEAN      DEFAULT true         NOT NULL,
    country_id bigint NOT NULL REFERENCES country(id)
);

CREATE TABLE IF NOT EXISTS city
(
    id      bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name  varchar(80)           NOT NULL,
    enabled    BOOLEAN      DEFAULT true         NOT NULL,
    state_id bigint NOT NULL REFERENCES state(id)
);

CREATE INDEX idx_currency_code ON currency(code);
CREATE INDEX idx_country_code ON country(code);
CREATE INDEX idx_state_code ON state(code);
CREATE INDEX idx_city_name ON city(name);

CREATE SEQUENCE hibernate_sequence;