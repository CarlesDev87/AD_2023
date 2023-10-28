DROP DATABASE IF EXISTS adt3_ejemplo3;

CREATE DATABASE adt3_ejemplo3;

USE adt3_ejemplo3;

DROP TABLE IF EXISTS contactos;

CREATE TABLE contactos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL,
    telefono VARCHAR(15),
    imagen VARCHAR(255),
    binarioImagen BLOB -- Datos binarios de la imagen
);
