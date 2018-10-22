package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private List<Integer> linhasArquivo = new ArrayList<>();
//    private List<Vertice> vertices;
//    private List<Aresta> arestas;
    private int[][] matrizPesos = new int[6][6];

    public static void main(String[] args) {
        new Main().processar();
    }

    private void processar() {
        this.linhasArquivo = LerArquivos.lerLinhasDoArquivo("C:\\Users\\Eduardo Cruz\\IdeaProjects\\caixeiro-viajante\\Arquivos\\Rota01.txt");
        int aux = 0;
        for (int i = 0; i < this.matrizPesos.length; i++) {
            for (int j = 0; j < this.matrizPesos.length; j++) {
                this.matrizPesos[i][j] = this.linhasArquivo.get(aux);
                aux++;
            }
        }
        FloydWarshall.floydWarshall(this.matrizPesos);
    }
}
