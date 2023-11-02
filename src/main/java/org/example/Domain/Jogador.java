package org.example.Domain;

import lombok.Getter;

public class Jogador {
    @Getter String nome;

    enum Marcador { X, O }

    @Getter public Marcador Simbolo;

    static int contador = 0;

    public Jogador(String nome) throws Exception {
        if (contador > 1) {
            throw new Exception("É permitido criar somente dois jogadores para esse jogo");
        }
        this.nome = nome;
        Simbolo = contador == 0 ? Marcador.X : Marcador.O;
        contador++;
    }

    public void Jogar(Tabuleiro tabuleiro, int colunaEscolhida) throws Exception {
        for (int i = 5; i >= 0 ; i--) {
            if(tabuleiro.Posicoes[i][colunaEscolhida - 1].equals("[ ]"))
            {
                tabuleiro.Posicoes[i][colunaEscolhida - 1] = String.format("[%s]", Simbolo);
                i = -1; //para sair do loop
            }
            if (i == 0) throw new Exception("Essa coluna não pode receber mais jogadas");
            // caso o loop chegue ao fim sem passar pelo if anterior,
            // quer dizer que todos os valores da coluna estão preenchidos
            // então será lançado o erro
        }
    }
}
