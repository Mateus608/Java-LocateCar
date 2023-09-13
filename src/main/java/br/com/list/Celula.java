package br.com.list;

public class Celula<T> {
    private Celula<T> proximo;
    private T dado;

    public Celula(Celula<T> proximo, T dado) {
        this.proximo = proximo;
        this.dado = dado;
    }

    public Celula(T dado) {
        this.dado = dado;
    }

    public Celula<T> getProximo() {
        return proximo;
    }

    public void setProximo(Celula<T> proximo) {
        this.proximo = proximo;
    }

    public T getDado() {
        return dado;
    }
}
