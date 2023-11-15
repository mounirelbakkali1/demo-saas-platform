create schema  default_001;
create schema  demo_001;
create schema  demo_002;
create schema  demo_003;

create table if not exists default_001.users(
     id int  primary key auto_increment,
     name varchar(255) not null
);



create table if not exists demo_001.projects(
    id int  primary key auto_increment,
    name varchar(255) not null,
    description varchar(255) not null
);

create table if not exists demo_002.projects(
    id int  primary key auto_increment,
    name varchar(255) not null,
    description varchar(255) not null
);

create table if not exists demo_003.projects(
    id int  primary key auto_increment,
    name varchar(255) not null,
    description varchar(255) not null
);