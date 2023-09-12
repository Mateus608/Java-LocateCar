package br.com;

import br.com.models.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class Controler {
    private List<Veiculo> veiculo;


    void cadastrarVeiculo(Veiculo veiculos) {
        veiculo.add(veiculos);
    }

    void removerVeiculo(Veiculo veiculos) {
        veiculo.remove(veiculos);
    }


    List<Veiculo> pesquisarVeiculo(String nome) {
        List<Veiculo> encotrados = new ArrayList<>();
        for (Veiculo veiculos : veiculo) {
            if (veiculos.getModelo().toLowerCase().contains(nome.toLowerCase())){
                encotrados.add(veiculos);
            }
        }
        return encotrados;
    }
}
