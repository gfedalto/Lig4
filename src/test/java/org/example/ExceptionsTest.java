package org.example;

import org.example.Domain.Jogador;
import org.example.Domain.Tabuleiro;
import org.example.Lig4Exceptions.ColunaCompletaException;
import org.example.Lig4Exceptions.ColunaInvalidaException;
import org.example.Lig4Exceptions.TerceiroJogadorException;
import org.junit.jupiter.api.DisplayName;
import  org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionsTest {

    @Test
    @DisplayName("Verifica as excessões do jogo")
    public void TestaExcessoes() {

        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogador = new Jogador("jogador");


        assertThrows(ColunaInvalidaException.class, () ->{
            tabuleiro.AtualizaTabuleiro(jogador.Jogar(-5));
        });

        assertThrows(ColunaInvalidaException.class, () ->{
            tabuleiro.AtualizaTabuleiro(jogador.Jogar(9));
        });

        for (int i = 0; i < 6; i++) {
            tabuleiro.AtualizaTabuleiro(jogador.Jogar(1));
        }

        assertThrows(ColunaCompletaException.class, () ->{
            tabuleiro.AtualizaTabuleiro(jogador.Jogar(1));
        });

/*        Jogador jogador2 = new Jogador("jogador2");
        assertThrows(TerceiroJogadorException.class, () ->{
            Jogador jogador3 = new Jogador("jogador3");
        });*/

    }
}
