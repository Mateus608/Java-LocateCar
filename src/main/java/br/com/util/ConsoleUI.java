package br.com.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {

    public static final String ANSI_RESET = "\u001B[0m"; // Reseta a formatação
    public static final String ANSI_RED = "\u001B[31m"; // Texto vermelho
    public static final String ANSI_YELLOW = "\u001B[33m"; // Texto amarelo
    public static final String ANSI_GREEN = "\u001B[32m"; // Texto verde
    public static final String ANSI_BLUE = "\u001B[34m"; // Texto azul

    public static String formatText(String text, String color) {
        switch (color.toLowerCase()) {
            case "vermelho":
                return ANSI_RED + text + ANSI_RESET;
            case "amarelo":
                return ANSI_YELLOW + text + ANSI_RESET;
            case "verde":
                return ANSI_GREEN + text + ANSI_RESET;
            case "azul":
                return ANSI_BLUE + text + ANSI_RESET;
            default:
                return text;
        }
    }

    public static void adicionarTitulo(String titulo) {
        System.out.println("");
        System.out.println(formatText(titulo.toUpperCase(), "azul"));
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

    public static void ln() {
        System.out.println("");
    }
}
