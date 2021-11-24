# frameworks-java-2021

# Conteúdo

Plano de estudos com cursos, artigos e vídeos com o conteúdo do módulo de frameworks Java.

- [Plano de estudos](https://cursos.alura.com.br/back-end-java-frameworks-vnsueda-1622339271571-p164453)

Conteúdo adicional

- https://www.baeldung.com/spring-boot-start (em inglês)
- https://www.baeldung.com/spring-boot-crud-thymeleaf (em inglês)
- https://medium.com/@mmarcosab/crud-em-api-rest-com-spring-boot-h2-maven-e-jpa-hibernate-e-documenta%C3%A7%C3%A3o-com-swagger-parte-1-1040e2aae0ed
- http://www.matera.com/blog/post/crud-com-spring-e-thymeleaf

# Desafio

Desafio do módulo "Back-end - Frameworks Java" do Movimento Codar 2021. Crie um portal de receitas!

## Pré-requisitos

- Instale o [Git](https://git-scm.com/).
- Instale o Java 17. Existem várias distribuições diferentes e instaladores para diversos SO´s. Utilize a de sua preferência. Se não tiver uma use a da [Oracle](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html).
- Faça um fork desse projeto clicando no botão `Fork` no canto superior direito da página, conforme a imagem abaixo.

![Realizando o fork](https://docs.github.com/assets/images/help/repository/fork_button.jpg)

- Acesse o fork que você criou e faça o clone para a sua máquina. Clique primeiro no botão `Code` e depois copie a URL.

<img src="https://docs.github.com/assets/images/help/repository/https-url-clone-cli.png" alt="Copiando a URL" width="40%"/>

- Realize o clone com o comando `git clone` + a URL copiada.

- Importe o projeto na sua IDE ou editor de texto preferido. Se não tiver uma recomendamos o [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/).

No Eclipse:
- Clique em `File > Import... > Existing Maven Projects`.
- Selecione o diretório do projeto.
- Clique em `Finish`.

No IntelliJ:
- Clique me `File > New > Project from Existing Sources...`.
- Selecione o diretório do projeto.
- Selecione `Import project from external model`.
- Selecione a opção `Maven`.
- Clique em `Finish`.

## Executando o projeto

- Abra a classe `ReceitasApplication.java`
- Clique com o botão direito e selecione `Run As | Debug As > Java Application` (Dependendo da IDE pode ser um pouco diferente o nome)
- Acesse a sua aplicação no navegador através do endereço `http://localhost:8080` (A porta padrão é a 8080, caso você tenha configurado outra porta considere ela na url)
- Quando quiser para a aplicação basta clicar em `Terminate` (quadrado vermelho) que aparece na aba `Console` (Dependendo da IDE pode ser um pouco diferente o nome/localização)

## Observações sobre o projeto

Esse projeto foi criado no site https://start.spring.io/ com as seguintes configurações:

![Configurações do Projeto](https://user-images.githubusercontent.com/6104963/143315882-1d08d2cc-6c25-4327-bd1c-3ec104777d2c.png)

O banco de dados utilizado é o H2 (https://www.h2database.com) ele está configurado como um banco de dados em memória. 

Dessa forma ao reiniciar a aplicação os dados serão perdidos.

As configurações do banco de dados estão no arquivo `application.properties`.

O Hibernate está configurado para já criar as tabelas de acordo com as classes mapeadas (`spring.jpa.hibernate.ddl-auto`) então não é necessário criar as tabelas manualmente.

## Resolvendo o desafio

Você é o responsável pela construção um portal de receitas culinárias.

A estrutura inicial do projeto já foi disponibilizada para você.

As interfaces já estão criadas. Os arquivos estão em `src/main/resources/templates` . Não são necessárias alterações nesses arquivos. Basta ver a estrutura e nomes de campos para saber como criar suas classes.

As funcionalidades que você deve implementar são:

### Cadastro de Novas Receitas

Deve ser exibido o formulário de cadastro de nova receita (cadastro-receita.html) ao acessar `http://localhost:8080/receitas/nova`

Ao submeter o formulário deve:

Realizar uma requisição POST para `http://localhost:8080/receitas`.

Realizar as validações (ver abaixo as informações sobre validações).

Em caso de sucesso deve exibir a mensagem “Receita salva com sucesso!” e exibir o
formulário vazio.

Em caso de erro deve exibir o formulário marcando os erros nos campos.

Os dados que deve ser salvos relacionados à receita são:
- Nome.
- Link da foto.
- Tempo de preparo (em minutos).
- Rendimento (porções).
- Modo de preparo.
- Lista de Ingredientes.
- Deve ser revisado.
- Data/Hora de criação.
- Cada ingrediente tem um nome, uma quantidade e uma medida (GRAMAS, MILILITRO ou UNIDADE)

Os dados que deve ser validados ao tentar salvar a receita são:
- Nome é obrigatório.
- Tempo de preparo é obrigatório. Deve ser no mínimo 10 e no máximo 360 minutos.
- Rendimento é obrigatório. Deve ser no mínimo 1 e no máximo 50 porções.
- Modo de preparo é obrigatório e deve ter no mínimo 20 caracteres.
- Deve ter ao menos um ingrediente.
- Para o ingrediente o nome é obrigatório, a quantidade deve ser no mínimo 1 e no máximo 1000, e deve ter uma das medidas.

### Listagem de Receitas

Deve ser exibida a lista de receitas cadastradas (`lista-receitas.html`) ao acessar `http://localhost:8080/receitas/lista`.

Não deve exibir as receitas que foram marcadas como “Deve ser revisado”.

Deve exibir as receitas ordenadas da mais recente para a mais antiga.

### Detalhes de Receitas

Ao clicar em uma das receitas da listagem deve ser exibido a tela de informações detalhadas da receita (`detalhe-receita.html`).

O endereço que deve ser chamado ao clicar em uma receita é `http://localhost:8080/receitas/detalhe/{id}` onde o {id} é o id da receita cadastrada.

## Submetendo a solução dos desafios

Ao terminar crie um `Pull Request` com a sua solução.

Para isso clique em `Contribute` e `Open Pull Request`. Depois basta confirmar a operação.

<img src="https://user-images.githubusercontent.com/6104963/125391895-911cd300-e37b-11eb-90d9-5b92cd8e5445.PNG" alt="Criando PR" width="40%"/>

## :trophy: Finalizaram o desafio :trophy: