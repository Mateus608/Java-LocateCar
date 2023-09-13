package br.com.models;

import br.com.interfaces.EditPessoaFisica;
import br.com.interfaces.Pesquisar;
import br.com.list.ListaEncadeada;
import br.com.util.ConsoleUI;

public class PessoaFisica extends Pessoa implements EditPessoaFisica, Pesquisar<PessoaFisica> {
    String sobrenome;
    String cpf;

    @Override
    public String toString() {
        return "Nome: " + getNomeCompleto() + "| Endereço: " + endereco + " | Contato: " + contato + "| CPF: " + cpf;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeCompleto() {
        return this.nome + " " + this.sobrenome;
    }

    @Override
    public boolean busca(ListaEncadeada<PessoaFisica> lista, String index) {
        for (PessoaFisica pessoa : lista) {
            if (pessoa.getCpf().equals(index)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void editarPessoa(ListaEncadeada<PessoaFisica> lista, String novoNome, String novoSobrenome, String novoEndereco, String novoContato, String Cpf) {
        for (PessoaFisica pessoa : lista) {
            if (cpf.equals(pessoa.getCpf())) {
                pessoa.setNome(novoNome);
                pessoa.setSobrenome(novoSobrenome);
                pessoa.setEndereco(novoEndereco);
                pessoa.setContato(novoContato);
                pessoa.setCpf(cpf);
                break;
            } else {
                System.out.println(ConsoleUI.formatText("Cliente não encontrado", "vermelho"));
            }
        }
    }
}
