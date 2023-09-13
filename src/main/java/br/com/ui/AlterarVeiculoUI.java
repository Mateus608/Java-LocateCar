package br.com.ui;

import br.com.enums.TipoVeiculo;
import br.com.list.ListaGlobal;
import br.com.models.Veiculo;
import br.com.util.ConsoleUI;

public class AlterarVeiculoUI extends BasicUI{
    private final Veiculo veiculo;

    public AlterarVeiculoUI(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public void superiorTela() {
        ConsoleUI.adicionarTitulo("Alterar Veiculo");
        ConsoleUI.ln();
    }

    @Override
    public boolean menuOpcao() {
        int option = ConsoleUI.escolherOpcao(
                "Escolha uma opção",
                "Editar Veiculo",
                "Excluir Veiculo",
                "Voltar");
        switch (option) {
            case 0: {
                String placa = ConsoleUI.input("Digite a placa do veiculo que deseja exluir");
                if (veiculo.busca(ListaGlobal.lista, placa)) {
                    System.out.println(ConsoleUI.formatText("Veiculo encontrado... Prossiga com a edição", "amarelo"));
                    String modelo = ConsoleUI.input("Informe o novo modelo");
                    String tipoStr = ConsoleUI.input("Informe o novo tipo do veiculo: 1 > PEQUENO, 2 > MEDIO, 3 > SUV");
                    int tipoInt = Integer.parseInt(tipoStr);
                    TipoVeiculo tipo = TipoVeiculo.PEQUENO;
                    if (tipoInt == 1) {
                        veiculo.setTipoVeiculo(TipoVeiculo.PEQUENO);
                        tipo = TipoVeiculo.PEQUENO;
                    } else if (tipoInt == 2) {
                        veiculo.setTipoVeiculo(TipoVeiculo.MEDIO);
                        tipo = TipoVeiculo.PEQUENO;
                    } else if (tipoInt == 3) {
                        veiculo.setTipoVeiculo(TipoVeiculo.SUV);
                        tipo = TipoVeiculo.PEQUENO;
                    } else {
                        System.out.println("Valor digitado inválido!");
                    }
                    veiculo.editarItem(ListaGlobal.lista, placa, modelo, tipo);
                    break;
                } else {
                    System.out.println(ConsoleUI.formatText("Veículo não encontrado!", "vermelho"));
                }
                return false;
            }
            case 1: {
                String index = ConsoleUI.input("Digite a placa do veículo que deseja excluir");

                if (veiculo.busca(ListaGlobal.lista, index)) {
                    ListaGlobal.lista.excluirItem(index);
                    ConsoleUI.mensagemTemporizada(ConsoleUI.formatText("Veículo excluído com sucesso!", "verde"), 5);
                } else {
                    System.out.println(ConsoleUI.formatText("Veículo não encontrado!", "vermelho"));
                }
                return false;
            }

                default: {
                    return false;
                }
            }
            return true;
        }
}

