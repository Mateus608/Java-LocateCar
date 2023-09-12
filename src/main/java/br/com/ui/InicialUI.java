package br.com.ui;

import br.com.util.ConsoleUI;

public class InicialUI extends BasicUI{
    public boolean menuOpcao() {
        int option = ConsoleUI.escolherOpcao(
                "Escolha uma opção",
                "Adicionar Veiculo",
                "Adicionar Cliente",
                "Alugar Veiculo",
                "Pesquisar",
                "Sair");
        switch (option) {
            case 0: {
                System.out.println("Você clicou");
                break;
            }
            case 1: {
                System.out.println("Você clicou");
                break;
            }
            case 2: {
                System.out.println("Você clicou");
                break;
            }
            case 3: {
                System.out.println("Você clicou");
                break;
            }
            default: {
                return false;
            }
        }
        return true;
    }
}
