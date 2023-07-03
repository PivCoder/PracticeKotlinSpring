CREATE TABLE IF NOT EXISTS "users" (
  "id" integer PRIMARY KEY,
  "name" varchar(150),
  "surname" varchar(150),
  "patronymic" varchar(150),
  "rating" decimal,
  "pictureRef" varchar,
  "userType" varchar
);

CREATE TABLE IF NOT EXISTS "publishers" (
  "id" integer PRIMARY KEY,
  "name" varchar(300),
  "ISSN" varchar(8)
);

CREATE TABLE IF NOT EXISTS "articles" (
  "id" integer PRIMARY KEY,
  "name" varchar(200),
  "countPages" integer,
  "countVisits" integer,
  "pictureRef" varchar,
  "category" varchar,
  "state" varchar,
  "publishers_id" integer
);

CREATE TABLE IF NOT EXISTS "articles_users" (
  "articles_id" integer,
  "users_id" integer
);

ALTER TABLE "articles_users" ADD FOREIGN KEY ("users_id") REFERENCES "users" ("id");

ALTER TABLE "articles_users" ADD FOREIGN KEY ("articles_id") REFERENCES "articles" ("id");

ALTER TABLE "articles" ADD FOREIGN KEY ("publishers_id") REFERENCES "publishers" ("id");
