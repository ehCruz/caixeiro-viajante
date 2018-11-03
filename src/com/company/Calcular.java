package com.company;

import java.util.List;

public class Calcular {

    private static int[][] pesos;

    public static void calcularRotas(List<List<Integer>> listaCaminho, int[][] pesos) {
        Calcular.pesos = pesos;
        int menor = Integer.MAX_VALUE;
        int total;
        System.out.printf("Soma dos caminhos%n");
        for (List<Integer> caminho : listaCaminho) {
            total = Calcular.calc(caminho);
            if (menor >= total) {
                menor = total;
                System.out.print(" <-- Menor Caminho");
            }
            System.out.println();
        }
    }

    /**
     * @param caminho recebe um caminho completo
     * @return o valor(distancia) total de ida e volta
     */
    private static int calc(List<Integer> caminho) {
        int soma = 0;
        int atual = caminho.get(0);
        System.out.printf("Ida ");
        for (int i = 1; i < caminho.size(); i++) {
            System.out.printf("%d - ", atual);
            soma += pesos[atual - 1][caminho.get(i) - 1];
            atual = caminho.get(i);
        }
        System.out.printf("%d - Soma %d | Volta ", atual, soma);
        int volta = Dijkstra.dijkstra(pesos, caminho.get((caminho.size() - 1)) - 1, 0);
        System.out.printf(" | Total %d", (soma + volta));
        return soma + volta;
    }
}
