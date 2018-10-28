package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe auxiliar usada para calcular de forma "gulosa"(com baixa precisao) o melhor caminho
 * para percorrer todas as vertices de um grafo nao direcionado
 *
 * @author Eduardo Henrique Cruz
 */
public class Greedy {

    private static List<Integer> visited = new ArrayList<>();
    private static int custoDaViagem = 0;

    /**
     * <h1>Inicia um novo roteamento</h1>
     *
     * @param pontoDePartida - vertice de partida
     */
    public static void roteamento(int[][] pesos, int pontoDePartida) {
        if (pontoDePartida > 0 && pontoDePartida <= 6) {
            System.out.println("Caminho de ida usando um algoritmo do tipo greedy:");
            custoDaViagem = 0;
            visited.clear();
            int cont = 0;
            int aux = pontoDePartida - 1;
            visited.add(aux);
            while (cont < Main.NUM_VERTICE) {
                aux = calculoGreedy(pesos, aux);
                cont++;
            }
            exibirCaminho();
            Dijkstra.dijkstraTopzeira(pesos, pontoDePartida, visited.get(visited.size() - 2));
        } else {
            System.out.println("Ponto de partida informado e invalido");
        }
    }

    /**
     * <h1>Metodo para verificar e calcular o melhor caminho</h1>
     * <p>Foi construido um metodo greedy para encontrar o possivel melhor caminho</p>
     *
     * @param pesos - matriz a ser percorrida
     * @param linha - A linha em que as colunas serão percorridas
     * @return - a proxima linha a ser analisada
     */
    private static int calculoGreedy(int[][] pesos, int linha) {
        int menorCaminho = Integer.MAX_VALUE;
        int caminho = 0;
        for (int i = 0; i < Main.NUM_VERTICE; i++) {
            if (linha != i) {
                if (pesos[linha][i] < menorCaminho && !(visited.contains(i))) {
                    menorCaminho = pesos[linha][i];
                    caminho = i;
                }
            }
        }
        custoDaViagem += pesos[linha][caminho];
        visited.add(caminho);
        return caminho;
    }

    /**
     * <h1>Mostra na tela o caminho</h1>
     */
    private static void exibirCaminho() {
        System.out.printf("Caminho                      Custo%n");
        String path = "";
        for (int i = 0; i < visited.size() - 1; i++) {
            path += visited.get(i) + 1;
            if (i != Main.NUM_VERTICE - 1) {
                path += " -> ";
            }
        }
        System.out.printf("%s   %d%n%n", path, custoDaViagem);
    }
}
