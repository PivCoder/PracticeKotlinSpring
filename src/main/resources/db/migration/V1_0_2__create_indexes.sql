--Индексирование по ФИО для users ?
CREATE INDEX ISSN_index ON project.publishers ("ISSN");
CREATE INDEX article_name_index ON project.articles ("name");
CREATE INDEX article_category_index ON project.articles("category");

