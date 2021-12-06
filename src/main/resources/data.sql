INSERT INTO INGREDIENTES
(nome, quantidade, medida)
VALUES
('Chocolate', 200, 'GRAMA'),
('Farinha', 500, 'GRAMA'),
('Ovos', 2, 'UNIDADE'),
('Leite', 100, 'MILILITRO'),
('Açucar', 100, 'GRAMA');


INSERT INTO RECEITAS
(nome, link_foto, tempo_preparo, rendimento, modo_preparo,
revisar, data_publicacao)
VALUES('Brownie de chocolate', 
'https://img.estadao.com.br/fotos/crop/1200x1200/resources/jpg/7/0/1519841184607.jpg', 
40, 
8, 
'Em uma tigela coloque os ovos e o açúcar e bata com a ajuda de fouet ou garfo, em seguida adicione chocolate e depois adicione a farinha até que fique homogênea; Despeje a massa em uma forma untada e asse em forno pré-aquecido a 180ºC por 35 minutos.',
FALSE, 
CURRENT_TIMESTAMP);

INSERT INTO RECEITAS_INGREDIENTES
(receita_id, ingredientes_id)
VALUES
(1,1),
(1,2),
(1,3),
(1,4),
(1,5);
