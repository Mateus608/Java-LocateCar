package br.com.interfaces;

import br.com.enums.TipoPessoa;
import br.com.enums.TipoVeiculo;

public interface Pagamento {
    void precoAluguel(TipoVeiculo tipo);
    void descontoPessoa(TipoPessoa tipo);
}
