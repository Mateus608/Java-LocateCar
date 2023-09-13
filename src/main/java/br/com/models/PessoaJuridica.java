package br.com.models;

import br.com.interfaces.EditPessoaJuridica;
import br.com.interfaces.Pesquisar;
import br.com.interfaces.ValidadorPessoa;
import br.com.list.ListaEncadeada;
import br.com.util.ConsoleUI;

public class PessoaJuridica extends Pessoa implements EditPessoaJuridica, Pesquisar<PessoaJuridica>, ValidadorPessoa {
    String razaoSocial;
    String nomeFantasia;
    String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | Razão Social: " + razaoSocial + "| Nome Fantasia: " + nomeFantasia +
                "| Endereço: " + endereco + " | Contato: " + contato + "| CNPJ: " + cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    @Override
    public boolean busca(ListaEncadeada<PessoaJuridica> lista, String index) {
        for (PessoaJuridica pessoa : lista) {
            if (pessoa.getCnpj().equals(index)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void editarPessoa(ListaEncadeada<PessoaJuridica> lista, String novoNome, String novoNomeFantasia, String novaRazaoSocial, String novoEndereco, String novoContato, String cnpj) {
        for (PessoaJuridica pessoa : lista) {
            if (true) {
                pessoa.setNome(novoNome);
                pessoa.setNomeFantasia(novoNomeFantasia);
                pessoa.setRazaoSocial(novaRazaoSocial);
                pessoa.setEndereco(novoEndereco);
                pessoa.setContato(novoContato);
                pessoa.setCnpj(cnpj);
                break;
            } else {
                System.out.println(ConsoleUI.formatText("Cliente não encontrado", "vermelho"));
            }
        }
    }

    @Override
    public boolean validaPessoa(String identificador) {
        boolean valido = true;
        if(identificador.length() != 14){
            valido = false;
        }
        return valido;
    }

    @Override
    public boolean validaTelefone(String telefone) {
        boolean valido = true;
        if (!telefone.substring(3).matches("[0-9]*")) {
            valido = false;
        }
        return valido;
    }
}
