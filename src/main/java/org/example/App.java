package org.example;

import org.example.Domain.Jogada;
import org.example.Domain.Jogador;
import org.example.Domain.Tabuleiro;
import org.example.Lig4Exceptions.ColunaCompletaException;
import org.example.Lig4Exceptions.ColunaInvalidaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class App 
{
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    public static void main( String[] args ) throws InterruptedException {
        LocalDateTime start = LocalDateTime.now();
        Scanner sc = new Scanner(System.in);
        LOGGER.info("Iniciando nova partida");

        System.out.println("Bem vindo ao liga 4\n");
        System.out.println("Digite o nome do primeiro jogador");
        Jogador jogador1 = new Jogador(sc.nextLine());
        LOGGER.info("Jogador 1: " + jogador1.getNome());
        System.out.println("Digite o nome do segundo jogador");
        Jogador jogador2 = new Jogador(sc.nextLine());
        LOGGER.info("Jogador 2: " + jogador2.getNome());
        var tabuleiro = new Tabuleiro();
        Jogada jogada = null;
        boolean jogadorVenceu;
        Jogador jogadorDaVez = jogador1;

        do {
            //inserir código para limpar o console
            tabuleiro.Exibir();
            System.out.printf("\n%s, é a sua vez de jogar, seu símbolo é o {%s}", jogadorDaVez.getNome(), jogadorDaVez.getSimbolo());
            System.out.println("\nescolha uma coluna para fazer uma jogada");

            boolean jogadaValida;
            do {
                jogadaValida = true;
                int colunaEscolhida = sc.nextInt();
                try {
                    jogada = jogadorDaVez.Jogar(colunaEscolhida);
                    tabuleiro.AtualizaTabuleiro(jogada);
                    System.out.printf("\nA coluna %d, será preenchida com %s\n", jogada.getColunaEscolhida(),jogada.getSimbolo());
                } catch (ColunaInvalidaException | ColunaCompletaException ex){
                    System.out.println(ex.getMessage());
                    Thread.sleep(2000);
                    jogadaValida = false;
                    LOGGER.error("Erro detectado: ",ex);
                }
            } while (!jogadaValida);
            LOGGER.info(jogadorDaVez.getNome() + " jogou na coluna " + jogada.getColunaEscolhida());

            jogadorVenceu = tabuleiro.VerificaVitoria();
            if (!jogadorVenceu) jogadorDaVez = alternaJogadorDaVez(jogadorDaVez, jogador1, jogador2);

            Thread.sleep(2000);

        } while (!jogadorVenceu);

        tabuleiro.Exibir();
        System.out.printf("""
                JOGO ENCERRADO!!!!!!!!
                O jogador vencedor foi: %s""", jogadorDaVez.getNome());
        LocalDateTime end = LocalDateTime.now();
        long between = ChronoUnit.SECONDS.between(start, end);
        LOGGER.info(jogadorDaVez.getNome() + " venceu a partida, com duração de " + between + " segundos" );
    }

    private static Jogador alternaJogadorDaVez(Jogador jogadorDaVez, Jogador jogador1, Jogador jogador2) {
        LOGGER.debug("Executando método de troca de jogador");
        if (jogadorDaVez == jogador1) {
            jogadorDaVez = jogador2;
        } else {
            jogadorDaVez = jogador1;
        }
        return jogadorDaVez;
    }
}
