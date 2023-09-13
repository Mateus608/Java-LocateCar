package br.com.list;

import br.com.models.Veiculo;
import br.com.util.ConsoleUI;

import java.util.Iterator;
import java.util.NoSuchElementException;

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

    public void excluirItem(String index) {
        if (this.tamanho == 0) {
            return;
        }

        Celula<T> celulaAtual = this.primeiro;
        Celula<T> celulaAnterior = null;

        while (celulaAtual != null) {
            if (((Veiculo)celulaAtual.getDado()).getPlaca().equals(index)) {
                if (celulaAnterior == null) {
                    this.primeiro = this.primeiro.getProximo();
                } else {
                    celulaAnterior.setProximo(celulaAtual.getProximo());
                }
                this.tamanho--;
                return;
            }
            celulaAnterior = celulaAtual;
            celulaAtual = celulaAtual.getProximo();
        }
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
