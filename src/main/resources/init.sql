CREATE TABLE students
(
    id           bigserial primary key,
    name        varchar(255) not null,
    mark     int
);
DROP TABLE students;