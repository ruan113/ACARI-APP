-- Tables
create table empresas(
	id bigint primary key, 
	nome varchar(50) NOT NULL,
	cnpj varchar(18) NOT NULL
);

create table associados(
	id bigint primary key,
	nome varchar(50) NOT NULL,
	cpf varchar(15) DEFAULT '-',
	rg varchar(15) DEFAULT '-',
	data_nasc date NOT NULL,
	cep varchar(9) DEFAULT '-',
	uf varchar(2) NOT NULL,
	end_cidade varchar(50) NOT NULL,
	end_bairro varchar(50) NOT NULL,	
	end_rua varchar(60) NOT NULL,
	end_num smallint NOT NULL,	
	telefone varchar(30) NOT NULL
);

create table materiais(
	id bigint primary key,
	nome varchar(30) NOT NULL,
	tipo varchar(20) NOT NULL
);

create table compras(
	id bigint primary key,
	id_associado bigint,
	data_compras DATE NOT NULL DEFAULT CURRENT_DATE,
	foreign key (id_associado) references associados(id)
);

create table itens_comprados(
	id_material bigint, 
	id_compra bigint, 
	quantidade float NOT NULL, 
	preco_kg float NOT NULL, 
	preco_total float NOT NULL, 
	foreign key (id_material) references materiais(id),
	foreign key (id_compra) references compras(id) ON DELETE CASCADE, 
	primary key (id_material,id_compra)
);

create table vendas(
	id bigint primary key, 
	id_empresa int,
	data_vendas DATE NOT NULL DEFAULT CURRENT_DATE,
	nota_fiscal boolean DEFAULT false,
	foreign key (id_empresa) references empresas(id)
);

create table itens_vendidos(
	id_material int, 
	id_venda bigint, 
	quantidade float NOT NULL, 
	preco_kg float NOT NULL, 
	preco_total float NOT NULL,
	foreign key (id_material) references materiais(id),
	foreign key (id_venda) references vendas(id) ON DELETE CASCADE,
	primary key (id_material,id_venda)
);

create table despesas(
	id bigint primary key,
	titulo varchar(100) NOT NULL,
	tipo varchar(18) NOT NULL,
	valor float NOT NULL, 
	data DATE NOT NULL DEFAULT CURRENT_DATE
);

-- Sequencias
CREATE SEQUENCE associados_id_seq
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 9223372036854775807
  START 0
  CACHE 1;
CREATE SEQUENCE empresas_id_seq
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 9223372036854775807
  START 0
  CACHE 1;
CREATE SEQUENCE materiais_id_seq
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 9223372036854775807
  START 0
  CACHE 1;
CREATE SEQUENCE compras_id_seq
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 9223372036854775807
  START 0
  CACHE 1;
CREATE SEQUENCE vendas_id_seq
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 9223372036854775807
  START 0
  CACHE 1;
CREATE SEQUENCE despesas_id_seq
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 9223372036854775807
  START 0
  CACHE 1;

-- Inserts (test)
insert into associados
(id, nome, cpf, rg, data_nasc, cep, uf, end_cidade, end_bairro, end_rua, end_num, telefone)
values 
(nextval('associados_id_seq'),'Patrick Felix', '111.111.111-11', '11.111.111-1', '13-Mar-1997', '11111111','MG','Itajubá','Cruzeiro','Rua Mario Braz', 131, '(35)998581214'),
(nextval('associados_id_seq'),'José Antonio', '222.222.222-22', '22.222.22-2', '27-May-1984', '22222121','SP','Campinas','Centro','Rua Doutor Irineu', 45, '(19)983525151'),
(nextval('associados_id_seq'),'Mathaus Machado', '-', '-', '01-Jun-1992', '13556122','ES','Vitória','Jardim Camburi','Rua Alcides Vianna', 98, '(27)912345679');

insert into empresas
(id, nome, cnpj)
values 
(nextval('empresas_id_seq'),'Caça Sucata 2000', '123.3121.1211-122'),
(nextval('empresas_id_seq'),'Kangaru', '321.6666.651-555'),
(nextval('empresas_id_seq'),'Thauros Sucatas', '798.6546.223-56');

insert into materiais
(id, nome, tipo)
values 
(nextval('materiais_id_seq'),'Polietileno Tereftalato (PET)', 'Plástico'),
(nextval('materiais_id_seq'),'Polipropileno (PP)', 'Plástico'),
(nextval('materiais_id_seq'),'Poliestireno (PS)', 'Plástico');

--SELECT currval('compras_id_seq');

insert into compras
(id, id_associado, data_compras)
values 
(nextval('compras_id_seq'),'0', '2018-11-11'),
(nextval('compras_id_seq'),'1', '2010-03-22'),
(nextval('compras_id_seq'),'1', '2012-02-28');

select * from compras;
select * from itens_comprados;
select * from materiais;

insert into itens_comprados
(id_material, id_compra, quantidade, preco_kg, preco_total)
values 
('0','4', '2.0','1.0','2.0'),
('1','4', '2.0','1.0','2.0'),
('2','4', '2.0','1.0','2.0');
