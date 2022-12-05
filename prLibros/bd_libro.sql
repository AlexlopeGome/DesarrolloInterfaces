use bd_libro;
create table libros(
id int primary key auto_increment,
titulo varchar(40)not null,
editorial varchar (40)not null,
autor varchar (40)not null,
paginas int not null
);
