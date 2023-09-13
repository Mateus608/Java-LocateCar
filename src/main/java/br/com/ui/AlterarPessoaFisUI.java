package br.com.ui;

import br.com.enums.TipoVeiculo;
import br.com.list.ListaPessoas;
import br.com.list.ListaVeiculos;
import br.com.models.PessoaFisica;
import br.com.models.Veiculo;
import br.com.util.ConsoleUI;

public class AlterarPessoaFisUI extends BasicUI{

    private final PessoaFisica pessoa;

    public AlterarPessoaFisUI(PessoaFisica pessoa) {
        this.pessoa = pessoa;
    }
    @Override
    public void superiorTela() {
        ConsoleUI.adicionarTitulo("Alterar Cliente [Pessoa Fisica]");
        ConsoleUI.ln();
    }

    @Override
    public boolean menuOpcao() {
        int option = ConsoleUI.escolherOpcao(
                "Escolha uma opção",
                "Editar Cliente",
                "Excluir Cliente",
                "Voltar");
        switch (option) {
            case 0: {
                String buscaCpf = ConsoleUI.input("Digite o CPF do cliente que deseja editar");
                if (pessoa.busca(ListaPessoas.lista, buscaCpf)) {
                    System.out.println(ConsoleUI.formatText("Cliente encontrado... Prossiga com a edição", "amarelo"));
                    String nome = ConsoleUI.input("Informe o novo nome");
                    String sobrenome = ConsoleUI.input("Informe o novo sobrenome");
                    String endereco = ConsoleUI.input("Informe o novo endereço");
                    String contato = ConsoleUI.input("Informe o novo contato");
                    String cpf = ConsoleUI.input("Informe o novo cpf");
                    pessoa.editarPessoa(ListaPessoas.lista, nome, sobrenome, endereco, contato, cpf);
                    break;
                } else {
                    System.out.println(ConsoleUI.formatText("Cliente não encontrado!", "vermelho"));
                }
                return false;
            } case 1 : {
                String index = ConsoleUI.input("Digite o cpf do cliente que deseja excluir");

                if (pessoa.busca(ListaPessoas.lista, index)) {
                    ListaPessoas.lista.excluirItem(index);
                    ConsoleUI.mensagemTemporizada(ConsoleUI.formatText("Cliente excluído com sucesso!", "verde"), 3);
                } else {
                    System.out.println(ConsoleUI.formatText("Cliente não encontrado!", "vermelho"));
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