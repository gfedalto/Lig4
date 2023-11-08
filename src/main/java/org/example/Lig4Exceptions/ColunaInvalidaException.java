package org.example.Lig4Exceptions;

public class ColunaInvalidaException extends IllegalArgumentException{
    public ColunaInvalidaException() {
        super("Valor da coluna inválido. Escolher um número entre 1 e 7");
    }
}
