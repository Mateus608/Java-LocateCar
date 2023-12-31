package br.com.list;

public class ListaVeiculos {
    public static ListaEncadeada lista = new ListaEncadeada();

    public static ListaEncadeada getLista() {
        return lista;
    }

    public static void adicionarItem(Object item) {
        lista.adicionarFim(item);
    }

    public static void mostrarLista() {
        lista.mostrarLista();
    }
    public static void excluirItemLista(String index) {

        lista.excluirItem(index, 1);
    }
    public static boolean verificarPlaca(String placa) {
        if (!lista.verificarItem(placa, 1)) {
            return false;
        } else {
            return true;
        }
    }
}
