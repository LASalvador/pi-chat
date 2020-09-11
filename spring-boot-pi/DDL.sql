create schema chatbd;
use chatbd;

create user 'user'@'localhost' identified by 'pass321';
grant select, insert, delete, update, on chatbd.* to user@'localhost';

create table tipo_usuario(
	id_tipo_usuario bigint unsigned not null auto_increment,
	nome_tipo_usuario varchar(30) not null,
	primary key (id_tipo_usuario)
);


create table usuario(
	id_usuario bigint unsigned not null auto_increment,
	nome_usuario varchar(30) not null,
	cpf_usuario varchar(20) not null,
	id_tipo_usuario bigint unsigned not null,
	data_criado date,
	data_atualizado date,
	primary key (id_usuario),
	unique key uni_cpf (cpf_usuario),
	foreign key fk_tipo_usuario (id_tipo_usuario) references tipo_usuario (id_tipo_usuario)
);

create table arquivos(
	id_arquivo bigint unsigned not null auto_increment,
	nome_arquivo varchar(30) not null,
	id_usuario bigint unsigned not null,
	primary key (id_arquivo),
	foreign key fk_id_usuario (id_usuario) references usuario (id_usuario)
);

create table conversa(
	id_conversa bigint unsigned not null auto_increment,
	data_criado date,
	data_atualizado date,
	primary key (id_conversa)
);

create table mensagem(
	id_mensagem bigint unsigned not null auto_increment,
	id_conversa bigint unsigned not null,
	id_usuario bigint unsigned not null,
	data_criado date,
	conteudo_mensagem longtext not null,
	primary key (id_mensagem),
	foreign key fk_id_conversa (id_conversa) references conversa (id_conversa),
	foreign key fk_id_usuario (id_usuario) references usuario (id_usuario)
);

create usuario_conversa(
	id_usuario_conversa bigint unsigned not null auto_increment,
	id_usuario bigint unsigned not null,
	id_conversa bigint unsigned not null,
	foreign key fk_id_conversa (id_conversa) references conversa (id_conversa),
	foreign key fk_id_usuario (id_usuario) references usuario (id_usuario)
);
