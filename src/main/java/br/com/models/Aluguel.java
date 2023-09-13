package br.com.models;

import br.com.enums.TipoMovimentacao;
import br.com.enums.TipoPessoa;
import br.com.enums.TipoVeiculo;
import br.com.interfaces.Pagamento;

import java.time.LocalDateTime;

public class Aluguel implements Pagamento {
    private LocalDateTime dateTime;
    private String placaVeiculo;
    private String documentoPessoa;
    private Double valorAluguel;

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getDocumentoPessoa() {
        return documentoPessoa;
    }

    public void setDocumentoPessoa(String documentoPessoa) {
        this.documentoPessoa = documentoPessoa;
    }

    private Double valorDesconto;
    private TipoMovimentacao tipoMovimentacao;
    private TipoPessoa tipoPessoa;
    private TipoVeiculo tipoVeiculo;

    public Double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(Double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    @Override
    public void precoAluguel(TipoVeiculo tipo) {

        if (tipoVeiculo.equals(TipoVeiculo.PEQUENO)) {
            valorAluguel = 100.00;
        } else if (tipoVeiculo.equals(TipoVeiculo.MEDIO)) {
            valorAluguel = 150.00;
        } else if (tipoVeiculo.equals(TipoVeiculo.SUV)) {
            valorAluguel = 200.00;
        }
    }

    @Override
    public void descontoPessoa(TipoPessoa tipo) {

        if (tipoPessoa.equals(TipoPessoa.FISICA)) {
            valorDesconto = 0.05;
        } else if (tipoPessoa.equals(TipoPessoa.JURIDICA)) {
            valorDesconto = 0.10;
        }

    }
}
