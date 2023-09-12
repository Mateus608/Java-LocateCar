package br.com.ui;

import br.com.list.ListaEncadeada;

public abstract class BasicUI {

    public BasicUI() {
    }

    public void show() {
        do {
            superiorTela();
            if (!menuOpcao()) {
                break;
            }
        } while (true);
    }

    public ListaEncadeada lista(Object item) {
        ListaEncadeada lista = new ListaEncadeada();
        lista.adicionarFim(item);
        return lista;
    }
    public abstract void superiorTela();
    public abstract boolean menuOpcao();
}
