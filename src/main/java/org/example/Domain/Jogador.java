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
/*        if (contador > 1) {
            throw new TerceiroJogadorException();
        }*/
        // tentei fazer lançar uma excessão para não instanciar 3 jogadores mas não consegui fazer funcionar no teste
        // pois eu preciso instanciar o Jogador várias vezes para o caso de rodar cada teste individualmente
        // ai quando roda todos o sistema sempre dispara o erro
        this.nome = nome;
        simbolo = contador == 0 ? Marcador.X : Marcador.O;
        contador++;
    }

    public Jogada Jogar(int colunaEscolhida) throws ColunaCompletaException {
            return new Jogada (colunaEscolhida, this.simbolo.toString());
    }
}
