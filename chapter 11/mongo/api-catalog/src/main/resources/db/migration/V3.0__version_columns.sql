ALTER TABLE currency ADD COLUMN version BIGINT NOT NULL DEFAULT 0;

ALTER TABLE country ADD COLUMN version BIGINT NOT NULL DEFAULT 0;

ALTER TABLE state ADD COLUMN version BIGINT NOT NULL DEFAULT 0;

ALTER TABLE city ADD COLUMN version BIGINT NOT NULL DEFAULT 0;
