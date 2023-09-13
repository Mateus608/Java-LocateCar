package br.com.interfaces;

import br.com.enums.TipoVeiculo;
import br.com.list.ListaEncadeada;
import br.com.models.Veiculo;

public interface Pesquisar {
    boolean busca(ListaEncadeada<Veiculo> lista, String index);
}
