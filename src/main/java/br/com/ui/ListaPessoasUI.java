package br.com.ui;

import br.com.list.ListaPessoaFis;
import br.com.list.ListaPessoaJur;
import br.com.models.PessoaFisica;
import br.com.models.PessoaJuridica;
import br.com.util.ConsoleUI;

public class ListaPessoasUI extends BasicUI{
    @Override
    public void superiorTela() {
        ConsoleUI.adicionarTitulo("Lista Clientes [Pessoa Juridica]");
        ListaPessoaJur.mostrarLista();
        ConsoleUI.ln();
        ConsoleUI.adicionarTitulo("Lista Clientes [Pessoa Fisica]");
        ListaPessoaFis.mostrarLista();
        ConsoleUI.ln();
    }

    @Override
    public boolean menuOpcao() {
        int option = ConsoleUI.escolherOpcao(
                "Escolha uma opção",
                "Editar/Excluir Cliente [Pessoa Fisica]",
                "Editar/Excluir Cliente [Pessoa Juridica]",
                "Voltar");
        switch (option) {
            case 0 : {
                PessoaFisica pessoa = new PessoaFisica();
                AlterarPessoaFisUI ui = new AlterarPessoaFisUI(pessoa);
                ui.show();
                break;
            } case 1 : {
                PessoaJuridica pessoa = new PessoaJuridica();
                AlterarPessoaJurUI ui = new AlterarPessoaJurUI(pessoa);
                ui.show();
                break;
            }
            default: {
                return false;
            }
        }
        return true;
    }
}
