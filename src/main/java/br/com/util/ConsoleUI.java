package br.com.util;

import br.com.enums.TipoVeiculo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {
    public static void imprimir (String placa, String modelo, TipoVeiculo tipoVeiculo){
        System.out.println("Placa: " + placa + " | Modelo: " + modelo + " | Tipo: " + tipoVeiculo);
    }

    public static int escolherOpcao(String message, String... options) {
        System.out.printf("%s%n# : ", message);
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d - %s%n# : ", i, options[i]);
        }
        Scanner sc = new Scanner(System.in);
        int choose;
        do {
            try {
                choose = sc.nextInt();
            } catch (InputMismatchException e) {
                choose = -9;
            }
        } while (choose < 0 || choose >= options.length);
        return choose;
    }
}
