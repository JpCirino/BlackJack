public class Baralho {
    NOCarta topo;
    // Classe de Pilha.
    public Baralho() {
        String[] naipes = {"♠", "♥", "♦", "♣"};
        String[] nomes = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        int[] valores = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

        Carta[] todas = new Carta[52];
        int k = 0;
        for (String naipe : naipes) {
            for (int i = 0; i < nomes.length; i++) {
                todas[k++] = new Carta(nomes[i] + naipe, valores[i]);
            }
        }

        for (int i = 0; i < todas.length; i++) {
            int r = (int) (Math.random() * todas.length);
            Carta temp = todas[i];
            todas[i] = todas[r];
            todas[r] = temp;
        }

        for (Carta c : todas) {
            empilhar(c);
        }
    }

    private void empilhar(Carta c) {
        NOCarta novo = new NOCarta(c);
        novo.prox = topo;
        topo = novo;
    }

    public Carta puxarCarta() {
        if (topo == null) return null;
        Carta c = topo.carta;
        topo = topo.prox;
        return c;
    }
}