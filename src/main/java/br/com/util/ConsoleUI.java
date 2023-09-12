package br.com.util;

import br.com.enums.TipoVeiculo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {

    public static void adicionarTitulo(String titulo) {
        System.out.println("");
        System.out.println(titulo.toUpperCase());
        System.out.println("");
    }

    public static int escolherOpcao(String messagem, String... options) {
        System.out.printf("%s%n# : ", messagem);
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

    public static boolean confirmarOpcao(String message, String yes, String no) {
        String[] op = new String[2];
        op[0] = yes;
        op[1] = no;
        return escolherOpcao(message, yes, no) == 0;
    }

    public static String input(String messagem) {
        System.out.printf("%s%n# : ", messagem);
        return new Scanner(System.in).nextLine().trim();
    }

    public static void mensagemTemporizada(String messagem, int segundos) {
        try {
            System.out.println(messagem);
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException ignored) {
        }
    }

    public void ln() {
        System.out.println("");
    }
}
