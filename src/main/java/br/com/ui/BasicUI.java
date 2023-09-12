package br.com.ui;

public abstract class BasicUI {

    public BasicUI() {
    }

    public void show() {
        do {
            if (!menuOpcao()) {
                break;
            }
        } while (true);
    }

    public abstract boolean menuOpcao();
}
