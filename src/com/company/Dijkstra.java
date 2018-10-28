package com.company;

/**
 * <h1>Implementacao do algoritmo de Dijkstra</h1>
 * <p>
 * Implementacao do pseudo codigo disponivel na Wikipedia
 * https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm#Pseudocode
 * </p>
 *
 * @author Eduardo Henrique Cruz
 */
public class Dijkstra {

    private static final int INFINITO = Integer.MAX_VALUE;

    /**
     * Algoritmo de Dijkstra topzeira rodando em O(|V|^2)
     *
     * @param grafo  - grafo com os dados
     * @param origem - ponto de saida
     */
    public static void dijkstraTopzeira(int[][] grafo, int origem, int destino) {
        int numVertices = grafo[0].length;
        int[] dist = new int[numVertices];
        boolean[] prev = new boolean[numVertices];

        for (int i = 0; i < Main.NUM_VERTICE; i++) {
            dist[i] = INFINITO;
            prev[i] = false;
        }
        dist[origem - 1] = 0;

        // Ideia de parentes foi pega de outro site, que facilitou a implementacao
        int[] parents = new int[numVertices];
        parents[origem - 1] = -1;

        int maisProximo = -1;
        int menorDistancia = INFINITO;
        for (int i = 0; i < numVertices; i++) {
            maisProximo = -1;
            menorDistancia = INFINITO;
            for (int j = 0; j < numVertices; j++) {
                if (!prev[j] && dist[j] < menorDistancia) {
                    maisProximo = j;
                    menorDistancia = dist[j];
                }
            }

            prev[maisProximo] = true;

            for (int j = 0; j < numVertices; j++) {
                int aresta = grafo[maisProximo][j];
                if (aresta > 0 && ((menorDistancia + aresta) < dist[j])) {
                    parents[j] = maisProximo;
                    dist[j] = menorDistancia + aresta;
                }
            }
        }
        printSolution(destino, origem - 1, dist, parents);
    }

    private static void printSolution(int destino, int origem, int[] dist, int[] parents) {
        System.out.println("Caminho de volta usando o algoritmo de Dijkstra");
        System.out.printf("Caminho                      Custo%n");
        String caminho = (destino + 1) + " -> ";
        if (destino != origem) {
            for (int i = parents.length - 1; i >= 0; i--) {
                if (parents[i] != -1 && parents[i] != 0) {
                    caminho += (parents[i] + 1) + " -> ";
                }
            }
            caminho += (origem + 1);
            System.out.printf("%14s             %d%n%n", caminho, dist[destino]);
        }
    }

}
