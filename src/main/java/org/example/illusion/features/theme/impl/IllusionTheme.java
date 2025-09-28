package org.example.illusion.features.theme.impl;

import org.example.illusion.features.theme.api.Theme;

import java.awt.*;

public class IllusionTheme extends Theme {
    public IllusionTheme() {
        super("Illusion");
    }

    @Override
    public Color getText() {
        return new Color(255, 255, 255);
    }

    @Override
    public Color getPrimary() {
        return new Color(46, 204, 113);
    }

    @Override
    public Color getSecondary() {
        return new Color(39, 117, 71);
    }

    @Override
    public Color getBackground() {
        return new Color(10, 10, 10, 35);
    }
}
