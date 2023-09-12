package br.com.list;

public class Celula {
    private Celula proximo;
    private Object dado;

    public Celula(Celula proximo, Object dado) {
        this.proximo = proximo;
        this.dado = dado;
    }

    public Celula(Object dado){
        this.dado = dado;
    }

    public Celula getProximo() {
        return proximo;
    }

    public void setProximo(Celula proximo) {
        this.proximo = proximo;
    }

    public Object getDado() {
        return dado;
    }
}
