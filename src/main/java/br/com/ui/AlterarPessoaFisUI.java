package br.com.ui;

import br.com.list.ListaPessoaFis;
import br.com.list.ListaVeiculos;
import br.com.models.PessoaFisica;
import br.com.util.ConsoleUI;

public class AlterarPessoaFisUI extends BasicUI{

    private final PessoaFisica pessoa;

    public AlterarPessoaFisUI(PessoaFisica pessoa) {
        this.pessoa = pessoa;
    }
    @Override
    public void superiorTela() {
        ConsoleUI.adicionarTitulo("Alterar Cliente [Pessoa Fisica]");
        ListaPessoaFis.mostrarLista();
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
                if (pessoa.busca(ListaPessoaFis.lista, buscaCpf)) {
                    System.out.println(ConsoleUI.formatText("Cliente encontrado... Prossiga com a edição", "amarelo"));
                    String nome = ConsoleUI.input("Informe o novo nome");
                    String sobrenome = ConsoleUI.input("Informe o novo sobrenome");
                    String endereco = ConsoleUI.input("Informe o novo endereço");
                    String contato = ConsoleUI.input("Informe o novo contato");
                    String cpf = ConsoleUI.input("Informe o novo cpf");

                    if (pessoa.validaTelefone(contato)) {
                        ConsoleUI.mensagemTemporizada(ConsoleUI.formatText("Só pode conter números no telefone", "vermelho"), 2);

                    }

                    if (!cpf.equals(buscaCpf)) {
                        if(!ListaPessoaFis.verificarCpf(cpf) && pessoa.validaPessoa(cpf)) {
                            pessoa.editarPessoa(ListaPessoaFis.lista, nome, sobrenome, endereco, contato, cpf);
                        } else {
                            ConsoleUI.mensagemTemporizada(ConsoleUI.formatText("CPF digitado é inválido ou já existe!", "vermelho"), 2);
                        }
                    } else {
                        pessoa.editarPessoa(ListaPessoaFis.lista, nome, sobrenome, endereco, contato, cpf);
                    }
                } else {
                    System.out.println(ConsoleUI.formatText("Cliente não encontrado!", "vermelho"));
                }

                return false;
            } case 1 : {
                String index = ConsoleUI.input("Digite o cpf do cliente que deseja excluir");

                if (pessoa.busca(ListaPessoaFis.lista, index)) {
                    ListaPessoaFis.lista.excluirItem(index, 2);
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
    }
}