package br.com.ui;

import br.com.list.ListaVeiculos;
import br.com.models.Aluguel;
import br.com.models.PessoaFisica;
import br.com.models.PessoaJuridica;
import br.com.models.Veiculo;
import br.com.util.ConsoleUI;

public class AlugarVeiculoUI extends BasicUI{

    private final Aluguel aluguel;
    private final Veiculo veiculo;
    private final PessoaFisica pessoaFis;
    private final PessoaJuridica pessoaJur;

    public AlugarVeiculoUI(Aluguel aluguel, Veiculo veiculo, PessoaFisica pessoaFis, PessoaJuridica pessoaJur) {
        this.aluguel = aluguel;
        this.veiculo = veiculo;
        this.pessoaFis = pessoaFis;
        this.pessoaJur = pessoaJur;
    }


    @Override
    public void superiorTela() {

    }

    @Override
    public boolean menuOpcao() {
        int option = ConsoleUI.escolherOpcao(
                "Escolha uma opção",
                "Informar Placa do Veiculo",
                "Informar Tipo do Veiculo",
                "Informar Tipo Pessoa",
                "Informar CPF/CNPJ",
                "Salvar Alterações",
                "Cancelar");
        switch (option) {
            case 0: {
                String placa = ConsoleUI.input("Informe a placa do veiculo");
                if (!ListaVeiculos.verificarPlaca(placa) && veiculo.validaPlaca(placa)) {
                    aluguel.setPlacaVeiculo(placa);
                } else {
                    ConsoleUI.mensagemTemporizada(ConsoleUI.formatText("Placa digitada é inválida ou não existe!", "vermelho"), 2);
                }
                break;
            }
            default: {
                return false;
            }
        }
        return true;
    }
}
