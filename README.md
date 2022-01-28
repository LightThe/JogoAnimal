# Este jogo é Animal!

Um desafio técnico de programação usando Java/Spring e Angular. Jogo de adivinhação de animais usando uma [árvore de classificação](https://pt.wikipedia.org/wiki/Aprendizagem_de_%C3%A1rvore_de_decis%C3%A3o).

## Dependências

* JDK 11/Maven
* NodeJS v14

## Como executar

Para executar esse projeto, clone o repositório, navegue até a pasta **jogo-backend** e execute os comandos
```sh
mvn clean install
mvn spring-boot:run
```
para compilar e executar o servidor da aplicação.

Navegue até a pasta **jogo-webclient** e execute os comandos 
```sh
npm install
npm start
```
para iniciar a interface web do jogo. Navegue até o endereço fornecido pelo seu console (geralmente `localhost:4200` e divirta-se)

## Detalhes do projeto

Este projeto é constituído de um backend Java e uma interface web NodeJS (Angular)

### Backend
O backend é responsável por registrar, organizar e disponibilizar os nós de uma árvore de classificação binária. Através da biblioteca Spring Data, os nós são armazenados em um banco de dados H2, inicialmente configurado para se manter em memória apenas durante a execução (você pode alterar esse comportamento caso precise armazenar a árvore de classificação permanentemente).

A decisão de usar um banco de dados embarcado na aplicação visa diminuir a quantidade de dependências necessárias para o funcionamento do sistema, necessitando apenas das plataformas para execução da linguagem, sem precisar configurar containers, bancos de dados ou conexões.

O backend está organizado em uma estrutura de camadas que facilita a escalabilidade do projeto e a inclusão de mais entidades ou serviços conforma necessário. As camadas do sistema, partindo do banco de dados até o _endpoint_ do serviço, são:
* Domain: Definição das entidades e mapeamento dos campos no banco de dados (ORM).
* Repository: Controle das transações das entidades no banco, uma instância do repositório JPA específica para a entidade.
* Service: Definição, validações e tratamento de dados, nessa camada ficam as "regras de negócio" referentes à entidade.
* Controller: API HTTP da aplicação, _endpoints_ relacionados ao serviço da entidade.

### Frontend
A interface web da aplicação serve para acessar a árvore de classificação e realizar operações de criação e classificação de novos dados. Também é na interface web que reside toda a **lógica de jogo** no que diz respeito à interação com o usuário e apresentação dos dados de forma mais intuitiva.

A interface está organizada em módulos, sendo **maingame** o módulo principal do jogo. Dentro do módulo reside um _service_ responsável por realizar as requisições HTTP para o backend e um _model_ contendo as definições das entidades, da mesma forma como são especificadas no backend. O módulo do jogo também contém um componente contendo a lógica do jogo e um componente para o diálogo exibido ao finalizar.

