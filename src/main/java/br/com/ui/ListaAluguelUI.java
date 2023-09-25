package br.com.ui;

import br.com.list.ListaAluguel;
import br.com.list.ListaPessoaFis;
import br.com.models.Aluguel;
import br.com.models.PessoaFisica;
import br.com.util.ConsoleUI;

public class ListaAluguelUI extends BasicUI{

    private final Aluguel aluguel;

    public ListaAluguelUI(Aluguel aluguel) {
        this.aluguel = aluguel;
    }
    @Override
    public void superiorTela() {
        ConsoleUI.adicionarTitulo("Lista Alugueis");
        ListaAluguel.mostrarLista();
        ConsoleUI.ln();
    }

    @Override
    public boolean menuOpcao() {
        int option = ConsoleUI.escolherOpcao(
                "Escolha uma opção",
                "Excluir Aluguel",
                "Realizar Devolução",
                "Voltar");
        switch (option) {
            case 0 : {
                String index = ConsoleUI.input("Digite a placa do veiculo alugado que deseja excluir");

                if (aluguel.busca(ListaAluguel.lista, index)) {
                    ListaAluguel.lista.excluirItem(index, 4);
                    ConsoleUI.mensagemTemporizada(ConsoleUI.formatText("Aluguel excluído com sucesso!", "verde"), 3);
                } else {
                    System.out.println(ConsoleUI.formatText("Aluguel não encontrado!", "vermelho"));
                }
                break;
            } case 1 : {
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
