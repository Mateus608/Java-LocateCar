package br.com.interfaces;

import java.util.List;

public interface Pesquisar<T> {
    List<T> pesquisarNome(String nome);
}
