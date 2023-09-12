package br.com.ui;

import br.com.enums.TipoVeiculo;
import br.com.models.Veiculo;
import br.com.util.ConsoleUI;

public class CadastroVeiculoUI extends BasicUI{
    private final Veiculo veiculo;

    public CadastroVeiculoUI(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public void superiorTela() {
        ConsoleUI coUI = new ConsoleUI();
        coUI.adicionarTitulo("Cadastrar Veiculo");
        System.out.println("Placa > " + veiculo.getPlaca());
        System.out.println("Modelo > " + veiculo.getModelo());
        System.out.println("Tipo do veiculo > " + veiculo.getTipoVeiculo());
        coUI.ln();
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
                }
                break;
            }
            case 3: {
                ConsoleUI.mensagemTemporizada("Cadastro salvo com sucesso!",5);
                lista(veiculo);
                break;
            }
            default: {
                return false;
            }
        }
        return true;
    }

    protected void newItem() {
        Veiculo newVeiculo = new Veiculo();
        newVeiculo.setTipoVeiculo(TipoVeiculo.PEQUENO);
        CadastroVeiculoUI ui = new CadastroVeiculoUI(newVeiculo);
        ui.show();
    }
}
