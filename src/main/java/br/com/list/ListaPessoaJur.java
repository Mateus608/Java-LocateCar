package br.com.list;

public class ListaPessoaJur {
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

        lista.excluirItem(index, 3);
    }

    public static boolean verificarCnpj(String cnpj) {
        if (!lista.verificarItem(cnpj, 3)) {
            return false;
        } else {
            return true;
        }
    }
}
