create table if not exists mascota (
    id identity,
    name varchar(50) not null,
    fecha_Nacimiento timestamp not null,
    raza varchar(50) not null,
    peso varchar(10) not null,
    tiene_Chip varchar(10) not null,
    url_Foto varchar(16) not null
);
