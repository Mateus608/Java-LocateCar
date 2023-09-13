package br.com.interfaces;

import br.com.list.ListaEncadeada;
import br.com.models.PessoaJuridica;

public interface EditPessoaJuridica {
    void editarPessoa(ListaEncadeada<PessoaJuridica> lista, String novoNome, String novoNomeFantasia, String novaRazaoSocial,String novoEndereco, String novoContato, String cnpj);

}
