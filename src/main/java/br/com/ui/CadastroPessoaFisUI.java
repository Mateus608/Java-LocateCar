package br.com.ui;

import br.com.util.ConsoleUI;

public class CadastroPessoaFisUI extends BasicUI{
    @Override
    public void superiorTela() {

    }

    @Override
    public boolean menuOpcao() {
        int option = ConsoleUI.escolherOpcao(
                "Escolha uma opção",
                "Informar Nome",
                "Informar Sobrenome",
                "Informar Endereço",
                "Informar Contato",
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
