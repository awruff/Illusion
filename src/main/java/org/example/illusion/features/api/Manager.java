package org.example.illusion.features.api;

import java.util.List;

public class Manager<T extends Feature> {
    protected List<T> elements;

    public Manager(List<T> elements) {
        this.elements = elements;
    }

    public T getElement(String name) {
        return elements.stream()
                .filter(element -> element.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<T> getElements() {
        return elements;
    }
}