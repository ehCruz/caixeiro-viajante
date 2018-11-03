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
    private static int numVertices;

    /**
     * Algoritmo de Dijkstra
     *
     * @param graph  - grafo com os dados
     * @param origem - ponto de saida
     * @return valor(distancia) total do menos caminho
     */
    public static int dijkstra(int[][] graph, int origem, int destino) {
        numVertices = graph.length;
        int[] dist = new int[numVertices];
        boolean[] prev = new boolean[numVertices];
        // Ira guardar a arvore com todos os caminhos, consequentemente o menor
        int[] menorCaminho = new int[numVertices];

        for (int i = 0; i < numVertices; i++) {
            dist[i] = INFINITO;
            prev[i] = false;
        }

        dist[origem] = 0;
        menorCaminho[origem] = -1;

        for (int i = 0; i < numVertices - 1; i++) {
            int u = minVertice(prev, dist);
            prev[u] = true;

            for (int j = 0; j < numVertices; j++) {
                if (!prev[j] && graph[u][j] != 0 && dist[u] != INFINITO && (dist[u] + graph[u][j] < dist[j])) {
                    menorCaminho[j] = u;
                    dist[j] = dist[u] + graph[u][j];
                }
            }
        }
        exibirMenorCaminho(destino, menorCaminho);
        System.out.printf("Soma %d", dist[destino]);
        return dist[destino];
    }

    /**
     * @param prev vertices que ja foram percorridas
     * @param dist distancias
     * @return a menor vertice
     */
    private static int minVertice(boolean[] prev, int[] dist) {
        int min = INFINITO;
        int menorIndex = -1;

        for (int i = 0; i < numVertices; i++) {
            if (!prev[i] && dist[i] <= min) {
                min = dist[i];
                menorIndex = i;
            }
        }
        return menorIndex;
    }

    /**
     * @param destino      sempre recebe a proxima vertice do menor caminho, ate cheagar em -1
     * @param menorCaminho array com todos os caminhos
     */
    private static void exibirMenorCaminho(int destino, int[] menorCaminho) {
        if (destino == -1) {
            return;
        }
        exibirMenorCaminho(menorCaminho[destino], menorCaminho);
        System.out.printf("%d - ", (destino + 1));
    }
}
