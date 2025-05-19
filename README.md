# 🃏 Jogo Blackjack em Java

Projeto desenvolvido por **João Pedro Cirino de Freitas** como parte de um estudo prático sobre **Tipos Abstratos de Dados (TADs)** e **estruturas de dados encadeadas** aplicadas na implementação do jogo Blackjack com interface gráfica em Java.

---

## 1. 🎯 Objetivos

- Representar entidades do jogo (carta, baralho, mão) como TADs.
- Utilizar listas encadeadas (por meio de uma classe de nó) para manipulação das cartas.
- Implementar uma interface gráfica simples usando Swing.
- Implementar as regras básicas do Blackjack, incluindo o Blackjack natural (21 com duas cartas).
- Incluir um botão de reinício do jogo.

---

## 2. 🧱 Estrutura do Código

O projeto é dividido em classes, cada uma representando um TAD:

- `Carta`: representa uma carta do baralho.
- `NoCarta`: representa um nó da lista encadeada contendo uma carta.
- `Mao`: representa uma mão de cartas, utilizando lista encadeada de `NoCarta`.
- `Baralho`: representa um baralho embaralhado de cartas, usando empilhamento com `NoCarta`.
- `BlackjackComNO`: classe principal com a lógica do jogo e interface gráfica.

---

## 3. 🔗 Implementação de Lista Encadeada (NO)

A classe `NoCarta` é usada como nó de uma lista encadeada:

```java
public class NoCarta {  
    Carta carta;  
    NoCarta prox;  

    public NoCarta(Carta carta) {  
        this.carta = carta;  
        this.prox = null;  
    }  
}
```

As classes `Mao` e `Baralho` manipulam essas listas encadeadas para adicionar, remover e percorrer cartas.

---

## 4. 📦 Uso de TADs

Cada classe encapsula seus dados e comportamentos, caracterizando um TAD:

- `Carta`: encapsula nome e valor da carta.
- `Mao`: oferece operações como adicionar carta, calcular pontos, mostrar cartas. Implementa uma lista encadeada.
- `Baralho`: gerencia a criação, embaralhamento e distribuição das cartas. Implementa uma pilha.

---

## 5. 🎨 Interface Gráfica (Swing)

Utiliza-se a biblioteca Swing para criar uma interface gráfica simples:

- `JLabels` para exibir as cartas e status.
- `JButtons` para as ações: "Pedir Carta", "Parar" e "Recomeçar".
- Atualização da interface a cada jogada.

---

## 6. 📋 Regras do Jogo Implementadas

- O jogador e dealer recebem duas cartas no início.
- O jogador pode pedir cartas até estourar ou decidir parar.
- O dealer compra cartas até atingir pelo menos 17 pontos.
- O jogo é decidido por pontuação final.
- ✅ Reconhecimento de Blackjack natural (21 com duas cartas).

---

## 7. 🔁 Funcionalidade de Recomeçar o Jogo

Foi incluído um botão **"Recomeçar"** que reinicializa o baralho, as mãos e o estado da interface, permitindo jogar uma nova partida sem fechar o programa.

---

## 8. ▶️ Como Abrir o JAR

Como é utilizada uma interface gráfica (Swing), basta **clicar duas vezes no arquivo `.jar`** para executá-lo.

> ⚠️ Importante: Certifique-se de que o **JDK esteja na versão 24.0.1** instalada corretamente no seu sistema.

---

## 9. ✅ Conclusão

O projeto atinge os objetivos propostos, demonstrando o uso prático de TADs e estruturas encadeadas em um jogo interativo com interface gráfica.

### 🔮 Futuras Expansões

- Sistema de apostas.
- Pontuação acumulada entre rodadas.
- Inteligência artificial para o dealer.

---
