package edu.sudoku;

import java.util.Scanner;

public class Jogo extends Tabuleiro {
    private final Tabuleiro tabuleiro;
    private final Scanner scanner;

    public Jogo() {
        this.tabuleiro = new Tabuleiro();
        this.scanner = new Scanner(System.in);
    }

    public void rodarJogo() {
        gerarNivel();
        while (!jogoConcluido()) {
            iniciar(); // Mostra o tabuleiro
            receberJogada(); // Solicita uma jogada do usuário
        }
        System.out.println("Parabéns! O jogo foi concluído com sucesso!");
    }

    public void iniciar() {

        tabuleiro.gerarTabuleiro();
    }

    public void gerarNivel() {
        int nivel;

        do {
            System.out.println("[1] Fácil");
            System.out.println("[2] Moderado");
            System.out.println("[3] Difícil");
            System.out.print("Select: ");
                String select= scanner.next();
             try {
                nivel = Integer.parseInt(select);
                if (nivel >= 1 && nivel <= 3) {
                    break;
                } else {
                    System.out.println("Digite 1, 2 ou 3!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida, digite um numero valido.");
            }
        } while (true);
        if (nivel == 1) {
            tabuleiro.matriz[0][0] = 5;
            tabuleiro.matriz[0][4] = 6;
            tabuleiro.matriz[1][1] = 3;
            tabuleiro.matriz[1][5] = 8;
            tabuleiro.matriz[2][2] = 9;
            tabuleiro.matriz[2][7] = 1;
            tabuleiro.matriz[3][0] = 8;
            tabuleiro.matriz[3][3] = 4;
            tabuleiro.matriz[3][8] = 7;
            tabuleiro.matriz[4][1] = 6;
            tabuleiro.matriz[4][4] = 7;
            tabuleiro.matriz[4][7] = 3;
            tabuleiro.matriz[5][0] = 9;
            tabuleiro.matriz[5][5] = 1;
            tabuleiro.matriz[5][8] = 5;
            tabuleiro.matriz[6][1] = 7;
            tabuleiro.matriz[6][6] = 2;
            tabuleiro.matriz[7][3] = 3;
            tabuleiro.matriz[7][7] = 8;
            tabuleiro.matriz[8][4] = 9;
            tabuleiro.matriz[8][8] = 4;
        }
        else if (nivel == 2) {
            tabuleiro.matriz[0][2] = 4;
            tabuleiro.matriz[0][6] = 8;
            tabuleiro.matriz[1][0] = 7;
            tabuleiro.matriz[1][4] = 9;
            tabuleiro.matriz[1][8] = 2;
            tabuleiro.matriz[2][3] = 5;
            tabuleiro.matriz[2][7] = 6;
            tabuleiro.matriz[3][1] = 2;
            tabuleiro.matriz[3][5] = 7;
            tabuleiro.matriz[4][0] = 1;
            tabuleiro.matriz[4][4] = 6;
            tabuleiro.matriz[4][8] = 9;
            tabuleiro.matriz[5][3] = 8;
            tabuleiro.matriz[5][7] = 4;
            tabuleiro.matriz[6][1] = 5;
            tabuleiro.matriz[6][5] = 2;
            tabuleiro.matriz[7][0] = 3;
            tabuleiro.matriz[7][4] = 7;
            tabuleiro.matriz[7][8] = 1;
            tabuleiro.matriz[8][2] = 9;
            tabuleiro.matriz[8][6] = 4;
        }
        else if (nivel == 3) {
            tabuleiro.matriz[0][1] = 6;
            tabuleiro.matriz[0][5] = 3;
            tabuleiro.matriz[1][0] = 8;
            tabuleiro.matriz[1][4] = 4;
            tabuleiro.matriz[1][8] = 5;
            tabuleiro.matriz[2][2] = 7;
            tabuleiro.matriz[2][6] = 9;
            tabuleiro.matriz[3][3] = 1;
            tabuleiro.matriz[3][7] = 8;
            tabuleiro.matriz[4][0] = 9;
            tabuleiro.matriz[4][8] = 2;
            tabuleiro.matriz[5][1] = 4;
            tabuleiro.matriz[5][5] = 6;
            tabuleiro.matriz[6][2] = 5;
            tabuleiro.matriz[6][6] = 7;
            tabuleiro.matriz[7][0] = 2;
            tabuleiro.matriz[7][4] = 8;
            tabuleiro.matriz[7][8] = 3;
            tabuleiro.matriz[8][3] = 9;
            tabuleiro.matriz[8][7] = 1;
        }
    }

    protected void receberJogada() {
        System.out.println("\n--- Faça sua jogada ---");

        int linha, coluna, numero;
        do {
            System.out.print("Digite a linha (1-9): ");
            linha = scanner.nextInt() - 1;
            System.out.print("Digite a coluna (1-9): ");
            coluna = scanner.nextInt() - 1;
            System.out.print("Digite o número (1-9): ");
            numero = scanner.nextInt();

            if (!validarJogada(linha, coluna, numero)) {
                System.out.println("Tente novamente!\n");
            }
        } while (!validarJogada(linha, coluna, numero));

        tabuleiro.matriz[linha][coluna] = numero;
    }

    protected boolean validarJogada(int linha, int coluna, int numero) {
        if (tabuleiro.matriz[linha][coluna] != 0) {
            System.out.println("Posicao ja ocupada por outro numero!");
            return false;
        }
        if (numero < 1 || numero > 9) {
            System.out.println("Numero invalido,Use valores entre 1 e 9.");
            return false;
        }
        for (int y = 0; y < 9; y++) {
            if (tabuleiro.matriz[linha][y] == numero) {
                System.out.println("Erro: Numero " + numero + " ja existe nessa linha!");
                return false;
            }
        }
        for (int x = 0; x < 9; x++) {
            if (tabuleiro.matriz[x][coluna] == numero) {
                System.out.println("Erro: Numero " + numero + " ja existe nessa coluna!");
                return false;
            }
        }
        return true;
    }

    protected boolean jogoConcluido() {
        boolean tabuleiroCompleto = !temZeros();
        boolean regrasValidas = todasLinhasValidas()
                && todasColunasValidas()
                && todosBlocosValidos();

        return tabuleiroCompleto && regrasValidas;
    }

    private boolean todasLinhasValidas() {
        for (int x = 0; x < 9; x++) {
            if (!tabuleiro.linhaEValida(tabuleiro.matriz, x)) {
                return false;
            }
        }
        return true;
    }

    private boolean todasColunasValidas() {
        for (int y = 0; y < 9; y++) {
            if (!tabuleiro.colunaEValida(tabuleiro.matriz, y)) {
                return false;
            }
        }
        return true;
    }

    private boolean todosBlocosValidos() {
        for (int blocoX = 0; blocoX < 3; blocoX++) {
            for (int blocoY = 0; blocoY < 3; blocoY++) {
                if (!tabuleiro.tresPorTresQuadrado(tabuleiro.matriz, blocoX, blocoY)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean temZeros() {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (tabuleiro.matriz[x][y] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}