# ms-school-apirest

## Table of Contents
1. [Información general](#general-info)
2. [Tecnologías](#Tecnologías)
3. [Instalación](#Instalación)
4. [Servicios](#Servicios)

### Información general
***
Esta prueba es para el caso de "La escuela de “cursos alternativos” desarrollado por Francisco Bernal".

Cierta escuela que ofrece cursos especializados en diversas ciencias del conocimiento ha tenido un
crecimiento inesperado, por lo mismo han surgido necesidades que deben ser satisfechas.
Los padres de familia, los alumnos y muchas instituciones públicas y privadas, exigen información a la
escuela y lo que antes era fácil de proporcionar ahora se vuelve difícil de controlar y de mantener, sin
contar el tiempo invertido en ese proceso.
Derivado de lo anterior el colegio ha decidido desarrollar un sistema que les ayude a satisfacer estás
necesidades, empezando por sus principales clientes el alumno y padres de familia para cumplir la
siguiente obligación – necesidad.
Requerimiento.
La escuela “cursos alternativos” tiene la necesidad de construir un sistema para llevar a cabo el control
de las calificaciones de sus estudiantes, por ello debe crear un RestFul Web Service para registrar,
consultar y actualizar las calificaciones de sus estudiantes.


## Tecnologías
***
Una lista de tecnologías utilizadas en el proyecto.:
* Java: Version 11
* Spring boot: Version 2.7.9
* OAuth2 For Spring Security: Version 2.5.1.RELEASE
* Spring Security JWT : Version 1.1.1.RELEASE



## Instalación
***
Instalaccion del proyecto
```
$ git clone https://github.com/lbernal10/ms-school-apirest.git

```

Instalacion en la base de datos de postgresql - Script
```
CREATE TABLE t_roles (
	id_t_roles SERIAL PRIMARY KEY,
	nombre varchar(80)
);

INSERT INTO t_roles VALUES (default, 'ROLE_PROFESOR'); 
INSERT INTO t_roles VALUES (default, 'ROLE_ALUMNO');
INSERT INTO t_roles VALUES (default, 'ROLE_ADMIN');

CREATE TABLE t_personas (
   	id_t_persona SERIAL PRIMARY KEY,
   	nombre varchar(80),
   	ap_paterno varchar(80),
   	ap_materno varchar(80),
   	activo int
);

INSERT INTO t_personas (nombre, ap_paterno, ap_materno, activo) VALUES ('John', 'Dow', 'Down', 1);
INSERT INTO t_personas (nombre, ap_paterno, ap_materno, activo) VALUES ('Juan', 'Perez', 'Jimenez', 1);
INSERT INTO t_personas (nombre, ap_paterno, ap_materno, activo) VALUES ('Francisco', 'Bernal', 'RIOS', 1);

CREATE TABLE t_usuarios (
	id_t_usuarios SERIAL PRIMARY KEY,
	usuario varchar(80),
	clv_usuario varchar(80),
	id_t_roles int NOT NULL,
	id_t_persona int NOT NULL,
	FOREIGN KEY (id_t_roles) REFERENCES t_roles (id_t_roles),
	FOREIGN KEY (id_t_persona) REFERENCES t_personas (id_t_persona)
);

INSERT INTO t_usuarios VALUES (default, 'profesor', '$2a$10$Pvf/Fipaw0AvivXxDavwLuzYYmhIY5SUft6/jJHWcQWu70skHTvOK', 1, 1);
INSERT INTO t_usuarios VALUES (default, 'alumno', '$2a$10$Pvf/Fipaw0AvivXxDavwLuzYYmhIY5SUft6/jJHWcQWu70skHTvOK', 2, 2);
INSERT INTO t_usuarios VALUES (default, 'admin', '$2a$10$Pvf/Fipaw0AvivXxDavwLuzYYmhIY5SUft6/jJHWcQWu70skHTvOK', 3, 3);

CREATE TABLE t_materias (
	id_t_materias SERIAL PRIMARY KEY,
	nombre varchar(80),
	activo int
);

INSERT INTO t_materias VALUES (default,'matematicas',1); 
INSERT INTO t_materias VALUES (default,'programacion I',1); 
INSERT INTO t_materias VALUES (default,'ingenieria de sofware',1);

CREATE TABLE t_calificaciones (
   id_t_calificaciones SERIAL PRIMARY KEY,
   id_t_materias int NOT NULL,
   id_t_usuarios int NOT NULL,
   calificacion decimal (10,2),
   fecha_registro date,
   FOREIGN KEY (id_t_materias) REFERENCES t_materias (id_t_materias),
   FOREIGN KEY (id_t_usuarios) REFERENCES t_usuarios (id_t_usuarios)
);
```

## Servicios
***


* Servicio para generar el token
```
POST - localhost:8081/oauth/token
```
```
Authorization - Basic Auth 

Username: angularapp
Password: 12345

Body - x-www-form-urlencoded
key: username value: profesor (o puede ser alumno o admin)
key: password value: 12345 (aplica para todos los usuarios)
grant_type: password


JSON :

{
    "materia": {
        "id": 2
    },
    "usuario": {
        "id": 2
    },
    "calificacion": 7
}
```



* Servicio para generar una nueva calificacion
```
POST - localhost:8081/calificacion/
```
```
Authorization - Bearer Token - Rol : Maestro

JSON :

{
    "materia": {
        "id": 2
    },
    "usuario": {
        "id": 2
    },
    "calificacion": 7
}
```

* Servicio para obtener calificaciones por alumno con su promedio
```
GET - localhost:8081/calificacion/{idUsuario}
```
```
Authorization - Bearer Token - Rol : Alumno, Maestro
```

* Servicio para actualizar una calificacion
```
PUT - localhost:8081/calificacion/
```
```
Authorization - Bearer Token - Rol : Maestro

JSON :

{
    "id": {idCalificacion},
    "calificacion": {calificacion}
}
```

* Servicio para eliminar una calificacion
```
DELETE - localhost:8081/calificacion/{idCalificacion}
```
```
Authorization - Bearer Token - Rol : Maestro

```
