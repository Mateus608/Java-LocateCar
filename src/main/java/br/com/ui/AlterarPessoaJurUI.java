package br.com.ui;

import br.com.list.ListaPessoaFis;
import br.com.list.ListaPessoaJur;;
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
        ListaPessoaJur.mostrarLista();
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
                if (pessoa.busca(ListaPessoaJur.lista, buscaCnpj)) {
                    System.out.println(ConsoleUI.formatText("Cliente encontrado... Prossiga com a edição", "amarelo"));
                    String nome = ConsoleUI.input("Informe o novo nome");
                    String nomeFantasia = ConsoleUI.input("Informe o novo nome fantasia");
                    String razaoSocial = ConsoleUI.input("Informe a nova razão social");
                    String endereco = ConsoleUI.input("Informe o novo endereço");
                    String contato = ConsoleUI.input("Informe o novo contato");
                    String cnpj = ConsoleUI.input("Informe o novo cnpj");

                    if (pessoa.validaTelefone(contato)) {
                        ConsoleUI.mensagemTemporizada(ConsoleUI.formatText("Só pode conter números no telefone", "vermelho"), 2);

                    }

                    if (!cnpj.equals(buscaCnpj)) {
                        if(!ListaPessoaJur.verificarCnpj(cnpj) && pessoa.validaPessoa(cnpj)) {
                            pessoa.editarPessoa(ListaPessoaJur.lista, nome, nomeFantasia, razaoSocial, endereco, contato, cnpj);
                        } else {
                            ConsoleUI.mensagemTemporizada(ConsoleUI.formatText("CPF digitado é inválido ou já existe!", "vermelho"), 2);
                        }
                    } else {
                        pessoa.editarPessoa(ListaPessoaJur.lista, nome, nomeFantasia, razaoSocial, endereco, contato, cnpj);
                    }

                    break;
                } else {
                    System.out.println(ConsoleUI.formatText("Cliente não encontrado!", "vermelho"));
                }
                return false;
            } case 1 : {
                String index = ConsoleUI.input("Digite o cnpj do cliente que deseja excluir");

                if (pessoa.busca(ListaPessoaJur.lista, index)) {
                    ListaPessoaJur.lista.excluirItem(index, 2);
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