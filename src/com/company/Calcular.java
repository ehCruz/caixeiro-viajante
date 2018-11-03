package com.company;

import java.util.List;

public class Calcular {

    private static int[][] pesos;

    public static void calcularRotas(List<List<Integer>> listaCaminho, int[][] pesos) {
        Calcular.pesos = pesos;
        System.out.printf("Soma dos caminhos%n");
        for (List<Integer> caminho : listaCaminho) {
            Calcular.calc(caminho);
        }
    }

    private static void calc(List<Integer> caminho) {
        int soma = 0;
        int atual = caminho.get(0);
        System.out.printf("Ida ");
        for (int i = 1; i < caminho.size(); i++) {
            System.out.printf("%d - ", atual);
            soma += pesos[atual - 1][caminho.get(i) - 1];
            atual = caminho.get(i);
        }
        System.out.printf("%d - Soma %d ", atual, soma);
        Dijkstra.dijkstraTopzeira(pesos, caminho.get(0), atual - 1);
        System.out.println();
    }
}
