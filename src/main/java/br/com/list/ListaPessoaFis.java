package br.com.list;

public class ListaPessoaFis {
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

        lista.excluirItem(index, 2);
    }

    public static boolean verificarCpf(String cpf) {
        if (!lista.verificarItem(cpf, 2)) {
            return false;
        } else {
            return true;
        }
    }
}
