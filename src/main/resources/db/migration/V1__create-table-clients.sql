
create table clients(
    id bigint not null auto_increment,
    name varchar(100) not null,
    cpf varchar(11) not null unique,
    number varchar(20),
    email varchar(100) not null unique,
    street varchar(100) not null,
    city varchar(100) not null,
    zip varchar(9) not null,
    country char(2) not null,
    state varchar(100) not null,

    primary key(id)
);