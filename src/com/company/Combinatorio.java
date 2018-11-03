package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Combinatorio {
    private static List<List<Integer>> listaCaminhos = new ArrayList<>();

    /**
     * Algoritmo gerador das combinacoes - BSF
     *
     * @param arr array contendo os caminhos
     * @param r   o numero de combinacoes
     */
    public static List combinatorio(int arr[], int r) {
        Queue<List<Integer>> paths = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> lista = new LinkedList<>();
            lista.add(arr[i]);
            paths.add(lista);
        }
        while (!paths.isEmpty()) {
            List<Integer> caminho = paths.remove();
            for (int i = 0; i < arr.length; i++) {
                if (!caminho.contains(arr[i])) {
                    List<Integer> novoCaminho = new ArrayList<>(caminho);
                    novoCaminho.add(arr[i]);
                    paths.add(novoCaminho);
                    if (caminho.size() == r && novoCaminho.get(0) == 1) {
                        listaCaminhos.add(novoCaminho);
                    }
                }
            }
        }
        return listaCaminhos;
    }
}