create table empresas(
	id serial primary key, 
	nome varchar(50) NOT NULL,
	cnpj varchar(18) NOT NULL
);

create table associados(
	id serial primary key,
	nome varchar(30) NOT NULL,
	cpf varchar(15) DEFAULT '-',
	rg varchar(15) DEFAULT '-',
	data_nasc date NOT NULL,
	cep varchar(8) DEFAULT '-',
	uf varchar(2) NOT NULL,
	end_cidade varchar(50) NOT NULL,
	end_bairro varchar(50) NOT NULL,	
	end_rua varchar(60) NOT NULL,
	end_num smallint NOT NULL,	
	telefone varchar(60) NOT NULL
);

create table materiais(
	id serial primary key,
	nome varchar(30) NOT NULL,
	tipo varchar(20) NOT NULL
);

create table compras(
	id bigserial primary key,
	id_associado int,
	data_compras DATE NOT NULL DEFAULT CURRENT_DATE,
	foreign key (id_associado) references associados(id)
);

create table itens_comprados(
	id_material int, 
	id_compra bigint, 
	quantidade float NOT NULL, 
	preco_kg float NOT NULL, 
	preco_total float NOT NULL, 
	foreign key (id_material) references materiais(id),
	foreign key (id_compra) references compras(id), 
	primary key (id_material,id_compra)
);

create table vendas(
	id bigserial primary key, 
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
	foreign key (id_venda) references vendas(id),
	primary key (id_material,id_venda)
);

create table despesas(
	id serial primary key,
	titulo varchar(100) NOT NULL,
	tipo varchar(18) NOT NULL,
	valor float NOT NULL, 
	data DATE NOT NULL DEFAULT CURRENT_DATE
);

insert into associados
(nome, cpf, rg, data_nasc, cep, uf, end_cidade, end_bairro, end_rua, end_num, telefone)
values 
('Patrick Felix', '111.111.111-11', '11.111.111-1', '13-Mar-1997', '11111111','MG','Itajubá','Cruzeiro','Rua Mario Braz', 131, '(35)998581214'),
('José Antonio', '222.222.222-22', '22.222.22-2', '27-May-1984', '22222121','SP','Campinas','Centro','Rua Doutor Irineu', 45, '(19)983525151'),
('Mathaus Machado', '-', '-', '01-Jun-1992', '13556122','ES','Vitória','Jardim Camburi','Rua Alcides Vianna', 98, '(27)912345679');

insert into empresas
(nome, cnpj)
values 
('Caça Sucata 2000', '123.3121.1211-122'),
('Kangaru', '321.6666.651-555'),
('Thauros Sucatas', '798.6546.223-56');

insert into materiais
(nome, tipo)
values 
('Polietileno Tereftalato (PET)', 'Plástico'),
('Polipropileno (PP)', 'Plástico'),
('Poliestireno (PS)', 'Plástico');