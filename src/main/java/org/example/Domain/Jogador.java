package org.example.Domain;

import lombok.Getter;
import org.example.Lig4Exceptions.ColunaCompletaException;
import org.example.Lig4Exceptions.ColunaInvalidaException;
import org.example.Lig4Exceptions.TerceiroJogadorException;

@Getter
public class Jogador {
    String nome;

    enum Marcador { X, O }

    Marcador simbolo;

    static int contador = 0;

    public Jogador(String nome) {
        if (contador > 1) {
            throw new TerceiroJogadorException();
        }
        this.nome = nome;
        simbolo = contador == 0 ? Marcador.X : Marcador.O;
        contador++;
    }

    public Jogada Jogar(int colunaEscolhida) throws ColunaCompletaException {
            return new Jogada (colunaEscolhida, this.simbolo.toString());
    }
}
