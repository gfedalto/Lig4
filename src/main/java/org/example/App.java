package org.example;

import org.example.Domain.Jogada;
import org.example.Domain.Jogador;
import org.example.Domain.Tabuleiro;
import org.example.Lig4Exceptions.ColunaCompletaException;
import org.example.Lig4Exceptions.ColunaInvalidaException;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem vindo ao liga 4\n");
        System.out.println("Digite o nome do primeiro jogador");
        String nome1 = sc.nextLine();
        System.out.println("Digite o nome do segundo jogador");
        String nome2 = sc.nextLine();

        Jogador jogador1 = new Jogador(nome1);
        Jogador jogador2 = new Jogador(nome2);

        var tabuleiro = new Tabuleiro();

        Jogador jogadorDaVez = jogador1;
        boolean jogadorVenceu;
        Jogada jogada = null;
        do {
            //inserir código para limpar o console
            tabuleiro.Exibir();
            System.out.printf("\n%s, é a sua vez de jogar, seu símbolo é o {%s}", jogadorDaVez.getNome(), jogadorDaVez.getSimbolo());
            System.out.println("\nescolha uma coluna para fazer uma jogada");
            int colunaEscolhida = sc.nextInt();
            boolean jogadaValida;
            do {
                jogadaValida = true;
                try {
                    jogada = jogadorDaVez.Jogar(colunaEscolhida);
                } catch (ColunaInvalidaException ex){
                    System.out.println(ex.getMessage());
                    jogadaValida = false;
                    colunaEscolhida = sc.nextInt();
                }
            } while (!jogadaValida);


            try {
                tabuleiro.AtualizaTabuleiro(jogada);
                System.out.printf("\nA coluna %d, será preenchida com %s\n", jogada.getColunaEscolhida(),jogada.getSimbolo());
            } catch (ColunaCompletaException ex) {
                System.out.println(ex.getMessage());
                Thread.sleep(2000);
                // tentar eliminar esse monte de inversão com o break <label>
                // tentar usar uma fila para armazenar e trocar os dois jogadores ao invés do if
                if (jogadorDaVez == jogador1) {
                    jogadorDaVez = jogador2;
                } else {
                    jogadorDaVez = jogador1;
                }
            }

            jogadorVenceu = tabuleiro.VerificaVitoria();
            if (jogadorDaVez == jogador1) {
                jogadorDaVez = jogador2;
            } else {
                jogadorDaVez = jogador1;
            }


            Thread.sleep(1000);


        } while (!jogadorVenceu);

        if (jogadorDaVez == jogador1) {
            jogadorDaVez = jogador2;
        } else {
            jogadorDaVez = jogador1;
        }
        tabuleiro.Exibir();
        System.out.printf("\nJOGO ENCERRADO!!!!!!\nO " +
                "jogador vencedor foi: %s", jogadorDaVez.getNome());
    }
}
