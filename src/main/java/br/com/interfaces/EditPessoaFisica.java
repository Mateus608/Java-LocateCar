package br.com.interfaces;

import br.com.list.ListaEncadeada;
import br.com.models.PessoaFisica;

public interface EditPessoaFisica {
    void editarPessoa(ListaEncadeada<PessoaFisica> lista, String novoNome, String novoSobrenome, String novoEndereco, String novoContato, String cpf);

}
