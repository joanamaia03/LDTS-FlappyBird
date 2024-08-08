# LDTS_T07_G04 - Flappy Bird

## Descrição do jogo

No nosso projeto programamos o jogo Flappy Bird à base de texto utilizando a linguagem de programação Java, fazendo uso do lanterna. 

No jogo é possível observar um pássaro e vários tubos, sendo o objetivo do mesmo fazer o pássaro voar entre os tubos, não deixando que este toque nestes ou no chão. Este jogo não apresenta níveis pelo que é infinito.

 Este trabalho foi realizado por Igor Andrade (up202108674@fe.up.pt), Joana Maia (up202108835@fe.up.pt), Matilde Faro (up202108853@fe.up.pt).
 
## Screenshots

Os screenshots seguintes ilustram o nosso jogo, assim como as suas diferentes funcionalidades:
### Jogo

![](https://github.com/FEUP-LDTS-2022/project-l07gr04/blob/master/docs/jogo.gif)
 
Gif 1-Demonstração do Flappy Bird
 
### Menus

 ![image](https://user-images.githubusercontent.com/94479552/209412936-f48703f4-3672-4c01-9003-41a2d5aa1c36.png)

Figura 1-Principal

 ![image](https://user-images.githubusercontent.com/94479552/209412941-fea085ab-fa56-467d-b47f-b3e0d0e8b8de.png)

Figura 2-Instruções
 
### Características implementadas

•	Controlo de teclado – Os inputs recebidos através do teclado são interpretados de acordo com o estado atual do jogo.

•	Controlo do pássaro – O jogador consegue mover o pássaro com o controlo do teclado. Ao clicar na tecla espaço, este move-se para cima. Caso contrário, cai infinitamente para baixo até bater no chão e perder o jogo.

•	Detenção de colisões – As colisões entre o pássaro e os tubos são verificadas e se isto acontecer, acaba o jogo.

•	Remoção dos tubos – Sempre que um tubo sai do ecrã, este é removido para preservar a memória.

•	Menus – O utilizador consegue navegar no menu principal entre as opções jogar e sair e através deste, aceder ao menu instruções que contém a opção voltar.

•	Botões – Existem botões funcionais e interativos.

### Design Patterns

#### Problema em contexto

O principal problema do nosso trabalho foi escolher que padrões havíamos de implementar visto que o nosso jogo utiliza o GUI e é dividido em vários estados do jogo.

#### O Padrão

Ao fim de algumas deliberações foram utilizados 4 padrões: 

•	O Factory Method Pattern, utilizado para definir uma interface com o objetivo de criar um objeto, deixando que as subclasses decidam qual a classe a instanciar; 

•	O State Pattern, utilizado para permitir um objeto alterar o seu comportamento quando o seu estado interno muda; 

•	O Game Loop Pattern que corre continuamente durante o jogo e a cada volta do loop, processa a entrada do utilizador sem bloqueio, atualiza o estado do jogo, e torna-o mais fácil. Para além disso, rastreia a passagem do tempo para controlar a taxa de jogabilidade; 

•	Por último foi utilizado o Architectural Pattern com o intuito de desenvolver interfaces de utilizador que dividem uma aplicação em três partes (model, view, controller).
 
#### Implememtação do Factory Method Pattern

 ![image](https://user-images.githubusercontent.com/94479552/209413012-5f34590f-5463-444f-bbf9-e049d386a60b.png)

Figura 3-Factory Method Pattern Design

### Consequências

•	Elimina a necessidade de ligar classes específicas da aplicação ao seu código.

•	Single Responsability Principle. É possível mover o código para um só local no programa, o que o torna mais fácil de suportar.

•	Open/Closed Principle. É possível a introdução de novos tipos de produtos no programa sem que ocorra falhas no código.
 
### Implementação do State Pattern

![image](https://user-images.githubusercontent.com/94479552/209413018-8e946524-f3b5-4901-8b9a-a9b4e15eae2c.png)

Figura 4-State Pattern Design

### Consequências

•	Simplifica o código, eliminando as condições da máquina de estados.

•	Single Responsability Principle. Organiza o código, relativamente a estados particulares, em classes separadas.

•	Open/Closed Principal. Introduz novos estados sem que ocorra mudança do contexto ou das ‘state classes’ existentes.

### Implementação do Game Loop Pattern

 ![image](https://user-images.githubusercontent.com/94479552/209413049-35cd5389-99bf-4a47-ab42-39cc4c63de1a.png)

Figura 5-Game Loop Pattern Design

### Consequência

•	Desacopla a progressão do tempo de jogo da entrada do utilizador e a velocidade do processador.

### Implementação do Architectural Pattern 

![image](https://user-images.githubusercontent.com/94479552/209413061-4929e54a-80bb-47bc-8d00-8c10e2a2fe0b.png)

Figura 6-Architectural Pattern Design

### Consequências

•	O Controller serve como intermédio para requisições enviadas pelo View e as respostas fornecidas pelo Model.

•	O View serve para apresentar as informações de forma visual ao usuário.

•	O Model serve para gerir e controlar a forma como os dados se comportam através das funções.

 ![image](https://user-images.githubusercontent.com/94479552/209413071-c7c0f0e8-e949-4bb3-afa8-f8c318b4d12a.png)

Figura 7-Architectural Pattern Design

### Diagrama UML das classes implementadas

![image](https://user-images.githubusercontent.com/94479552/209413084-7861584a-5c5e-4721-ba3a-6bd0ea6f089a.png)

### Code Smells e Refactoring

Após a eliminação de alguns Code Smells na nossa primeira versão do trabalho, ainda permaneceram dois:

•	Long Method – A função step(Game game, GUI.ACTION action, long time) contém demasiadas linhas de código. Pode ser resolvido usando decompose conditional, onde se tenta reduzir o método.

![image](https://user-images.githubusercontent.com/94479552/209413091-99652839-36f0-437c-bb91-a836f2f390d8.png)

•	Large Class – A classe Map contém muitos métodos, o que resulta na existência de muitas linhas de código. Pode ser resolvido identificando todas as distinct responsabilities e para cada uma destas extrair da classe, podendo criar uma nova classe ou mover campos e métodos.

 ![image](https://user-images.githubusercontent.com/94479552/209413096-4991a8d1-9cd8-48c2-aa44-95ca03549b86.png)

### Testing
 
![image](https://user-images.githubusercontent.com/94479552/209413104-53acc663-aec1-4ec8-b97d-77d57284abe0.png)

### Mutation Testing

 ![image](https://user-images.githubusercontent.com/94479552/209413114-1dd21730-2ec7-409c-83f6-559bdde4addf.png)

Figura 8-Tabela Mutation Testing

![image](https://user-images.githubusercontent.com/94479552/209414395-ef0c5aa0-6006-4c3c-815e-a60270df71b2.png)

Figura 9-Tabela Mutation Testing

![image](https://user-images.githubusercontent.com/94479552/209414070-3499972d-6d2c-4975-8bc9-8b8cbd94d289.png)

Figura 10-Tabela Mutation Testing

### Self-Evaluation

•	Igor Andrade – 33.3%

•	Joana Maia – 33.3%

•	Matilde Faro – 33.3%
