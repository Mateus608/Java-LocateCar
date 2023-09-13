package br.com.ui;

import br.com.list.ListaVeiculos;
import br.com.util.ConsoleUI;

public class AlugarVeiculoUI extends BasicUI{

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

                break;
            }
            default: {
                return false;
            }
        }
        return true;
    }
}
