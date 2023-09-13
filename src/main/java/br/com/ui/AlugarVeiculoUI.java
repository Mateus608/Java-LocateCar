package br.com.ui;

import br.com.enums.TipoMovimentacao;
import br.com.enums.TipoPessoa;
import br.com.enums.TipoVeiculo;
import br.com.list.ListaAluguel;
import br.com.list.ListaVeiculos;
import br.com.models.Aluguel;
import br.com.util.ConsoleUI;

import java.time.LocalDateTime;

public class AlugarVeiculoUI extends BasicUI{

    private final Aluguel aluguel;

    public AlugarVeiculoUI(Aluguel aluguel) {
        this.aluguel = aluguel;
    }


    @Override
    public void superiorTela() {
        ConsoleUI.adicionarTitulo("Alugar Veiculo");
        System.out.println("Placa > " + aluguel.getPlacaVeiculo());
        System.out.println("Tipo do veiculo > " + aluguel.getTipoVeiculo());
        System.out.println("Tipo da pessoa > " + aluguel.getTipoPessoa());
        System.out.println("CPF/CNPJ > " + aluguel.getDocumentoPessoa());
        System.out.println("Valor aluguel > " + aluguel.getValorAluguel());

        ConsoleUI.ln();
    }

    @Override
    public boolean menuOpcao() {
        int option = ConsoleUI.escolherOpcao(
                "Escolha uma opção",
                "Informar Placa do Veiculo",
                "Informar Tipo do Veiculo",
                "Informar Tipo Pessoa",
                "Informar CPF/CNPJ",
                "Alugar Veiculo",
                "Cancelar");
        switch (option) {
            case 0: {
                String placa = ConsoleUI.input("Informe a placa do veiculo");
                if (ListaVeiculos.verificarPlaca(placa)) {
                    aluguel.setPlacaVeiculo(placa);
                } else {
                    ConsoleUI.mensagemTemporizada(ConsoleUI.formatText("Placa digitada é inválida ou não existe!", "vermelho"), 2);
                }
                break;
            } case 1 : {
                String tipoStr = ConsoleUI.input("Informe o tipo do veiculo: 1 > PEQUENO, 2 > MEDIO, 3 > SUV");
                int tipoInt = Integer.parseInt(tipoStr);
                if(tipoInt == 1) {
                    aluguel.setTipoVeiculo(TipoVeiculo.PEQUENO);
                    aluguel.precoAluguel(TipoVeiculo.PEQUENO);
                } else if (tipoInt == 2) {
                    aluguel.setTipoVeiculo(TipoVeiculo.MEDIO);
                    aluguel.precoAluguel(TipoVeiculo.MEDIO);
                } else if (tipoInt == 3){
                    aluguel.setTipoVeiculo(TipoVeiculo.SUV);
                    aluguel.precoAluguel(TipoVeiculo.SUV);

                } else {
                    System.out.println("Valor digitado inválido!");
                }
                break;
            } case 2 : {
                String tipoStr = ConsoleUI.input("Informe o tipo pessoa: 1 > FISICA, 2 > JURIDICA");
                int tipoInt = Integer.parseInt(tipoStr);
                if(tipoInt == 1) {
                    aluguel.setTipoPessoa(TipoPessoa.FISICA);
                } else if (tipoInt == 2) {
                    aluguel.setTipoPessoa(TipoPessoa.JURIDICA);
                } else {
                    System.out.println("Valor digitado inválido!");
                }
                break;
            } case 3 : {
                if (aluguel.getTipoPessoa().equals(TipoPessoa.FISICA)) {
                    String cpf = ConsoleUI.input("Informe o CPF do cliente");
                    aluguel.setDocumentoPessoa(cpf);
                } else if (aluguel.getTipoPessoa().equals(TipoPessoa.JURIDICA)) {
                    String cnpj = ConsoleUI.input("Informe o CNPJ do cliente");
                    aluguel.setDocumentoPessoa(cnpj);
                }
                break;
            } case 4 : {
                if (aluguel.getPlacaVeiculo() == null || aluguel.getTipoVeiculo() == null || aluguel.getTipoPessoa() == null || aluguel.getDocumentoPessoa() == null) {
                    ConsoleUI.mensagemTemporizada(ConsoleUI.formatText("Ainda existem campos vazios", "amarelo"),2);
                    break;
                } else {
                    ConsoleUI.mensagemTemporizada(ConsoleUI.formatText("Aluguel realizado com sucesso!", "verde"),3);
                    aluguel.setDateTime(LocalDateTime.now());
                    aluguel.setTipoMovimentacao(TipoMovimentacao.RETIRADA);
                    ListaAluguel.adicionarItem(aluguel);
                    return false;
                }
            }
            default: {
                return false;
            }
        }
        return true;
    }
}
