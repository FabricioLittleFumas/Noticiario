INSERT INTO role(id,nome_role) VALUES(300,'ADM');
INSERT INTO role(id,nome_role) VALUES(301,'USE');
INSERT INTO role(id,nome_role) VALUES(302,'ALL');
INSERT INTO role(id,nome_role) VALUES(303,'GER');

INSERT INTO usuario(id, nome, email, idade,senha) VALUES(100, 'amanda', 'marques',20,'$2a$10$iZxiwjWyYZVgN1i3oG7M1.NBEw.MROUaaM93oTTJrBtyzU3hGyWzS');
INSERT INTO usuario(id, nome, email, idade,senha) VALUES(101, 'bianco', 'arruda',22,'$2a$10$iZxiwjWyYZVgN1i3oG7M1.NBEw.MROUaaM93oTTJrBtyzU3hGyWzS');
INSERT INTO usuario(id, nome, email, idade,senha) VALUES(102, 'carla', 'mendonca',24,'$2a$10$iZxiwjWyYZVgN1i3oG7M1.NBEw.MROUaaM93oTTJrBtyzU3hGyWzS');
INSERT INTO usuario(id, nome, email, idade,senha) VALUES(103, 'camila', 'silva',30,'$2a$10$iZxiwjWyYZVgN1i3oG7M1.NBEw.MROUaaM93oTTJrBtyzU3hGyWzS');


INSERT INTO noticia(id,titulo,subtitulo,conteudo,data) VALUES(200,'Carro explode com drogras','Trafico','Nessa noite de sábado','25/10/2024');
INSERT INTO noticia(id,titulo,subtitulo,conteudo,data) VALUES(201,'Traficante fica milhorario','Dinheiro do trafico','Da noite pro dia homem ficou milhonario','22/05/2022');
INSERT INTO noticia(id,titulo,subtitulo,conteudo,data) VALUES(202,'Casa noturna cheia das do job','mulheres ganham mais que prefeito','Mulheres da noite são as mais ricas da atualidade','15/03/2015');
INSERT INTO noticia(id,titulo,subtitulo,conteudo,data) VALUES(203,'Bingo rende mais dinheiro que o show das primas','Bingo em alta em toda a cidade','Casas de bingo online ganham a cena','11/11/2024');

INSERT INTO usuarios_role(usuario_id,roles_id ) VALUES (100, 300);
INSERT INTO usuarios_role(usuario_id,roles_id ) VALUES (101, 301);
INSERT INTO usuarios_role(usuario_id,roles_id ) VALUES (102,302);
INSERT INTO usuarios_role(usuario_id,roles_id ) VALUES (103,300);
INSERT INTO usuarios_role(usuario_id,roles_id ) VALUES (100,301);

	
