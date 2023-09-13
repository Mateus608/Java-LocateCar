package br.com.ui;

import br.com.list.ListaPessoaFis;
import br.com.list.ListaPessoaJur;
import br.com.models.PessoaJuridica;
import br.com.util.ConsoleUI;

public class CadastroPessoaJurUI extends BasicUI{
    private final PessoaJuridica pessoa;

    public CadastroPessoaJurUI(PessoaJuridica pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public void superiorTela() {
        ConsoleUI.adicionarTitulo("Cadastrar Cliente[Pessoa Juridica]");
        System.out.println("Nome > " + pessoa.getNome());
        System.out.println("Nome Fantasia > " + pessoa.getNomeFantasia());
        System.out.println("Razão Social > " + pessoa.getRazaoSocial());
        System.out.println("Endereço > " + pessoa.getEndereco());
        System.out.println("Contato > " + pessoa.getContato());
        System.out.println("CNPJ > " + pessoa.getCnpj());
        ConsoleUI.ln();
    }

    @Override
    public boolean menuOpcao() {
        int option = ConsoleUI.escolherOpcao(
                "Escolha uma opção",
                "Informar Nome",
                "Informar Nome Fantasia",
                "Informar Razão Social",
                "Informar Endereço",
                "Informar Contato",
                "Informar CNPJ",
                "Salvar Alterações",
                "Cancelar");
        switch (option) {
            case 0: {
                String nome = ConsoleUI.input("Informe o nome");
                pessoa.setNome(nome);
                break;
            }
            case 1: {
                String nomeFantasia = ConsoleUI.input("Informe o nome fantasia");
                pessoa.setNomeFantasia(nomeFantasia);
                break;
            }
            case 2 : {
                String razaoSocial = ConsoleUI.input("Informe a razão social");
                pessoa.setRazaoSocial(razaoSocial);
                break;
            }
            case 3: {
                String endereco = ConsoleUI.input("Informe o endereço");
                pessoa.setEndereco(endereco);
                break;
            }
            case 4: {
                String contato = ConsoleUI.input("Informe o telefone para contato");
                if (!pessoa.validaTelefone(contato)) {
                    pessoa.setContato(contato);
                } else {
                    ConsoleUI.mensagemTemporizada(ConsoleUI.formatText("Só pode conter números no telefone", "vermelho"), 2);
                }
                break;
            }
            case 5: {
                String cnpj = ConsoleUI.input("Informe o CNPJ");
                if (!ListaPessoaFis.verificarCpf(cnpj) && pessoa.validaPessoa(cnpj)) {
                    pessoa.setCnpj(cnpj);
                } else {
                    ConsoleUI.mensagemTemporizada(ConsoleUI.formatText("CNPJ digitado é inválido ou já existe!", "vermelho"), 2);
                }
                break;
            }
            case 6 : {
                if (pessoa.getNome() == null || pessoa.getRazaoSocial() == null || pessoa.getEndereco() == null ||
                        pessoa.getContato() == null || pessoa.getCnpj() == null) {
                    ConsoleUI.mensagemTemporizada(ConsoleUI.formatText("Ainda existem campos que precisam ser preenchidos", "Amarelo"),2);
                    break;
                } else {
                    ConsoleUI.mensagemTemporizada(ConsoleUI.formatText("Cadastro salvo com sucesso!", "verde"),3);
                    ListaPessoaJur.adicionarItem(pessoa);
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
