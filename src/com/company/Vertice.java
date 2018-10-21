package com.company;

import java.util.Objects;

public class Vertice {

    private Integer id;

    public Vertice(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertice vertice = (Vertice) o;
        return Objects.equals(id, vertice.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Vertice{id='" + this.id + "\'" + "}";
    }

    public Integer getId() {
        return id;
    }

}
