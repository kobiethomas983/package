CREATE DATABASE app;

\c app;

CREATE TABLE IF NOT EXISTS ps_package (
    id bigint,
    package_id TEXT UNIQUE NOT NULL,
    name TEXT,
    category TEXT,
    description TEXT,
    country TEXT,
    owner_id TEXT NOT NULL,
    created_at TIMESTAMP,
    modified_at TIMESTAMP,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS ps_dataset (
    id bigint,
    dataset_id TEXT UNIQUE NOT NULL,
    owner_id TEXT NOT NULL,
    description TEXT,
    name TEXT,
    package_id TEXT NOT NULL,
    created_at TIMESTAMP,
    modified_at TIMESTAMP,
    PRIMARY KEY(id),
    CONSTRAINT fk_package
        FOREIGN KEY(package_id)
            REFERENCES ps_package(package_id)
);