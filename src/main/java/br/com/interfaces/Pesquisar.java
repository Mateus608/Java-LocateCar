package br.com.interfaces;

import br.com.list.ListaEncadeada;

public interface Pesquisar<T> {
    boolean busca(ListaEncadeada<T> lista, String index);
}
