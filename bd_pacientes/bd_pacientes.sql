use bd_pacientes;

create table pacientes(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(40),
    apellidoUno VARCHAR(20),
    apellidoDos VARCHAR(20),
    edad INT,
    sexo VARCHAR(20),
    enfermedad VARCHAR(20),
    duracion INT,
    dHM VARCHAR(20)
);


SET SQL_SAFE_UPDATES = 0;