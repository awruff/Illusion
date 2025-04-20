package org.example.illusion.features.clickgui.api.setting.api;

import org.example.illusion.features.api.Feature;
import org.example.illusion.features.module.api.Module;

public class Setting implements Feature {
    private final String name;
    private final String description;
    private final Module parent;

    public Setting(String name, String description, Module parent) {
        this.name = name;
        this.description = description;
        this.parent = parent;
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final String getDescription() {
        return description;
    }

    public final Module getParent() {
        return parent;
    }
}
