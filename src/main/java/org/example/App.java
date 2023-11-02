package org.example;

import org.example.Domain.Jogador;
import org.example.Domain.Tabuleiro;

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

        Jogador jogador1 = null;
        Jogador jogador2 = null;
        try {
            jogador1 = new Jogador(nome1);
            jogador2 = new Jogador(nome2);
        } catch (Exception e) {
        }

        var tabuleiro = new Tabuleiro();

        Jogador jogadorDaVez = jogador1;
        boolean jogadorVenceu;
        do {
            try
            {
                final String os = System.getProperty("os.name");
                if (os.contains("Windows"))
                {
                    Runtime.getRuntime().exec("cls");
                }
                else
                {
                    Runtime.getRuntime().exec("clear");
                }
            }
            catch (final Exception e) {
                System.out.println("Sistema operacional não detectado");
            }
            tabuleiro.Exibir();
            System.out.printf("\n%s, é a sua vez de jogar, seu símbolo é o {%s}", jogadorDaVez.getNome(), jogadorDaVez.Simbolo);
            System.out.println("\nescolha uma coluna para fazer uma jogada");
            int jogada = sc.nextInt();

            try {
                jogadorDaVez.Jogar(tabuleiro, jogada);
                System.out.printf("\nA coluna %d, será preenchida com %s", jogada,jogadorDaVez.Simbolo);

            } catch (Exception ex) {
                System.out.println("Essa coluna já está completa, tente novamente escolhendo outra coluna");
                Thread.sleep(2000);
            }

            jogadorVenceu = tabuleiro.VerificaVitoria();
            if (jogadorDaVez == jogador1) {
                jogadorDaVez = jogador2;
            } else {
                jogadorDaVez = jogador1;
            }


            Thread.sleep(1000);


        } while (!jogadorVenceu);

    }
}
