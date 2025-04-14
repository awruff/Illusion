package org.example.illusion.api;

import java.util.ArrayList;

public abstract class Module {
    protected ArrayList<String> settings;
    private final String name;
    private final String category;

    protected Module(String name, String category) {
        this.name = name;
        this.category = category;
    }
}
