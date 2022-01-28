# Este jogo é Animal!

Um desafio técnico de programação usando Java/Spring e Angular. Jogo de adivinhação de animais usando uma [árvore de classificação](https://pt.wikipedia.org/wiki/Aprendizagem_de_%C3%A1rvore_de_decis%C3%A3o).

## Dependências

* Java 11/Maven
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

### Frontend
A interface web da aplicação serve para acessar a árvore de classificação e realizar operações de criação e classificação de novos dados. Também é na interface web que reside toda a **lógica de jogo** no que diz respeito à interação com o usuário e apresentação dos dados de forma mais intuitiva.

