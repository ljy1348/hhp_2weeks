CREATE TABLE users (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(100)
);

create table lecture ( id bigint primary key auto_increment
                     , instructor_id bigint
                     , user_id bigint
                     , date timestamp
                     , max_user_count int
                     , total_applied_user int
                     , name varchar);

create table lecture_applied_user (
    id bigint primary key auto_increment,
    lecture_id bigint,
    user_id bigint
);

create table instructor (
    id bigint primary key auto_increment,
    name varchar(10)
);