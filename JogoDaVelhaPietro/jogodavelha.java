import java.util.*;

public class jogodavelha {
    private static char[] tabuleiro = new char[9];
    private static char jogadorAtual = 'X';
    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean jogarNovamente = true;

        while (jogarNovamente) {
            iniciarTabuleiro();
            System.out.println("\nNovo jogo iniciado!\n");

            while (true) {
                mostrarTabuleiro();
                fazerJogada();
                if (verificarVitoria()) {
                    mostrarTabuleiro();
                    System.out.println("Jogador '" + jogadorAtual + "' venceu!\n");
                    break;
                } else if (verificarEmpate()) {
                    mostrarTabuleiro();
                    System.out.println("Empate!\n");
                    break;
                }
                trocarJogador();
            }

            System.out.print("Deseja iniciar um novo jogo? (Sim ? Digite 1 / Nao ? Digite 0): ");
            String resposta = scanner.nextLine().toLowerCase();
            jogarNovamente = resposta.equals("1");
        }

        System.out.println("Encerrando o Jogo");
        scanner.close();
    }

    private static void iniciarTabuleiro() {
        Arrays.fill(tabuleiro, ' ');
        jogadorAtual = 'X';
    }

    private static void mostrarTabuleiro() {
        System.out.println();
        for (int i = 0; i < 9; i += 3) {
            System.out.println(" " + tabuleiro[i] + " | " + tabuleiro[i + 1] + " | " + tabuleiro[i + 2]);
            if (i < 6) {
                System.out.println("-----------");
            }
        }
        System.out.println();
    }

    private static void fazerJogada() {
        int posicao;
        do {
            posicao = random.nextInt(9);
        } while (tabuleiro[posicao] != ' ');
        tabuleiro[posicao] = jogadorAtual;
    }

    private static void trocarJogador() {
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }

    private static boolean verificarVitoria() {
        int[][] combinacoes = {
                { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 },
                { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },
                { 0, 4, 8 }, { 2, 4, 6 }
        };

        for (int[] c : combinacoes) {
            if (tabuleiro[c[0]] == jogadorAtual &&
                    tabuleiro[c[1]] == jogadorAtual &&
                    tabuleiro[c[2]] == jogadorAtual) {
                return true;
            }
        }
        return false;
    }

    private static boolean verificarEmpate() {
        for (char c : tabuleiro) {
            if (c == ' ')
                return false;
        }
        return true;
    }
}
