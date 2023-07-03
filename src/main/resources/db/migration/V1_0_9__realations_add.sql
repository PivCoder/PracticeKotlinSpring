ALTER TABLE "project"."journals" ADD FOREIGN KEY (publisher_id) REFERENCES project.publishers ("id");

ALTER TABLE "project"."users"
    ADD COLUMN organization_id numeric,
    ADD FOREIGN KEY ("organization_id") REFERENCES project.organizations ("id");

ALTER TABLE "project"."users"
    ADD COLUMN city_id numeric,
    ADD FOREIGN KEY ("city_id") REFERENCES project.cities ("id");

ALTER TABLE "project"."volumes"
    ADD FOREIGN KEY ("journal_id") REFERENCES project.journals ("id");

ALTER TABLE "project"."articles"
    ADD COLUMN volume_id numeric,
    ADD FOREIGN KEY ("volume_id") REFERENCES project.volumes ("id"),
    DROP COLUMN publishers_id;