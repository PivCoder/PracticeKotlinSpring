--создать новую схему, разбить таблицы по группам +
--правку таблиц varchar ограничить не более 200 символов +
--написать базовый набор данных для тестов
--id сделать numeric (long) сделать инкрементацию через SEQUENCE(Через SPRING ?)
-- оперделить not null поля +
-- проиндексировать поля для поиска и соритрвоки  в целом почитать про индекс и хэши
-- ? добавить id для таблицы многие о многим +
-- почитать за UUID
-- попробовать переписать gradle.build под Kotlin, убрать неиспользуемые зависимости +
-- почитать за перевод колллекций с помощью index map(map)
CREATE SCHEMA IF NOT EXISTS project;

ALTER TABLE articles
    ALTER COLUMN "id" SET DATA TYPE numeric,
    ALTER COLUMN "name" SET NOT NULL,
    ALTER COLUMN "category" SET NOT NULL,
    ALTER COLUMN "state" SET NOT NULL,
    ALTER COLUMN "pictureRef" SET DATA TYPE varchar(200),
    ALTER COLUMN "category" SET DATA TYPE varchar(100),
    ALTER COLUMN "state" SET DATA TYPE varchar(50);
ALTER TABLE articles SET SCHEMA project;

ALTER TABLE articles_users
    ADD COLUMN "id" numeric,
    ADD CONSTRAINT articles_users_pk
        PRIMARY KEY ("id");
ALTER TABLE articles_users SET SCHEMA project;

ALTER TABLE publishers
    ALTER COLUMN "name" SET NOT NULL,
    ALTER COLUMN "ISSN" SET NOT NULL,
    ALTER COLUMN "id" SET DATA TYPE numeric;
ALTER TABLE publishers SET SCHEMA project;

ALTER TABLE users
    ALTER COLUMN "id" SET DATA TYPE numeric,
    ALTER COLUMN "name" SET NOT NULL,
    ALTER COLUMN "surname" SET NOT NULL,
    ALTER COLUMN "userType" SET NOT NULL,
    ALTER COLUMN "name" SET NOT NULL,
    ALTER COLUMN "pictureRef" SET DATA TYPE varchar(200),
    ALTER COLUMN "userType" SET DATA TYPE varchar(30);
ALTER TABLE users SET SCHEMA project;