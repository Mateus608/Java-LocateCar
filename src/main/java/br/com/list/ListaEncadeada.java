package br.com.list;

import br.com.util.ConsoleUI;

public class ListaEncadeada {
        private Celula primeiro;
        private Celula ultimo;
        private int tamanho;

        public void adicionarInicio(Object dado) {
            Celula novaCelula = new Celula(this.primeiro, dado);
            this.primeiro = novaCelula;

            if (this.tamanho == 0) {
                this.ultimo = novaCelula;
            }

            this.tamanho++;
        }

        public void adicionarFim(Object dado) {
            if (this.tamanho == 0) {
                this.adicionarInicio(dado);
            } else {
                Celula novaCelula  = new Celula(dado);
                this.ultimo.setProximo(novaCelula);
                this.ultimo = novaCelula;
                this.tamanho++;
            }
        }

        public void mostrarLista() {
            if (this.tamanho == 0) {
                System.out.println(ConsoleUI.formatText("Nenhum cadastro adicionado!", "vermelho"));
                return;
            }

            Celula celulaAtual = this.primeiro;

            for (int i = 0; i < this.tamanho; i++) {
                System.out.println(celulaAtual.getDado());
                celulaAtual = celulaAtual.getProximo();
            }
        }
}
