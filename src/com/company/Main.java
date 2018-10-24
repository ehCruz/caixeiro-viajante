package com.company;

public class Main {
    private int[][] grafo;
    private final static int NUM_VERTICE = 6;
    public static void main(String[] args) {
        new Main().processar();
    }

    private void processar() {
        this.grafo = LerArquivos.lerLinhasDoArquivo("C:\\Users\\Eduardo Cruz\\IdeaProjects\\caixeiro-viajante\\Arquivos\\Rota02.txt");
        FloydWarshall.floydWarshall(this.grafo, NUM_VERTICE);
    }
}
