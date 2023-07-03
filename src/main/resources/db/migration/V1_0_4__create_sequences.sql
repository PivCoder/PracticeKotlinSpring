CREATE SEQUENCE project.articles_id
START 1
INCREMENT 1
OWNED BY project.articles.id;

CREATE SEQUENCE project.articles_users_id
    START 1
    INCREMENT 1
    OWNED BY project.articles_users.id;

CREATE SEQUENCE project.publishers_id
    START 1
    INCREMENT 1
    OWNED BY project.publishers.id;

CREATE SEQUENCE project.users_id
    START 1
    INCREMENT 1
    OWNED BY project.users.id;
