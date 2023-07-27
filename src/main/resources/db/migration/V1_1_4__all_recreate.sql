create schema IF NOT EXISTS project;

create table IF NOT EXISTS project.publisher
(
    id numeric not null
        constraint publishers_pkey
            primary key,
    name varchar(300) not null,
    issn varchar(9) not null
);

create index IF NOT EXISTS issn_index
    on project.publisher (issn);

create table IF NOT EXISTS project.journal
(
    id numeric not null
        constraint journals_pkey
            primary key,
    name varchar(200) not null,
    publisher_id numeric
        constraint journals_publisher_id_fkey
            references project.publisher
);

create table IF NOT EXISTS project.volume
(
    id numeric not null
        constraint volumes_pkey
            primary key,
    name varchar(200) not null,
    journal_id numeric
        constraint volumes_journal_id_fkey
            references project.journal
);

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
    volume_id numeric
        constraint articles_volume_id_fkey
            references project.volume
);

create index IF NOT EXISTS article_name_index
    on project.article (name);

create index IF NOT EXISTS article_category_index
    on project.article (category);

create table IF NOT EXISTS project.city
(
    id numeric not null
        constraint city_pkey
            primary key,
    name varchar(200) not null
);

create table IF NOT EXISTS project.organization
(
    id numeric not null
        constraint organizations_pkey
            primary key,
    name varchar(200) not null
);

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
    organization_id numeric
        constraint users_organization_id_fkey
            references project.organization,
    city_id numeric
        constraint users_city_id_fkey
            references project.city
);

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







