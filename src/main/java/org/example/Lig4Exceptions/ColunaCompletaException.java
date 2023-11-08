package org.example.Lig4Exceptions;

public class ColunaCompletaException extends IllegalArgumentException{
    public ColunaCompletaException (){
        super ("Esta coluna está completa, escolha outra com espaços sobrando para jogar!");
    }
}
