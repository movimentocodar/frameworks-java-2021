INSERT INTO INGREDIENTES (NOME, QUANTIDADE, MEDIDA) VALUES
('Lata de Leite Condensado', 1, 'UNIDADE'),
('Lata de Creme de Leite', 1, 'UNIDADE'),
('Feijão', 500, 'GRAMA'),
('Toucinho', 200, 'GRAMA'),
('Cebola média picada', 1, 'UNIDADE'),
('Dentes de alho', 4, 'UNIDADE'),
('Colher (sopa) de sal com alho', 1, 'UNIDADE'),
('Cheiro-verde a gosto', 1, 'UNIDADE'),
('Farinha de mandioca', 200, 'GRAMA'),
('Café solúvel', 50, 'GRAMA'),
('Xícaras de açúcar refinado', 2, 'UNIDADE'),
('Xícara de água', 1, 'UNIDADE');

INSERT INTO RECEITA (NOME, LINK_FOTO, TEMPO_PREPARO, RENDIMENTO, DATA_PUBLICACAO, MODO_PREPARO, REVISAR) VALUES
('MOUSSE DE LIMÃO', 'https://img.itdg.com.br/tdg/images/recipes/000/001/621/38640/38640_original.jpg?mode=crop&width=710&height=400', 10, 10, '2021-11-01 17:02:28.636254', 'Coloque no liquidificador o creme de leite (com soro mesmo) e o leite condensado. Bata um pouco e depois vá acrescentando o suco do limão, aos poucos. Ele vai ficar bem consistente, leve à geladeira.', FALSE),
('FEIJÃO TROPEIRO', 'https://img.itdg.com.br/tdg/images/recipes/000/000/961/327805/327805_original.jpg?mode=crop&width=540&height=400', 60, 6, '2021-11-05 07:32:28.636254', 'Coloque o óleo em uma panela e doure a cebola, acrescente o bacon e frite bem. Adicione o alho, sal e os ovos, misturando com cuidado para que não se despedacem muito. Refogue o feijão, baixe o fogo, misture a farinha aos poucos e o cheiro-verde.', FALSE),
('CAFÉ CREMOSO', 'https://img.itdg.com.br/tdg/images/recipes/000/011/486/140396/140396_original.jpg?mode=crop&width=710&height=400', 15, 15, '2021-12-01 15:16:28.636254', 'Junte todos os ingredientes e bata na batedeira durante 15 minutos até ficar um creme. Guarde no congelador em pote fechado. Este creme é para ser servido do seguinte modo: 1 colher de sobremesa em 1 xícara de café quente (já pronto) ou 2 colheres de sobremesa em 1 xícara de leite fervendo. Está pronta uma deliciosa bebida cremosa para aquecer as noites frias de inverno.', FALSE);

INSERT INTO RECEITA_INGREDIENTES (RECEITA_ID, INGREDIENTES_ID) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(2, 5),
(2, 6),
(2, 7),
(2, 8),
(2, 9),
(3, 10),
(3, 11),
(3, 12);