package br.com.ui;

import br.com.list.ListaPessoaFis;
import br.com.models.PessoaFisica;
import br.com.util.ConsoleUI;

public class CadastroPessoaFisUI extends BasicUI{
    private final PessoaFisica pessoa;

    public CadastroPessoaFisUI(PessoaFisica pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public void superiorTela() {
        ConsoleUI.adicionarTitulo("Cadastrar Cliente[Pessoa Fisica]");
        System.out.println("Nome > " + pessoa.getNome());
        System.out.println("Sobrenome > " + pessoa.getSobrenome());
        System.out.println("Endereço > " + pessoa.getEndereco());
        System.out.println("Contato > " + pessoa.getContato());
        System.out.println("CPF > " + pessoa.getCpf());
        ConsoleUI.ln();
    }

    @Override
    public boolean menuOpcao() {
        int option = ConsoleUI.escolherOpcao(
                "Escolha uma opção",
                "Informar Nome",
                "Informar Sobrenome",
                "Informar Endereço",
                "Informar Contato",
                "Informar CPF",
                "Salvar Alterações",
                "Cancelar");
        switch (option) {
            case 0: {
                String nome = ConsoleUI.input("Informe o nome");
                pessoa.setNome(nome);
                break;
            }
            case 1: {
                String sobrenome = ConsoleUI.input("Informe o sobrenome");
                pessoa.setSobrenome(sobrenome);
                break;
            }
            case 2: {
                String endereco = ConsoleUI.input("Informe o endereço");
                pessoa.setEndereco(endereco);
                break;
            }
            case 3: {
                String contato = ConsoleUI.input("Informe o telefone para contato");
                if (!pessoa.validaTelefone(contato)) {
                    pessoa.setContato(contato);
                } else {
                    ConsoleUI.mensagemTemporizada(ConsoleUI.formatText("Só pode conter números no telefone", "vermelho"), 2);
                }
                break;
            }
            case 4: {
                String cpf = ConsoleUI.input("Informe o CPF");
                if (!ListaPessoaFis.verificarCpf(cpf) && pessoa.validaPessoa(cpf)) {
                    pessoa.setCpf(cpf);
                } else {
                    ConsoleUI.mensagemTemporizada(ConsoleUI.formatText("CNPJ digitado é inválido ou já existe!", "vermelho"), 2);
                }
                break;
            }
            case 5 : {
                if (pessoa.getNome() == null || pessoa.getSobrenome() == null || pessoa.getEndereco() == null ||
                        pessoa.getContato() == null || pessoa.getCpf() == null) {
                    ConsoleUI.mensagemTemporizada(ConsoleUI.formatText("Ainda existem campos vazios", "Amarelo"),2);
                    break;
                } else {
                    ConsoleUI.mensagemTemporizada(ConsoleUI.formatText("Cadastro salvo com sucesso!", "verde"),3);
                    ListaPessoaFis.adicionarItem(pessoa);
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
