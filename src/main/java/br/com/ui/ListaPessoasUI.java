package br.com.ui;

import br.com.list.ListaPessoas;
import br.com.models.PessoaFisica;
import br.com.models.PessoaJuridica;
import br.com.util.ConsoleUI;

public class ListaPessoasUI extends BasicUI{
    @Override
    public void superiorTela() {
        ConsoleUI.adicionarTitulo("Alterar Clientes");

        PessoaFisica pessoa1 = new PessoaFisica();
        pessoa1.setNome("Mateus");
        pessoa1.setSobrenome("Milane");
        pessoa1.setEndereco("Rua teste, 21");
        pessoa1.setContato("1999999999");
        pessoa1.setCpf("555");
        ListaPessoas.adicionarItem(pessoa1);

        PessoaJuridica pessoa2 = new PessoaJuridica();
        pessoa2.setNome("Sistemas Ltda");
        pessoa2.setNomeFantasia("Sistemas");
        pessoa2.setRazaoSocial("Grup");
        pessoa2.setEndereco("Rua teste, 34");
        pessoa2.setContato("19998886545");
        pessoa2.setCnpj("100");
        ListaPessoas.adicionarItem(pessoa2);

        ListaPessoas.mostrarLista();
        ConsoleUI.ln();
    }

    @Override
    public boolean menuOpcao() {
        int option = ConsoleUI.escolherOpcao(
                "Escolha uma opção",
                "Editar/Excluir Cliente [Pessoa Fisica]",
                "Editar/Excluir Cliente [Pessoa Juridica]",
                "Voltar");
        switch (option) {
            case 0 : {
                PessoaFisica pessoa = new PessoaFisica();
                AlterarPessoaFisUI ui = new AlterarPessoaFisUI(pessoa);
                ui.show();
                break;
            } case 1 : {
                PessoaJuridica pessoa = new PessoaJuridica();
                AlterarPessoaJurUI ui = new AlterarPessoaJurUI(pessoa);
                ui.show();
                break;
            }
            default: {
                return false;
            }
        }
        return true;
    }
}
