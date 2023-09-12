package br.com.ui;

import br.com.enums.TipoVeiculo;
import br.com.list.ListaGlobal;
import br.com.models.Veiculo;
import br.com.util.ConsoleUI;

public class CadastroVeiculoUI extends BasicUI{
    private final Veiculo veiculo;

    public CadastroVeiculoUI(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public void superiorTela() {
        ConsoleUI.adicionarTitulo("Cadastrar Veiculo");
        System.out.println("Placa > " + veiculo.getPlaca());
        System.out.println("Modelo > " + veiculo.getModelo());
        System.out.println("Tipo do veiculo > " + veiculo.getTipoVeiculo());
        ConsoleUI.ln();
    }

    @Override
    public boolean menuOpcao() {
        int option = ConsoleUI.escolherOpcao(
                "Escolha uma opção",
                "Informar Placa",
                "Informar Modelo",
                "Informar Tipo do Veiculo",
                "Salvar Alterações",
                "Sair");
        switch (option) {
            case 0: {
                String placa = ConsoleUI.input("Informe a placa do veiculo");
                veiculo.setPlaca(placa);
                break;
            }
            case 1: {
                String modelo = ConsoleUI.input("Informe o modelo do veiculo");
                veiculo.setModelo(modelo);
                break;
            }
            case 2: {
                String tipoStr = ConsoleUI.input("Informe o tipo do veiculo: 1 > PEQUENO, 2 > MEDIO, 3 > SUV");
                int tipoInt = Integer.parseInt(tipoStr);
                if(tipoInt == 1) {
                    veiculo.setTipoVeiculo(TipoVeiculo.PEQUENO);
                } else if (tipoInt == 2) {
                    veiculo.setTipoVeiculo(TipoVeiculo.MEDIO);
                } else if (tipoInt == 3){
                    veiculo.setTipoVeiculo(TipoVeiculo.SUV);
                } else {
                    System.out.println("Valor digitado inválido!");
                }
                break;
            }
            case 3: {
                if (veiculo.getModelo() == null || veiculo.getPlaca() == null || veiculo.getTipoVeiculo() == null) {
                    ConsoleUI.mensagemTemporizada(ConsoleUI.formatText("Ainda existem campos vazios", "Amarelo"),3);
                    break;
                } else {
                    ConsoleUI.mensagemTemporizada(ConsoleUI.formatText("Cadastro salvo com sucesso!", "verde"),5);
                    ListaGlobal.adicionarItem(veiculo);
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
