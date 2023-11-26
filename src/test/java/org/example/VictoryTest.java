package org.example;

import org.example.Domain.Jogador;
import org.example.Domain.Tabuleiro;
import org.junit.jupiter.api.DisplayName;
import  org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VictoryTest {
    @Test
    @DisplayName("Verifica vitíria na horizontal")
    public void VerificaVitoriaHorizontal() {

        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogador1 = new Jogador("jogador1");
        Jogador jogador2 = new Jogador("jogador2");

        tabuleiro.AtualizaTabuleiro(jogador1.Jogar(1));
        tabuleiro.AtualizaTabuleiro(jogador2.Jogar(2));
        tabuleiro.AtualizaTabuleiro(jogador1.Jogar(3));
        tabuleiro.AtualizaTabuleiro(jogador2.Jogar(4));
        tabuleiro.AtualizaTabuleiro(jogador1.Jogar(1));
        tabuleiro.AtualizaTabuleiro(jogador2.Jogar(7));
        tabuleiro.AtualizaTabuleiro(jogador1.Jogar(2));
        tabuleiro.AtualizaTabuleiro(jogador2.Jogar(7));
        tabuleiro.AtualizaTabuleiro(jogador1.Jogar(3));
        tabuleiro.AtualizaTabuleiro(jogador2.Jogar(7));
        tabuleiro.AtualizaTabuleiro(jogador1.Jogar(4));

        boolean vitoria = tabuleiro.VerificaVitoria();
        assertTrue(vitoria);
    }

    @Test
    @DisplayName("Verifica vitíria na horizontal")
    public void VerificaVitoriaVertical() {

        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogador1 = new Jogador("jogador1");
        Jogador jogador2 = new Jogador("jogador2");

        tabuleiro.AtualizaTabuleiro(jogador1.Jogar(3));
        tabuleiro.AtualizaTabuleiro(jogador2.Jogar(1));
        tabuleiro.AtualizaTabuleiro(jogador1.Jogar(1));
        tabuleiro.AtualizaTabuleiro(jogador2.Jogar(3));
        tabuleiro.AtualizaTabuleiro(jogador1.Jogar(1));
        tabuleiro.AtualizaTabuleiro(jogador2.Jogar(4));
        tabuleiro.AtualizaTabuleiro(jogador1.Jogar(1));
        tabuleiro.AtualizaTabuleiro(jogador2.Jogar(4));
        tabuleiro.AtualizaTabuleiro(jogador1.Jogar(1));

        boolean vitoria = tabuleiro.VerificaVitoria();
        assertTrue(vitoria);
    }

    @Test
    @DisplayName("Verifica vitíria na diagonal positiva")
    public void VerificaVitoriaDiagonalPositiva() {

        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogador1 = new Jogador("jogador1");
        Jogador jogador2 = new Jogador("jogador2");

        tabuleiro.AtualizaTabuleiro(jogador1.Jogar(2));
        tabuleiro.AtualizaTabuleiro(jogador2.Jogar(3));
        tabuleiro.AtualizaTabuleiro(jogador1.Jogar(3));
        tabuleiro.AtualizaTabuleiro(jogador2.Jogar(4));
        tabuleiro.AtualizaTabuleiro(jogador1.Jogar(4));
        tabuleiro.AtualizaTabuleiro(jogador2.Jogar(5));
        tabuleiro.AtualizaTabuleiro(jogador1.Jogar(4));
        tabuleiro.AtualizaTabuleiro(jogador2.Jogar(5));
        tabuleiro.AtualizaTabuleiro(jogador1.Jogar(5));
        tabuleiro.AtualizaTabuleiro(jogador2.Jogar(6));
        tabuleiro.AtualizaTabuleiro(jogador1.Jogar(5));

        boolean vitoria = tabuleiro.VerificaVitoria();
        assertTrue(vitoria);
    }

    @Test
    @DisplayName("Verifica vitíria na diagonal negativa")
    public void VerificaVitoriaDiagonalNegativa() {

        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogador1 = new Jogador("jogador1");
        Jogador jogador2 = new Jogador("jogador2");

        tabuleiro.AtualizaTabuleiro(jogador1.Jogar(7));
        tabuleiro.AtualizaTabuleiro(jogador2.Jogar(6));
        tabuleiro.AtualizaTabuleiro(jogador1.Jogar(6));
        tabuleiro.AtualizaTabuleiro(jogador2.Jogar(5));
        tabuleiro.AtualizaTabuleiro(jogador1.Jogar(5));
        tabuleiro.AtualizaTabuleiro(jogador2.Jogar(4));
        tabuleiro.AtualizaTabuleiro(jogador1.Jogar(5));
        tabuleiro.AtualizaTabuleiro(jogador2.Jogar(4));
        tabuleiro.AtualizaTabuleiro(jogador1.Jogar(4));
        tabuleiro.AtualizaTabuleiro(jogador2.Jogar(1));
        tabuleiro.AtualizaTabuleiro(jogador1.Jogar(4));

        boolean vitoria = tabuleiro.VerificaVitoria();
        assertTrue(vitoria);
    }

}