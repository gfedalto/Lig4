package org.example.Lig4Exceptions;

public class TerceiroJogadorException extends RuntimeException{
    public TerceiroJogadorException() {
        super ("Este jogo permite somente dois jogadores");
    }
}
