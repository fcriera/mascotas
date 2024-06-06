create table if not exists mascotas (
    id identity,
    name varchar(50) not null,
    fechaNacimiento timestamp not null,
    raza varchar(50) not null,
    peso varchar(10) not null,
    tieneChip varchar(10) not null,
    urlFoto varchar(16) not null
);
