CREATE DATABASE app;

\c app;

CREATE TABLE IF NOT EXISTS ps_package (
    id bigint,
    package_id TEXT UNIQUE NOT NULL,
    name TEXT,
    category TEXT,
    description TEXT,
    country TEXT,
    company_id TEXT NOT NULL,
    created_at TIMESTAMP,
    modified_at TIMESTAMP,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS ps_dataset (
    id bigint,
    dataset_id TEXT UNIQUE NOT NULL,
    company_id TEXT NOT NULL,
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

CREATE TABLE IF NOT EXISTS ps_source (
    id bigint,
    source_id TEXT UNIQUE NOT NULL,
    dataset_id TEXT NOT NULL,
    file_name TEXT NOT NULL,
    file_size bigint,
    created_at TIMESTAMP,
    modified_at TIMESTAMP,
    PRIMARY KEY(id),
    CONSTRAINT fk_datasets
        FOREIGN KEY(dataset_id)
            REFERENCES ps_dataset(dataset_id)
);
CREATE SEQUENCE hibernate_sequence START 1;

INSERT INTO ps_package(id, package_id, name, category, description, country, company_id, created_at, modified_at)
VALUES(1, 'Pk122A', 'Clyde-Inventory', 'Financial', 'Data on Clyde inventory', 'USA', 'Co1234', NOW(), NOW());

INSERT INTO ps_package(id, package_id, name, category, description, country, company_id, created_at, modified_at)
VALUES(2, 'PkLL10', 'Digit-Analytics', 'Financial', 'Data on Digit analytics', 'USA', 'Co5678', NOW(), NOW());

INSERT INTO ps_package(id, package_id, name, category, description, country, company_id, created_at, modified_at)
VALUES(3, 'PkF123', 'Flywire-Users', 'Financial', 'Data on Flywire users', 'USA', 'Co1578', NOW(), NOW());

INSERT INTO ps_package(id, package_id, name, category, description, country, company_id, created_at, modified_at)
VALUES(4, 'PkZO02', 'JPMorgan-CreditScores', 'Financial', 'Data on Credit Scores', 'USA', 'Co4322', NOW(), NOW());

INSERT INTO ps_package(id, package_id, name, category, description, country, company_id, created_at, modified_at)
VALUES(5, 'PkLA78', 'Robinhood-Investments', 'Financial', 'Data on user investments', 'USA', 'Co6619', NOW(), NOW());

INSERT INTO ps_dataset(id, dataset_id, company_id, description, name, package_id, created_at, modified_at)
VALUES(1, 'DsAA12', 'Co1234', 'Dataset for Clyde inventory', 'Clyde-Dataset','Pk122A', NOW(), NOW());

INSERT INTO ps_dataset(id, dataset_id, company_id, description, name, package_id, created_at, modified_at)
VALUES(2, 'DsOP99', 'Co5678', 'Dataset for Digits Analytics', 'Digit-Dataset','PkLL10', NOW(), NOW());

INSERT INTO ps_dataset(id, dataset_id, company_id, description, name, package_id, created_at, modified_at)
VALUES(3, 'DsQ087', 'Co1578', 'Dataset for Flywire Users', 'Flywire-Dataset','PkF123', NOW(), NOW());

INSERT INTO ps_dataset(id, dataset_id, company_id, description, name, package_id, created_at, modified_at)
VALUES(4, 'DsMP45', 'Co4322', 'Dataset for JPMorgans Credit Scores', 'JPMorgan-Dataset','PkZO02', NOW(), NOW());

INSERT INTO ps_dataset(id, dataset_id, company_id, description, name, package_id, created_at, modified_at)
VALUES(5, 'Ds0992', 'Co6619', 'Dataset for Robinhood user investment', 'Robinhood-Dataset','PkLA78', NOW(), NOW());
