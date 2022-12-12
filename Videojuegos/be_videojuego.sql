use bd_videojuego;
create table videojuegos(
id int primary key auto_increment,
nombre varchar(40)not null,
precio float(2) not null,
consola varchar(40)not null,
PEGI int not null
);