INSERT INTO INGREDIENTES
(nome, quantidade, medida)
VALUES
('Chocolate', 200, 'GRAMA'),
('Farinha', 500, 'GRAMA'),
('Ovos', 2, 'UNIDADE'),
('Leite', 100, 'MILILITRO'),
('Açucar', 100, 'GRAMA'),
('Massa para lasanha', 500, 'GRAMA'),
('Molho', 200, 'MILILITRO'),
('Carne moída', 400, 'GRAMA'),
('Queijo', 300, 'GRAMA');


INSERT INTO RECEITAS
(nome, link_foto, tempo_preparo, rendimento, modo_preparo,
revisar, data_publicacao)
VALUES('Brownie de chocolate', 
'https://img.estadao.com.br/fotos/crop/1200x1200/resources/jpg/7/0/1519841184607.jpg', 
40, 
8, 
'Em uma tigela coloque os ovos e o açúcar e bata com a ajuda de fouet ou garfo, em seguida adicione chocolate e depois adicione a farinha até que fique homogênea; Despeje a massa em uma forma untada e asse em forno pré-aquecido a 180ºC por 35 minutos.',
FALSE,
TO_DATE('17/12/2015', 'DD/MM/YYYY')),
('Lasanha',
'https://i.ytimg.com/vi/FrdumyhYaZY/maxresdefault.jpg',
40,
8,
'Cozinhe a massa da lasanha e o molho. Em uma forma coloque uma camada de massa, uma camada de molho, uma camada de carne moída e uma camada de queijo até acabarem os ingredientes, finalize com queijo e asse por 20 minutos.',
FALSE,
CURRENT_TIMESTAMP);

INSERT INTO RECEITAS_INGREDIENTES
(receita_id, ingredientes_id)
VALUES
(1,1),
(1,2),
(1,3),
(1,4),
(1,5),
(2,6),
(2,7),
(2,8),
(2,9);

