package edu.sudoku;

import java.util.HashSet;
import java.util.Set;

public class Tabuleiro {
    int [][]matriz;
   int linhas;
   int colunas;
    Set<Integer>numbers=new HashSet<>();

    public Tabuleiro() {
        matriz= new int[9][9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                matriz[i][j] = 0;
            }
        }
    }
    public void gerarTabuleiro() {
        System.out.println("+-------+-------+-------+");
        for(int x = 0; x < 9; x++) {
            System.out.print("| ");
            for(int y = 0; y < 9; y++) {
                if(matriz[x][y] == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(matriz[x][y] + " ");
                }

                if((y + 1) % 3 == 0) {
                    System.out.print("| ");
                }
            }
            System.out.println();

            if((x + 1) % 3 == 0) {
                System.out.println("+-------+-------+-------+");
            }
        }
    }

    public static boolean linhaEValida(int [][]matriz,int linhas){
        Set<Integer>numerosVistos=new HashSet<>();
        for(int coluna=0;coluna < 9;coluna++){
            int numeroNaLinha= matriz[linhas][coluna];
            if(numeroNaLinha==0){
                continue;
            }
            if (numeroNaLinha < 1 || numeroNaLinha > 9){
                return false;
            }
            if(!numerosVistos.add(numeroNaLinha)){
                return false;
            }
        }

        return true;
    }
    public static boolean colunaEValida(int [][]matriz,int colunas){
        Set<Integer>numerosVistos=new HashSet<>();
        for(int linha=0;linha < 9 ;linha ++){
            int numeroNaColuna = matriz[linha][colunas];
                if(numeroNaColuna==0){
                    continue;
                }
                if(numeroNaColuna < 1 || numeroNaColuna > 9){
                    System.out.println("Numero inserido invalido");
                    return false;
                }
                if(!numerosVistos.add(numeroNaColuna)){
                    return false;
                }
        }
        return true;
    }
    public static boolean tresPorTresQuadrado(int [][]matriz,int blocoNaLinha,int blocoNaColuna){//[blocoNaLinha][BlocoNaColuna]matriz
        Set<Integer> numerosVistos = new HashSet<>();
        int colunas=blocoNaColuna*3;
        int linhas=blocoNaLinha*3;

        int total=linhas*colunas;
            for(int linha=linhas;linha < linhas+3;linha++){
                for(int coluna=colunas;coluna < colunas+3;coluna++){
                    int numero=matriz[linha][coluna];
                        if(numero== 0){
                            continue;
                        }
                        if(numero < 1 || numero > 9){
                            System.out.println("Numero invalido");
                            return false;
                        }
                        if(!numerosVistos.add(numero)){
                            return false;
                        }
                }

            }
            return true;
    }
    /* Forma que meu codigo esta funcionando por blocos;
        Bloco (0,0) | Bloco (0,1) | Bloco (0,2)
        ------------|-------------|------------
        Bloco (1,0) | Bloco (1,1) | Bloco (1,2)
        ------------|-------------|------------
        Bloco (2,0) | Bloco (2,1) | Bloco (2,2)
     */

    /*public static void main(String[] args) {
        Tabuleiro tabuleiro= new Tabuleiro();
        tabuleiro.gerarTabuleiro();

            /*tabuleiro.matriz[0][0]=5;
            tabuleiro.matriz[1][1] = 3;
            tabuleiro.matriz[4][4] = 7;
            tabuleiro.matriz[8][8] = 9;
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

            System.out.println("\nTabuleiro com numeros:");
            tabuleiro.gerarTabuleiro();
    }*/
}
