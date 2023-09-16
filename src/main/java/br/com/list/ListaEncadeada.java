package br.com.list;

import br.com.enums.TipoVeiculo;
import br.com.models.Aluguel;
import br.com.models.PessoaFisica;
import br.com.models.PessoaJuridica;
import br.com.models.Veiculo;
import br.com.util.ConsoleUI;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ListaEncadeada<T> implements Iterable<T> {
    private Celula<T> primeiro;
    private Celula<T> ultimo;
    private int tamanho;

    public void adicionarInicio(T dado) {
        Celula<T> novaCelula = new Celula<>(this.primeiro, dado);
        this.primeiro = novaCelula;

        if (this.tamanho == 0) {
            this.ultimo = novaCelula;
        }

        this.tamanho++;
    }

    public void adicionarFim(T dado) {
        if (this.tamanho == 0) {
            this.adicionarInicio(dado);
        } else {
            Celula<T> novaCelula = new Celula<>(dado);
            this.ultimo.setProximo(novaCelula);
            this.ultimo = novaCelula;
            this.tamanho++;
        }
    }

    public void mostrarLista() {
        if (this.tamanho == 0) {
            System.out.println(ConsoleUI.formatText("Nenhum cadastro adicionado!", "vermelho"));
            return;
        }

        Celula<T> celulaAtual = this.primeiro;

        for (int i = 0; i < this.tamanho; i++) {
            System.out.println(celulaAtual.getDado());
            celulaAtual = celulaAtual.getProximo();
        }
    }

    public void excluirItem(String index, int identificador) {
        if (this.tamanho == 0) {
            return;
        }

        Celula<T> celulaAtual = this.primeiro;
        Celula<T> celulaAnterior = null;

        while (celulaAtual != null) {
            if (identificador == 1) {
                if (((Veiculo) celulaAtual.getDado()).getPlaca().equals(index)) {
                    if (celulaAnterior == null) {
                        this.primeiro = this.primeiro.getProximo();
                    } else {
                        celulaAnterior.setProximo(celulaAtual.getProximo());
                    }
                    this.tamanho--;
                    return;
                }
            } else if (identificador == 2) {
                if (((PessoaFisica) celulaAtual.getDado()).getCpf().equals(index)) {
                    if (celulaAnterior == null) {
                        this.primeiro = this.primeiro.getProximo();
                    } else {
                        celulaAnterior.setProximo(celulaAtual.getProximo());
                    }
                    this.tamanho--;
                    return;
                }
            } else if (identificador == 3) {
                if (((PessoaJuridica) celulaAtual.getDado()).getCnpj().equals(index)) {
                    if (celulaAnterior == null) {
                        this.primeiro = this.primeiro.getProximo();
                    } else {
                        celulaAnterior.setProximo(celulaAtual.getProximo());
                    }
                    this.tamanho--;
                    return;
                }
            } else if (identificador == 4) {
                if (((Aluguel) celulaAtual.getDado()).getPlacaVeiculo().equals(index)) {
                    if (celulaAnterior == null) {
                        this.primeiro = this.primeiro.getProximo();
                    } else {
                        celulaAnterior.setProximo(celulaAtual.getProximo());
                    }
                    this.tamanho--;
                    return;
                }
            }
            celulaAnterior = celulaAtual;
            celulaAtual = celulaAtual.getProximo();
        }
    }

    public boolean verificarItem(String index, int identificador) {
        Celula<T> celulaAtual = this.primeiro;

        while (celulaAtual != null) {
            if(identificador == 1) {
                if (((Veiculo) celulaAtual.getDado()).getPlaca().equals(index)) {
                    return true;
                }
            } else if (identificador == 2) {
                if (((PessoaFisica) celulaAtual.getDado()).getCpf().equals(index)) {
                    return true;
                }
            } else if (identificador == 3) {
                if (((PessoaJuridica) celulaAtual.getDado()).getCnpj().equals(index)) {
                    return true;
                }
            } else if (identificador == 4) {
                if (((Aluguel) celulaAtual.getDado()).getPlacaVeiculo().equals(index)) {
                    return true;
                }
            }
            celulaAtual = celulaAtual.getProximo();
        }
        return false;
    }



    @Override
    public Iterator<T> iterator() {
        return new ListaIterator();
    }


    private class ListaIterator implements Iterator<T> {
        private Celula<T> atual = primeiro;

        @Override
        public boolean hasNext() {
            return atual != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T dado = atual.getDado();
                atual = atual.getProximo();
                return dado;
            }
            throw new NoSuchElementException();
        }
    }
}
