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
        int numVertices = Main.NUM_VERTICE;
        int[] dist = new int[numVertices];
        boolean[] prev = new boolean[numVertices];
        for (int i = 0; i < Main.NUM_VERTICE; i++) {
            dist[i] = INFINITO;
            prev[i] = false;
        }
        dist[origem - 1] = 0;
        // Ideia de parents foi pega de outro site, que facilitou a implementacao
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
        exibirSolucao(destino, origem - 1, dist, prev, parents);
    }

    private static void exibirSolucao(int destino, int origem, int[] dist, boolean[] prev, int[] parents) {
        System.out.print("- Volta Dijkstra ");
        String caminho = (destino + 1) + " -> ";
        if (destino != origem) {
            for (int i = prev.length - 1; i >= 0; i--) {
                if (prev[i] && parents[i] != origem) {
                    if (parents[i] != -1 && parents[i] != 0) {
                        caminho += (parents[i] + 1) + " -> ";
                    }
                }
            }
            caminho += (origem + 1);
            System.out.printf("soma %d%n",  dist[destino]);
        }
    }
}
