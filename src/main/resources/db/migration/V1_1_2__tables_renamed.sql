--id переделать под big serial выполнить без nextval, переименовать таблицы в ед.число, дропнуть бд, снести историю flyway
--сжать всю систему миграций в 1-2 файла
ALTER TABLE project.article_user RENAME TO article_author

