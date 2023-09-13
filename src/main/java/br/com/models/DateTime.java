package br.com.models;

import java.time.LocalDateTime;

public class DateTime {

    public void aposUmDia(LocalDateTime inicio) throws InterruptedException {
        inicio = LocalDateTime.now();
        LocalDateTime fim = inicio.plusHours(24);

        while (true) {
            LocalDateTime agora = LocalDateTime.now();

            if (agora.isAfter(fim)) {
                System.out.println("Passaram-se 24 horas. Realizando ação...");

                fim = agora.plusHours(24);
            }

            Thread.sleep(1000);
        }

    }
}
