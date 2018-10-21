package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private List<String> linhasArquivo = new ArrayList<>();
    private List<Vertice> vertices;
    private List<Aresta> arestas;

    public static void main(String[] args) {
        new Main().processar();
    }

    private void processar() {
        linhasArquivo = LerArquivos.lerLinhasDoArquivo("C:\\Users\\Eduardo Cruz\\IdeaProjects\\caixeiro-viajante\\Arquivos\\Rota01.txt");
        vertices = new ArrayList<>();
        arestas = new ArrayList<>();
        for (String linha : linhasArquivo) {
            this.tratarDadosArquivo(linha);
        }
        Grafo grafo = new Grafo(vertices, arestas);
        for (Aresta aresta : grafo.getArestas()) {
            System.out.println(aresta);
        }
    }

    private void tratarDadosArquivo(String linha) {
        String dadosLinha[] = linha.split(";");
        Integer origem = Integer.parseInt(dadosLinha[0]);
        Integer destino = Integer.parseInt(dadosLinha[1]);
        Integer peso = Integer.parseInt(dadosLinha[2]);

        Vertice verticeOrigem = new Vertice(origem);
        Vertice verticeDestino = new Vertice(destino);
        vertices.add(verticeOrigem);
        vertices.add(verticeDestino);
        Aresta aresta = new Aresta(verticeOrigem, verticeDestino, peso);
        arestas.add(aresta);
    }
}
