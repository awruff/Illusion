package org.example.illusion.modules.api;

import java.util.ArrayList;

public abstract class Module {
    protected ArrayList<String> settings;
    private final String name;
    private final String category;

    public Module(String name, String category) {
        this.name = name;
        this.category = category;
    }
}
