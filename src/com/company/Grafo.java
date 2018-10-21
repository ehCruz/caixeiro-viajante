package com.company;

import java.util.List;

public class Grafo {

    private List<Vertice> vertices;
    private List<Aresta> arestas;

    public Grafo(List<Vertice> vertices, List<Aresta> arestas){
        this.vertices = vertices;
        this.arestas = arestas;
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }
}
