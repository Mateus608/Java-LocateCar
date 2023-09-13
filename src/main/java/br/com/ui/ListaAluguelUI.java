package br.com.ui;

import br.com.list.ListaAluguel;
import br.com.list.ListaVeiculos;
import br.com.util.ConsoleUI;

public class ListaAluguelUI extends BasicUI{
    @Override
    public void superiorTela() {
        ConsoleUI.adicionarTitulo("Lista Alugueis");
        ListaAluguel.mostrarLista();
        ConsoleUI.ln();
    }

    @Override
    public boolean menuOpcao() {
        int option = ConsoleUI.escolherOpcao(
                "Escolha uma opção",
                "Excluir Aluguel",
                "Realizar Devolução",
                "Voltar");
        switch (option) {
            case 0: {

                break;
            } default: {
                return false;
            }
        }
        return true;
    }
}
