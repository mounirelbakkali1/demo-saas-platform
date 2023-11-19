create schema  demo001;
create schema  demo002;
create schema  demo003;



create table if not exists demo001.projects(
    id serial  primary key ,
    name varchar(255) not null,
    description varchar(255) not null
);

create table if not exists demo002.projects(
    id serial  primary key ,
    name varchar(255) not null,
    description varchar(255) not null
);

create table if not exists demo003.projects(
    id serial  primary key ,
    name varchar(255) not null,
    description varchar(255) not null
);