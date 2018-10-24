package com.company;

import java.util.Arrays;

public class FloydWarshall {

    private static final Double INFINITO = Double.POSITIVE_INFINITY;

    public static void floydWarshall(int[][] grafo, int numVertices) {
        double[][] distancias = new double[numVertices][numVertices];
        int[][] vertices = new int[numVertices][numVertices];
        /**
         * Deixa o array das distancia como "infinito", ou seja, vertices que nao estao ligados
         * tem o peso de "infinito".
         */
        for (double[] d : distancias) {
            Arrays.fill(d, FloydWarshall.INFINITO);
        }

        /**
         * Adiciona o peso de cada aresta conhecida
         */
        for (int[] g : grafo) {
            distancias[g[0] - 1][g[1] - 1] = g[2];
        }

        /**
         * Todos os caminhos a percorrer
         */
        for (int i = 0; i < vertices.length; i++) {
            for (int j = 0; j < vertices.length; j++) {
                if (i != j) {
                    vertices[i][j] = j + 1;
                }
            }
        }

        /**
         * Algoritmo de Floyd-Warshall
         */
        for (int k = 0; k < distancias.length; k++) {
            for (int i = 0; i < distancias.length; i++) {
                for (int j = 0; j < distancias.length; j++) {
                    if (distancias[i][j] > distancias[i][k] + distancias[k][j]) {
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                        vertices[i][j] = vertices[i][k];
                    }
                }
            }
        }
        path(distancias, vertices);
    }

    private static void path(double[][] dis, int[][] ver) {
        System.out.println("Inicio     Distancia    Caminho");
        for (int i = 0; i < ver.length; i++) {
            for (int j = 0; j < ver.length; j++) {
                if( i!= j){
                    int origem = i + 1;
                    int destino = j + 1;
                    String path = String.format("%d - %d    %2d             %s", origem, destino, (int)dis[i][j], origem);
                    while (origem != destino) {
                        origem = ver[origem - 1][destino - 1];
                        path += " -> " + origem;
                    }
                    System.out.println(path);
                }
            }
            System.out.println();
        }
    }
}
