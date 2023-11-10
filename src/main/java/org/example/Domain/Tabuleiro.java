package org.example.Domain;

import org.example.Lig4Exceptions.ColunaCompletaException;

public class Tabuleiro {

    public String[][] Posicoes = new String[6][7];
    public Tabuleiro()
    {
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                Posicoes[i][j] = "[ ]";
            }
        }
    }

    public void AtualizaTabuleiro (Jogada jogada) throws ColunaCompletaException{
        for (int i = 5; i >= 0; i--) {
            if (this.Posicoes[i][jogada.getColunaEscolhida() - 1].equals("[ ]")) {
                this.Posicoes[i][jogada.getColunaEscolhida() - 1] = String.format("[%s]", jogada.getSimbolo());
                i = -1; //para sair do loop
            }
            if (i == 0) {
                throw new ColunaCompletaException();
            }
        }
    }
        public void Exibir() {

        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                System.out.print(Posicoes[i][j]);
            }
            System.out.println();;
        }
        System.out.println(" 1  2  3  4  5  6  7");
    }

    public boolean VerificaVitoria()
    {
        //condição de vitória em linha
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (!Posicoes[i][j].equals("[ ]")
                    && Posicoes[i][j].equals(Posicoes[i][j + 1])
                    && Posicoes[i][j].equals(Posicoes[i][j + 2])
                    && Posicoes[i][j].equals(Posicoes[i][j + 3])) {
                    return true;
                }
            }
        }

        //condição de vitória em coluna
        for (int j = 0; j < 7; j++)
        {
            for (int i = 0; i < 3; i++)
            {
                if (Posicoes[i][j] != "[ ]"
                    && Posicoes[i][j].equals(Posicoes[i+1][j])
                    && Posicoes[i][j].equals(Posicoes[i+2][j])
                    && Posicoes[i][j].equals(Posicoes[i+3][j])) {
                    return true;
                }
            }
        }

        //condicao de vitório na diagnonal NO-SE
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (!Posicoes[i][j].equals("[ ]")
                    && Posicoes[i][j].equals(Posicoes[i+1][j+1])
                    && Posicoes[i][j].equals(Posicoes[i+2][j+2])
                    &&Posicoes[i][j].equals(Posicoes[i+3][j+3])) {
                    return true;
                }
            }
        }

        //condicao de vitório na diagnonal NE-SO
        for (int i = 0; i < 3; i++)
        {
            for (int j = 6; j > 2; j--)
            {
                if (!Posicoes[i][j].equals("[ ]")
                    && Posicoes[i][j].equals(Posicoes[i+1][j-1])
                    && Posicoes[i][j].equals(Posicoes[i+2][j-2])
                    && Posicoes[i][j].equals(Posicoes[i+3][j-3])) {
                    return true;
                }
            }
        }
        return false;
    }
}
