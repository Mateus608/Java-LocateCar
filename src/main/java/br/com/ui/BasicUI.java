package br.com.ui;

import br.com.list.ListaEncadeada;
import br.com.list.ListaGlobal;
import br.com.util.ConsoleUI;

public abstract class BasicUI {

    public BasicUI() {
    }

    ListaEncadeada lista = new ListaEncadeada();

    public void show() {
        do {
            superiorTela();
            if (!menuOpcao()) {
                break;
            }
        } while (true);
    }

    public abstract void superiorTela();
    public abstract boolean menuOpcao();
}
