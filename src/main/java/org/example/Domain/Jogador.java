package org.example.Domain;

import lombok.Getter;
import org.example.Lig4Exceptions.ColunaCompletaException;
import org.example.Lig4Exceptions.ColunaInvalidaException;
import org.example.Lig4Exceptions.TerceiroJogadorException;

public class Jogador {
    @Getter String nome;

    enum Marcador { X, O }

    @Getter Marcador simbolo;

    static int contador = 0;

    public Jogador(String nome) {
        if (contador > 1) {
            throw new TerceiroJogadorException();
        }
        this.nome = nome;
        simbolo = contador == 0 ? Marcador.X : Marcador.O;
        contador++;
    }

    public void Jogar(Tabuleiro tabuleiro, int colunaEscolhida) throws ColunaCompletaException, ColunaInvalidaException {
        if(colunaEscolhida < 1 || colunaEscolhida > 7) {
            throw new ColunaInvalidaException();
        }

        for (int i = 5; i >= 0 ; i--) {
            if(tabuleiro.Posicoes[i][colunaEscolhida - 1].equals("[ ]"))
            {
                tabuleiro.Posicoes[i][colunaEscolhida - 1] = String.format("[%s]", simbolo);
                i = -1; //para sair do loop
            }
            if (i == 0) {throw new ColunaCompletaException();}
            // caso o loop chegue ao fim sem passar pelo if anterior,
            // quer dizer que todos os valores da coluna estão preenchidos
            // então será lançado o erro
        }
    }
}
