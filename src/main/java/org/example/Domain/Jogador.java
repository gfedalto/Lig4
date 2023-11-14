package org.example.Domain;

import lombok.Getter;
import org.example.Lig4Exceptions.ColunaCompletaException;
import org.example.Lig4Exceptions.TerceiroJogadorException;

@Getter
public class Jogador {
    private final String nome;
    private enum Marcador { X, O }
    private Marcador simbolo;
    private static int contador = 0;

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
