drop table if exists fabricante cascade;
create table fabricante(
	idFabricante serial primary key,
	nome varchar(50),
	pais varchar(50)
);
drop table if exists modeloAeronave cascade;
create table modeloAeronave(
	idModeloAeronave serial primary key,
	nome varchar(50),
	capPassageiros integer,
	capCargas numeric,
	autonomia numeric,
	idFabricante integer not null references fabricante(idFabricante)
);