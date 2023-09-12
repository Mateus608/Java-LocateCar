package br.com.models;

import br.com.enums.TipoVeiculo;
import br.com.util.ConsoleUI;

public class Veiculo {

    private String placa;
    private String modelo;
    private TipoVeiculo tipoVeiculo;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + " | Modelo: " + modelo + " | Tipo: " + tipoVeiculo;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }
}
