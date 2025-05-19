public class Mao {
    NOCarta inicio;
    // Classe Lista encadeada.
    public void adicionarCarta(Carta c) {
        NOCarta novo = new NOCarta(c);
        if (inicio == null) {
            inicio = novo;
        } else {
            NOCarta atual = inicio;
            while (atual.prox != null) {
                atual = atual.prox;
            }
            atual.prox = novo;
        }
    }

    public int calcularPontos() {
        int total = 0, ases = 0;
        NOCarta atual = inicio;
        while (atual != null) {
            total += atual.carta.valor;
            if (atual.carta.valor == 1) ases++;
            atual = atual.prox;
        }
        while (ases > 0 && total + 10 <= 21) {
            total += 10;
            ases--;
        }
        return total;
    }

    public int contarCartas() {
        int count = 0;
        NOCarta atual = inicio;
        while (atual != null) {
            count++;
            atual = atual.prox;
        }
        return count;
    }

    public String mostrar(boolean mostrarTodas) {
        StringBuilder sb = new StringBuilder();
        NOCarta atual = inicio;
        int i = 0;
        while (atual != null) {
            if (!mostrarTodas && i == 0) {
                sb.append("[?] ");
            } else {
                sb.append("[").append(atual.carta).append("] ");
            }
            atual = atual.prox;
            i++;
        }
        return sb.toString();
    }
}