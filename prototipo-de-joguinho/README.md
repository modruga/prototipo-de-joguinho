# Protótipo de Joguinho

Um teste que consiste em criar um jogo de tabuleiro com regras programadas em conjunto aos pilares da OO.

Avalia os conhecimentos gerais de conceitos (pilares) de orientação a objetos e cobertura de testes unitários (JUnit4).

## Bonecos:

Todos os bonecos possuem stats e classes. Todos os stats exceto constituição são permanentes. Ao chegar em zero de constituição, o personagem morre.

### Joaozinho:

![](https://media.giphy.com/media/oALtlsKnoRtNS/giphy.gif)

**Porradeiro Pitaiense**

Força: 10

Agilidade: 7

Inteligência: 6

Constituição: 60

Leva 1 de dano ao amadurecer.

Time dos Com Camisa.

Peça: J

### Lineuzinho:

![](https://media.giphy.com/media/NcnpbmIGaikMmLkPLD/giphy.gif)

**Bombardeiro Fenix**

Força: 2

Agilidade: 3

Inteligência: 10

Constituição: 80

Ressurge das cinzas ao morrer.

Time dos Com Camisa.

Peça: Z

### Marquinhos:

![](https://media.giphy.com/media/2XjldVNUymqGY/giphy.gif)

**Budoqueiro Cenourês**

Força: 5

Agilidade: 10

Inteligência: 6

Constituição: 80

Time dos Com Camisa.

toString: M

### Claudinho:

![](https://media.giphy.com/media/h86nXRXhDbnMduG6XO/giphy.gif)

**Porradeiro Floriano**

Força: 9

Agilidade: 2

Inteligência: 4

Constituição: 60

Equipe dos Com Camisa.

Peça: A

### Betinho:

![](https://media.giphy.com/media/CKglBtQUVVkPe/giphy.gif)

**Guerreiro Humano**

Força: 7

Agilidade: 6

Inteligência: 3

Constituição: 40

Time dos Com Camisa.

### Carlinhos:

![](https://media.giphy.com/media/GdTjZwXsqqor6/giphy.gif)

**Bombardeiro Fenix**

Força: 2

Agilidade: 2

Inteligência: 9

Constituição: 70

Falha ao ressurgir das cinzas.

toString: C

Time dos Sem Camisa.

### Rodriguinho:

![](https://media.giphy.com/media/tXynjQYaTvi5OtZFTP/giphy.gif)

**Porradeiro Maligno**

Força: 7

Agilidade: 4

Inteligência: 1

Constituição inicial: 30

Peça: R

Time dos Sem Camisa.

### Padinho:

![](https://media.giphy.com/media/QYDQY6T9kREty/giphy.gif)

**Budoqueiro Maligno**

Força: 3

Agilidade: 6

Inteligência: 1

Constituição: 20

Peça: P

Time dos Sem Camisa.

### Leozinho:

![](https://media.giphy.com/media/bK5iHnQTWX0LS/giphy.gif)

**Porradeiro meio-Maligno e meio-Pitaiense**

Força: 8

Agilidade: 6

Inteligência: 3

Constituição: 45

Toma 2 de dano ao amadurecer.

toString: L

Time dos Sem Camisa.

## Origens:

As origens trazem comportamentos caracteristicos da região dos bonecos.

### Florianos:

Os florianos são conhecidos por beber bastante. Eles tendem a falar besteiras quando bêbados. (bêbado = 3 stacks do método beber)

Eles também são conhecidos por serem sociais. Eles até sabem falar!

### Cenoureses:

Cenoureses tem um sotaque esquisito, podendo então dialogarEstranho().

Mas, em contextos específicos, eles também conseguem se comunicar através de conversa!

### Pitaienses:

Pitaienses são originários dos campos de pitaias. Eles são meio-animal e meio-frutas.

Sabem falar, mas tomam dano esporadicamente por amadurecer.

### Fênix:

Os Fênix possuem um dom caso tiverem coração puro: conseguem ressucitar, caso sua constituição chegue a zero.

Também são muito inteligentes, mais do que capazes de trocar uma ideia.

### Malignos:

Fique aqui registrado o fim da minha criatividade. Seres malignos tem grunhidos característicos. Nada além disso.

## Campo (de Batalha):

![](https://media0.giphy.com/media/Yq5gG91kM4Yko/giphy.gif?cid=ecf05e47htytgyesbzydz5kvwpoqbl6cv02drtejrtndmnjg&rid=giphy.gif&ct=g)

O mapa deve ser uma array com 10 posições. As peças Com Camisa posicionadas irão sempre se movimentar pra direita, e os Sem Camisa, para a esquerda.

Deve ser criado um método `String exibir(int posicao, Personagem personagem)` para imprimir o mapa em testes unitários, um `void inserir(int posicao, Personagem personagem)` para inserir personagens (com exceptions caso sejam peças repetidas ou inseridas no mesmo quadrado), 
um método `int buscarPosicao(Personagem personagem)` que busca a posição atual do objeto personagem instanciado em jogo (lança exception caso o personagem nao esteja em campo) e `Personagem buscarCasa(int posicao)` para dizer qual personagem (se houver) está presente na casa solicitada.

**Lembrando que: personagens mortos (constituição >= 0) devem ser removidos completamente do jogo, e não somente da exibição.**

## Classes

Personagens do time Com Camisa atacarão e se movimentarão pra direita. Personagens do Sem Camisa atacarão e se movimentarão pra esquerda.

O jogo percorre o tabuleiro da esquerda pra direita ( Mapa[0] a Mapa[9] ), executando os turnos de cada peça (toda peça irá atacar e, se houver espaço na direção em que sua equipe ataca, se movimentará para a frente).
Os personagens não atacam outros jogadores de sua própria equipe. Caso se deparem com um colega, não atacarão e não subirão no mesmo quadrado deles.

### Bombardeiro

O dano do bombardeiro é igual à sua **inteligência**, e quando atacar causará dano a **todas as peças inimigas em campo.**

O bombardeiro só pode se movimentar ao não existir absolutamente nenhuma outra peça em campo, e seu avanço é sempre de uma única posição por turno.

### Porradeiro

Um porradeiro ataca **somente** peças em **casas adjacentes** à dele, e o dano é de 2 vezes a sua **força**.

Sempre que existir uma posição livre na frente do guerreiro ele deve se movimentar para lá:

### Budoqueiro

Budoqueiros atacam à distância, com 3 casas de alcance. O dano é calculado pela **distancia x a agilidade** do boneco.

**Importante: Um budoqueiro deve sempre tentar atacar o alvo mais distante primeiro, ou seja, a 3ª posição, se não houver um inimigo lá deve tentar a 2ª posição, e assim por diante.**

Budoqueiros avançam duas casas por turno, porém se existir algum personagem em seu caminho, avançam apenas uma.

## Simulador

![](https://media4.giphy.com/media/3ohuPuKIqYVOdTMvG8/giphy.gif?cid=ecf05e47i7wg3m8wvpyenr33mssvz5pa4yxj1e30irvbv82w&rid=giphy.gif&ct=g)

O Simulador recebe o mapa inicial como parâmetro e, dentro da classe, existe somente o método `void simular()`, que executa a partida até um dos seguintes finais possíveis:

**Vitória**: quando os Com Camisa alcançam o fim do tabuleiro (qualquer peça Com Camisa alcançar a posição 9).

**Derrota**: caso todos os Com Camisa forem eliminados. Deve lançar SemCamisaVenceramException.

**Importante: Métodos específicos de origem (falas, grunhidos, bebidas) não farão parte da simulação.**
