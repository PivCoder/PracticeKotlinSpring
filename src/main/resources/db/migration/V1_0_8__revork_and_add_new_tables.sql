CREATE TABLE IF NOT EXISTS project.cities (
    id numeric PRIMARY KEY,
    name varchar(200) NOT NULL
);

CREATE SEQUENCE project.cities_id
START 1
INCREMENT 1
OWNED BY project.cities.id;

CREATE TABLE IF NOT EXISTS project.organizations (
    id numeric PRIMARY KEY ,
    name varchar(200) NOT NULL
);

CREATE SEQUENCE project.organizations_id
START 1
INCREMENT 1
OWNED BY project.organizations.id;

CREATE TABLE IF NOT EXISTS project.journals (
    id numeric PRIMARY KEY,
    name varchar(200) NOT NULL,
    publisher_id numeric
);

CREATE SEQUENCE project.journals_id
    START 1
    INCREMENT 1
    OWNED BY project.journals.id;


CREATE TABLE IF NOT EXISTS project.volumes (
    id numeric PRIMARY KEY,
    name varchar(200) NOT NULL,
    journal_id numeric
);

CREATE SEQUENCE project.volumes_id
    START 1
    INCREMENT 1
    OWNED BY project.volumes.id;
