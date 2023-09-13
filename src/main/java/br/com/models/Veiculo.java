package br.com.models;

import br.com.enums.TipoVeiculo;
import br.com.interfaces.EditVeiculo;
import br.com.interfaces.Pesquisar;
import br.com.interfaces.ValidadorVeiculo;
import br.com.list.ListaEncadeada;
import br.com.util.ConsoleUI;

public class Veiculo implements EditVeiculo, Pesquisar<Veiculo>, ValidadorVeiculo {

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

    @Override
    public void editarItem(ListaEncadeada<Veiculo> lista, String novaPlaca, String novoModelo, TipoVeiculo novoTipoVeiculo) {
        for (Veiculo veiculo : lista) {
            if (true) {
                veiculo.setPlaca(novaPlaca);
                veiculo.setModelo(novoModelo);
                veiculo.setTipoVeiculo(novoTipoVeiculo);
                break;
            } else {
                System.out.println(ConsoleUI.formatText("Veiculo não encontrado", "vermelho"));
            }
        }
    }

    @Override
    public boolean busca(ListaEncadeada<Veiculo> lista, String index) {
        for (Veiculo veiculo : lista) {
            if (veiculo.getPlaca().equals(index)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean validaPlaca(String placa) {
        boolean valido = true;
        if(placa.length() != 7){
            valido = false;
        }
        return valido;
    }
}
