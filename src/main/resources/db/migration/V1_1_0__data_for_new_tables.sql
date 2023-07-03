INSERT INTO
    project.cities(id, name)
VALUES
    (nextval('project.cities_id'), 'Samara'),
    (nextval('project.cities_id'), 'Rostov'),
    (nextval('project.cities_id'), 'Moscow');

INSERT INTO
    project.organizations(id, name)
VALUES
    (nextval('project.organizations_id'), 'Organization 1'),
    (nextval('project.organizations_id'), 'Organization 2'),
    (nextval('project.organizations_id'), 'Organization 3');

INSERT INTO
    project.journals(id, name, publisher_id)
VALUES
    (nextval('project.journals_id'), 'Journal 1', 1),
    (nextval('project.journals_id'), 'Journal 2', 1),
    (nextval('project.journals_id'), 'Journal 3', 4);

INSERT INTO
    project.volumes(id, name, journal_id)
VALUES
    (nextval('project.volumes_id'), 'Volume 1', 2),
    (nextval('project.volumes_id'), 'Volume 2', 3),
    (nextval('project.volumes_id'), 'Volume 3', 1);

UPDATE project.articles SET volume_id = 1 WHERE id = 1;
UPDATE project.articles SET volume_id = 1 WHERE id = 2;
UPDATE project.articles SET volume_id = 2 WHERE id = 3;
UPDATE project.articles SET volume_id = 3 WHERE id = 4;

UPDATE project.users SET organization_id = 2, city_id = 1 WHERE id = 1;
UPDATE project.users SET organization_id = 2, city_id = 3 WHERE id = 2;
UPDATE project.users SET organization_id = 2, city_id = 2 WHERE id = 3;
UPDATE project.users SET organization_id = 1, city_id = 1 WHERE id = 4;