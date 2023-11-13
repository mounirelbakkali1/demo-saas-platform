create table if not exists users(
    id int primary key auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    email varchar(255) not null,
    created_at timestamp default current_timestamp
);


create table if not exists projects(
    id int primary key auto_increment,
    name varchar(255) not null,
    description varchar(255) not null,
    created_at timestamp default current_timestamp,
    user_id int not null,
    foreign key (user_id) references users(id)
);

create table if not exists tasks(
    id int primary key auto_increment,
    name varchar(255) not null,
    description varchar(255) not null,
    created_at timestamp default current_timestamp,
    project_id int not null,
    foreign key (project_id) references projects(id)
);