package br.com.list;

public class ListaAluguel {
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

        lista.excluirItem(index, 4);
    }

    public static boolean verificarVeiculo(String placa) {
        if (!lista.verificarItem(placa, 4)) {
            return false;
        } else {
            return true;
        }
    }
}
