--id переделать под big serial выполнить без nextval, переименовать таблицы в ед.число, дропнуть бд, снести историю flyway
--сжать всю систему миграций в 1-2 файла
ALTER TABLE project.publisher RENAME COLUMN "ISSN" TO issn;
ALTER TABLE project.author RENAME COLUMN "pictureRef" TO picture_ref;
ALTER TABLE project.author RENAME COLUMN "userType" TO user_type;
ALTER TABLE project.article RENAME COLUMN "countPages" TO count_pages;
ALTER TABLE project.article RENAME COLUMN "countVisits" TO count_visits;
ALTER TABLE project.article RENAME COLUMN "pictureRef" TO picture_ref;
