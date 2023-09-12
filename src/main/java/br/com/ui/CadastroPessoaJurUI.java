package br.com.ui;

import br.com.util.ConsoleUI;

public class CadastroPessoaJurUI extends BasicUI{
    @Override
    public void superiorTela() {

    }

    @Override
    public boolean menuOpcao() {
        int option = ConsoleUI.escolherOpcao(
                "Escolha uma opção",
                "Informar Nome",
                "Informar Razão Social",
                "Informar Nome Fantasia",
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
            case 4: {
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
