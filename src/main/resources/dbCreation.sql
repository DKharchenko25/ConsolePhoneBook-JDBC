drop schema if exists testdb;
drop all objects;
create schema testdb;

create table ADDRESS
(
    id               int auto_increment PRIMARY KEY,
    country          varchar,
    city             varchar,
    street           varchar,
    house_number     int,
    apartment_number int
);

create table CONTACT_INFO
(
    id           int auto_increment PRIMARY KEY,
    first_name   varchar,
    last_name    varchar,
    age          int,
    phone_number varchar,
    address_id   int,
    foreign key (address_id) references ADDRESS(id)
);

insert into ADDRESS values (default, 'Ukraine', 'Odesa', 'Akademichna', '5', '32');
insert into CONTACT_INFO values (default, 'John', 'Dow', '33', '097234544', 1);