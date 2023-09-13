package br.com.interfaces;

import br.com.enums.TipoVeiculo;
import br.com.list.ListaEncadeada;
import br.com.models.Veiculo;

public interface EditVeiculo {
    void editarItem(ListaEncadeada<Veiculo> lista, String placa, String novoModelo, TipoVeiculo novoTipoVeiculo);
}
