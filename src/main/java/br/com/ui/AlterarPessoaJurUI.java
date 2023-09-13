package br.com.ui;

import br.com.list.ListaPessoas;;
import br.com.models.PessoaJuridica;
import br.com.util.ConsoleUI;

public class AlterarPessoaJurUI extends BasicUI{

    private final PessoaJuridica pessoa;

    public AlterarPessoaJurUI(PessoaJuridica pessoa) {
        this.pessoa = pessoa;
    }
    @Override
    public void superiorTela() {
        ConsoleUI.adicionarTitulo("Alterar Cliente [Pessoa Juridica]");
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
                String buscaCnpj = ConsoleUI.input("Digite o CNPJ do cliente que deseja editar");
                if (pessoa.busca(ListaPessoas.lista, buscaCnpj)) {
                    System.out.println(ConsoleUI.formatText("Cliente encontrado... Prossiga com a edição", "amarelo"));
                    String nome = ConsoleUI.input("Informe o novo nome");
                    String nomeFantasia = ConsoleUI.input("Informe o novo nome fantasia");
                    String razaoSocial = ConsoleUI.input("Informe a nova razão social");
                    String endereco = ConsoleUI.input("Informe o novo endereço");
                    String contato = ConsoleUI.input("Informe o novo contato");
                    String cnpj = ConsoleUI.input("Informe o novo cnpj");
                    pessoa.editarPessoa(ListaPessoas.lista, nome, nomeFantasia, razaoSocial, endereco, contato, cnpj);
                    break;
                } else {
                    System.out.println(ConsoleUI.formatText("Cliente não encontrado!", "vermelho"));
                }
                return false;
            } case 1 : {
                String index = ConsoleUI.input("Digite o cnpj do cliente que deseja excluir");

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