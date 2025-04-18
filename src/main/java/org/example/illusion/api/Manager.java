package org.example.illusion.api;

import java.util.List;

public abstract class Manager<T> {

    protected List<T> elements;

    public Manager(List<T> elements) {
        this.elements = elements;
    }

    public abstract T getElement(String element);

    public List<T> getElements() {
        return elements;
    }
}
