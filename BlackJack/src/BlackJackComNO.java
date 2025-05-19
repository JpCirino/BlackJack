import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BlackJackComNO extends JFrame implements ActionListener {
    Baralho baralho = new Baralho();
    Mao jogador = new Mao();
    Mao dealer = new Mao();

    JLabel lblJogador = new JLabel();
    JLabel lblDealer = new JLabel();
    JLabel lblStatus = new JLabel("Bem-vindo ao Blackjack com Nós!");
    JButton btnHit = new JButton("Pedir Carta");
    JButton btnStand = new JButton("Parar");
    JButton btnRestart = new JButton("Recomeçar");

    public BlackJackComNO() {
        setTitle("Blackjack com Nós");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel painelCartas = new JPanel(new GridLayout(2, 1));
        painelCartas.add(lblJogador);
        painelCartas.add(lblDealer);

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnHit);
        painelBotoes.add(btnStand);
        painelBotoes.add(btnRestart);

        add(lblStatus, BorderLayout.NORTH);
        add(painelCartas, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        btnHit.addActionListener(this);
        btnStand.addActionListener(this);
        btnRestart.addActionListener(this);
        btnRestart.setEnabled(false);

        iniciarJogo();
        setVisible(true);
    }

    void iniciarJogo() {
        jogador.adicionarCarta(baralho.puxarCarta());
        jogador.adicionarCarta(baralho.puxarCarta());
        dealer.adicionarCarta(baralho.puxarCarta());
        dealer.adicionarCarta(baralho.puxarCarta());

        atualizarTela(false);

        int pontosJogador = jogador.calcularPontos();
        int pontosDealer = dealer.calcularPontos();

        boolean blackjackJogador = pontosJogador == 21 && jogador.contarCartas() == 2;
        boolean blackjackDealer = pontosDealer == 21 && dealer.contarCartas() == 2;

        if (blackjackJogador || blackjackDealer) {
            atualizarTela(true);
            if (blackjackJogador && blackjackDealer) {
                encerrarJogo("Empate com Blackjack!");
            } else if (blackjackJogador) {
                encerrarJogo("Blackjack! Você venceu automaticamente!");
            } else {
                encerrarJogo("Dealer tem Blackjack! Você perdeu.");
            }
        }
    }

    void atualizarTela(boolean mostrarTodasDealer) {
        lblJogador.setText("Jogador: " + jogador.mostrar(true) + " - Pontos: " + jogador.calcularPontos());
        lblDealer.setText("Dealer: " + dealer.mostrar(mostrarTodasDealer) +
                (mostrarTodasDealer ? " - Pontos: " + dealer.calcularPontos() : ""));
    }

    void encerrarJogo(String mensagem) {
        atualizarTela(true);
        lblStatus.setText(mensagem);
        btnHit.setEnabled(false);
        btnStand.setEnabled(false);
        btnRestart.setEnabled(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnHit) {
            jogador.adicionarCarta(baralho.puxarCarta());
            atualizarTela(false);
            if (jogador.calcularPontos() > 21) {
                encerrarJogo("Você estourou! Dealer venceu.");
            }
        } else if (e.getSource() == btnStand) {
            while (dealer.calcularPontos() < 17) {
                dealer.adicionarCarta(baralho.puxarCarta());
            }

            int pj = jogador.calcularPontos();
            int pd = dealer.calcularPontos();

            if (pd > 21 || pj > pd) {
                encerrarJogo("Você venceu!");
            } else if (pd > pj) {
                encerrarJogo("Dealer venceu!");
            } else {
                encerrarJogo("Empate!");
            }
        } else if (e.getSource() == btnRestart) {
            baralho = new Baralho();
            jogador = new Mao();
            dealer = new Mao();
            btnHit.setEnabled(true);
            btnStand.setEnabled(true);
            btnRestart.setEnabled(false);
            lblStatus.setText("Nova rodada iniciada.");
            iniciarJogo();
        }
    }
    public static void main(String[] args) {
        new BlackJackComNO();
    }
}