package br.com.ui;

import br.com.enums.TipoVeiculo;
import br.com.list.ListaAluguel;
import br.com.list.ListaVeiculos;
import br.com.models.Aluguel;
import br.com.models.PessoaFisica;
import br.com.models.PessoaJuridica;
import br.com.models.Veiculo;
import br.com.util.ConsoleUI;

public class InicialUI extends BasicUI{

    public void superiorTela() {

        ConsoleUI.adicionarTitulo("Locate Car");
        ListaVeiculos.mostrarLista();
        ConsoleUI.ln();
    }
    public boolean menuOpcao() {

        int option = ConsoleUI.escolherOpcao(
                "Escolha uma opção",
                "Cadastrar Veiculo",
                "Editar Veiculo",
                "Cadastrar Cliente [Pessoa Fisica]",
                "Cadastrar Cliente [Pessoa Juridica]",
                "Listar Clientes",
                "Alugar Veiculo",
                "Carros Alugados",
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
                Veiculo veiculo = new Veiculo();
                AlterarVeiculoUI ui = new AlterarVeiculoUI(veiculo);
                ui.show();
                break;
            }
            case 2: {
                PessoaFisica pessoa = new PessoaFisica();
                CadastroPessoaFisUI ui = new CadastroPessoaFisUI(pessoa);
                ui.show();
                break;
            }
            case 3: {
                PessoaJuridica pessoa = new PessoaJuridica();
                CadastroPessoaJurUI ui = new CadastroPessoaJurUI(pessoa);
                ui.show();
                break;
            }
            case 4: {
                ListaPessoasUI ui = new ListaPessoasUI();
                ui.show();
                break;
            }
            case 5: {
                Aluguel aluguel = new Aluguel();
                AlugarVeiculoUI ui = new AlugarVeiculoUI(aluguel);
                ui.show();
                break;
            }
            case 6 : {
                ListaAluguelUI ui = new ListaAluguelUI();
                ui.show();
                break;
            }
            case 7: {
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
