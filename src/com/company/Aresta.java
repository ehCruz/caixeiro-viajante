package com.company;

public class Aresta {

    private Vertice origem;
    private Vertice destino;
    private Integer peso;

    public Aresta(Vertice origem, Vertice destino, Integer peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return this.origem + "--" + this.peso + "-->" + this.destino;
    }

    public Vertice getOrigem() {
        return origem;
    }

    public Vertice getDestino() {
        return destino;
    }

    public Integer getPeso() {
        return peso;
    }
}
