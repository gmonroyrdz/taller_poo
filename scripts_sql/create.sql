create database clientes;

use clientes;

create table Persona(
    id int not null unique auto_increment,
    nombre varchar(80),
    apellido_paterno varchar(60),
    apellido_materno varchar(60),
    edad varchar(3),
    genero varchar(10),
    primary key (id)
);

create table Direccion(
    id int not null unique auto_increment,
    calle varchar(60),
    num_ext varchar(4),
    num_int varchar(6),
    colonia varchar(20),
    municipio varchar(80),
    poblacion varchar(40),
    pais varchar(10),
    persona_id int,
    primary key (id),
    foreign key (persona_id) references Persona(id)
);

