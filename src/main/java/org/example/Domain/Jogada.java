package org.example.Domain;

import lombok.Getter;
import org.example.Lig4Exceptions.ColunaInvalidaException;

public class Jogada {
    @Getter private int colunaEscolhida;

    @Getter private String simbolo;

    public Jogada (int colunaEscolhida, String simbolo) {
        if (colunaEscolhida < 1 || colunaEscolhida > 7) {
            throw new ColunaInvalidaException();
        }
        this.colunaEscolhida = colunaEscolhida;
        this.simbolo = simbolo;
    }


    public void setColunaEscolhida(int colunaEscolhida) {
        if (colunaEscolhida < 1 || colunaEscolhida > 7) {
            throw new ColunaInvalidaException();
        }
        this.colunaEscolhida = colunaEscolhida;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
}
