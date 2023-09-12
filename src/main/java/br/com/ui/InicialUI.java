package br.com.ui;

import br.com.enums.TipoVeiculo;
import br.com.list.ListaEncadeada;
import br.com.models.Veiculo;
import br.com.util.ConsoleUI;

public class InicialUI extends BasicUI{

    public void superiorTela() {
        ConsoleUI coUI = new ConsoleUI();
        coUI.adicionarTitulo("Locate Car");

        ListaEncadeada printLista = new ListaEncadeada();
        printLista.mostrarLista(lista);

        coUI.ln();
    }
    public boolean menuOpcao() {

        int option = ConsoleUI.escolherOpcao(
                "Escolha uma opção",
                "Cadastrar Veiculo",
                "Cadastrar Cliente [Pessoa Fisica]",
                "Cadastrar Cliente [Pessoa Juridica]",
                "Alugar Veiculo",
                "Listar Clientes",
                "Pesquisar",
                "Sair");
        switch (option) {
            case 0: {
                Veiculo veiculo = new Veiculo();
                CadastroVeiculoUI ui = new CadastroVeiculoUI(veiculo);
                ui.show();
                break;
            }
            case 1: {
                BasicUI ui = new CadastroPessoaFisUI();
                ui.show();
                break;
            }
            case 2: {
                BasicUI ui = new CadastroPessoaFisUI();
                ui.show();
                break;
            }
            case 3: {
                BasicUI ui = new CadastroPessoaJurUI();
                ui.show();
                break;
            }
            case 4: {
                System.out.println("Você clicou");
                break;
            }
            case 5: {
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
