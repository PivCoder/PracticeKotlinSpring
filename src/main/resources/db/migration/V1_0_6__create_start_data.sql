INSERT INTO
    project.users(id, name, surname, patronymic, rating, "pictureRef", "userType")
VALUES
    (nextval('project.users_id'), 'Test_name_1', 'Test_Surname_1', '', 0.0, '', 'Test'),
    (nextval('project.users_id'), 'Test_name_2', 'Test_Surname_2', '', 0.0, '', 'Test'),
    (nextval('project.users_id'), 'Test_name_3', 'Test_Surname_3', '', 0.0, '', 'Test'),
    (nextval('project.users_id'), 'Test_name_4', 'Test_Surname_4', '', 0.0, '', 'Test');

INSERT INTO
    project.publishers(id, name, "ISSN")
VALUES
    (nextval('project.publishers_id'), 'Test_publisher_1', '111-111'),
    (nextval('project.publishers_id'), 'Test_publisher_2', '222-111'),
    (nextval('project.publishers_id'), 'Test_publisher_3', '333-111'),
    (nextval('project.publishers_id'), 'Test_publisher_4', '444-111');

INSERT INTO
    project.articles(id, name, "countPages", "countVisits", "pictureRef", category, state, publishers_id)
VALUES
    (nextval('project.articles_id'), 'Test_article_1', 0, 0, '', 'Biology', 'rejected', 1),
    (nextval('project.articles_id'), 'Test_article_2', 0, 0, '', 'Biology', 'rejected', 1),
    (nextval('project.articles_id'), 'Test_article_3', 0, 0, '', 'Biology', 'rejected', 3),
    (nextval('project.articles_id'), 'Test_article_4', 0, 0, '', 'Biology', 'rejected', 2);

INSERT INTO
    project.articles_users(articles_id, users_id, id)
VALUES
    (1, 1, nextval('project.articles_users_id')),
    (2, 2, nextval('project.articles_users_id')),
    (2, 3, nextval('project.articles_users_id')),
    (3, 4, nextval('project.articles_users_id'));
