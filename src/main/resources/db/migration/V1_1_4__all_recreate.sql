create schema IF NOT EXISTS project;

DROP TABLE IF EXISTS project.publisher CASCADE;

create table IF NOT EXISTS project.publisher
(
    id numeric not null
        constraint publishers_pkey
            primary key,
    name varchar(300) not null,
    issn varchar(9) not null,
    created_on date,
    updated_on date
);

create index IF NOT EXISTS issn_index
    on project.publisher (issn);

DROP TABLE IF EXISTS project.journal CASCADE;

create table IF NOT EXISTS project.journal
(
    id numeric not null
        constraint journals_pkey
            primary key,
    name varchar(200) not null,
    created_on date,
    updated_on date,
    publisher_id numeric
        constraint journals_publisher_id_fkey
            references project.publisher
);

DROP TABLE IF EXISTS project.volume CASCADE;

create table IF NOT EXISTS project.volume
(
    id numeric not null
        constraint volumes_pkey
            primary key,
    name varchar(200) not null,
    created_on date,
    updated_on date,
    journal_id numeric
        constraint volumes_journal_id_fkey
            references project.journal
);

DROP TABLE IF EXISTS project.article CASCADE;

create table IF NOT EXISTS project.article
(
    id numeric not null
        constraint articles_pkey
            primary key,
    name varchar(200) not null,
    count_pages integer,
    count_visits integer,
    picture_ref varchar(200),
    category varchar(100) not null,
    state varchar(50) not null,
    created_on date,
    updated_on date,
    volume_id numeric
        constraint articles_volume_id_fkey
            references project.volume
);

create index IF NOT EXISTS article_name_index
    on project.article (name);

create index IF NOT EXISTS article_category_index
    on project.article (category);

DROP TABLE IF EXISTS project.city CASCADE;

create table IF NOT EXISTS project.city
(
    id numeric not null
        constraint city_pkey
            primary key,
    name varchar(200) not null,
    created_on date,
    updated_on date
);

DROP TABLE IF EXISTS project.organization CASCADE;

create table IF NOT EXISTS project.organization
(
    id numeric not null
        constraint organizations_pkey
            primary key,
    name varchar(200) not null,
    created_on date,
    updated_on date
);

DROP TABLE IF EXISTS project.author CASCADE;

create table IF NOT EXISTS project.author
(
    id numeric not null
        constraint users_pkey
            primary key,
    name varchar(150) not null,
    surname varchar(150) not null,
    patronymic varchar(150),
    rating real,
    picture_ref varchar(200),
    user_type varchar(30) not null,
    created_on date,
    updated_on date,
    organization_id numeric
        constraint users_organization_id_fkey
            references project.organization,
    city_id numeric
        constraint users_city_id_fkey
            references project.city
);

DROP TABLE IF EXISTS project.article_author CASCADE;

create table IF NOT EXISTS project.article_author
(
    article_id numeric
        constraint articles_users_articles_id_fkey
            references project.article,
    author_id numeric
        constraint articles_users_users_id_fkey
            references project.author,
    id numeric not null
        constraint articles_users_pk
            primary key
);

create sequence IF NOT EXISTS project.organization_seq;

alter sequence project.organization_seq owned by project.organization.id;

create sequence IF NOT EXISTS project.author_seq;

alter sequence project.author_seq owned by project.author.id;

create sequence IF NOT EXISTS project.city_seq;

alter sequence project.city_seq owned by project.city.id;

create sequence IF NOT EXISTS project.article_seq;

alter sequence project.article_seq owned by project.article.id;

create sequence IF NOT EXISTS project.article_author_seq;

alter sequence project.article_author_seq owned by project.article_author.id;

create sequence IF NOT EXISTS project.volume_seq;

alter sequence project.volume_seq owned by project.volume.id;

create sequence IF NOT EXISTS project.journal_seq;

alter sequence project.journal_seq owned by project.journal.id;

create sequence IF NOT EXISTS project.publisher_seq;

alter sequence project.publisher_seq owned by project.publisher.id;

INSERT INTO project.city (id, name) VALUES (1, 'Samara');
INSERT INTO project.city (id, name) VALUES (2, 'Rostov');
INSERT INTO project.city (id, name) VALUES (3, 'Moscow');

INSERT INTO project.organization (id, name) VALUES (1, 'Organization 1');
INSERT INTO project.organization (id, name) VALUES (2, 'Organization 2');
INSERT INTO project.organization (id, name) VALUES (3, 'Organization 3');

INSERT INTO project.publisher (id, name, issn) VALUES (1, 'Test_publisher_1', '111-111');
INSERT INTO project.publisher (id, name, issn) VALUES (2, 'Test_publisher_2', '222-111');
INSERT INTO project.publisher (id, name, issn) VALUES (3, 'Test_publisher_3', '333-111');
INSERT INTO project.publisher (id, name, issn) VALUES (4, 'Test_publisher_4', '444-111');

INSERT INTO project.journal (id, name, publisher_id) VALUES (1, 'Journal 1', 1);
INSERT INTO project.journal (id, name, publisher_id) VALUES (2, 'Journal 2', 1);
INSERT INTO project.journal (id, name, publisher_id) VALUES (3, 'Journal 3', 4);

INSERT INTO project.volume (id, name, journal_id) VALUES (1, 'Volume 1', 2);
INSERT INTO project.volume (id, name, journal_id) VALUES (2, 'Volume 2', 3);
INSERT INTO project.volume (id, name, journal_id) VALUES (3, 'Volume 3', 1);

INSERT INTO project.article (id, name, count_pages, count_visits, picture_ref, category, state, volume_id) VALUES (1, 'Test_article_1', 0, 0, '', 'BIOLOGY', 'REJECTED', 1);
INSERT INTO project.article (id, name, count_pages, count_visits, picture_ref, category, state, volume_id) VALUES (2, 'Test_article_2', 0, 0, '', 'BIOLOGY', 'REJECTED', 1);
INSERT INTO project.article (id, name, count_pages, count_visits, picture_ref, category, state, volume_id) VALUES (3, 'Test_article_3', 0, 0, '', 'BIOLOGY', 'REJECTED', 2);
INSERT INTO project.article (id, name, count_pages, count_visits, picture_ref, category, state, volume_id) VALUES (4, 'Test_article_4', 0, 0, '', 'BIOLOGY', 'REJECTED', 3);

INSERT INTO project.author (id, name, surname, patronymic, rating, picture_ref, user_type, organization_id, city_id) VALUES (1, 'Test_name_1', 'Test_Surname_1', '', 0, '', 'USER', 2, 1);
INSERT INTO project.author (id, name, surname, patronymic, rating, picture_ref, user_type, organization_id, city_id) VALUES (2, 'Test_name_2', 'Test_Surname_2', '', 0, '', 'USER', 2, 3);
INSERT INTO project.author (id, name, surname, patronymic, rating, picture_ref, user_type, organization_id, city_id) VALUES (3, 'Test_name_3', 'Test_Surname_3', '', 0, '', 'USER', 2, 2);
INSERT INTO project.author (id, name, surname, patronymic, rating, picture_ref, user_type, organization_id, city_id) VALUES (4, 'Test_name_4', 'Test_Surname_4', '', 0, '', 'USER', 1, 1);

INSERT INTO project.article_author (article_id, author_id, id) VALUES (1, 1, 1);
INSERT INTO project.article_author (article_id, author_id, id) VALUES (2, 2, 2);
INSERT INTO project.article_author (article_id, author_id, id) VALUES (2, 3, 3);
INSERT INTO project.article_author (article_id, author_id, id) VALUES (3, 4, 4);








