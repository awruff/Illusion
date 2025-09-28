package org.example.illusion.features.theme.api;

import org.example.illusion.features.api.Feature;

import java.awt.*;

public abstract class Theme implements Feature {
    public String name, description;

    public Theme(String name) {
        this.name = name;
        this.description = "UNUSED";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public abstract Color getText();

    public abstract Color getPrimary();

    public Color getPrimaryHover() {
        return getPrimary().darker();
    }

    public abstract Color getSecondary();

    public Color getSecondaryHover() {
        return getSecondary().darker();
    }

    public abstract Color getBackground();

    public Color getBackgroundHover() {
        return getBackground().darker();
    }
}
