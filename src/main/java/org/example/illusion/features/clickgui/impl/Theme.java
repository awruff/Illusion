package org.example.illusion.features.clickgui.impl;

import org.example.illusion.IllusionClient;
import org.example.illusion.features.module.impl.misc.ClickGuiModule;

import java.awt.*;

public class Theme {
    public static Color getMainColor() {
        return getMainColor(255);
    }

    public static Color getMainColor(int alpha) {
        ClickGuiModule module = (ClickGuiModule) IllusionClient.getInstance().getModuleManager().getElement("ClickGui");

        if (module == null) return new Color(255, 255, 255, alpha);

        String theme = module.theme.getValue();

        switch (theme) {
            case "Emerald":
                return new Color(46, 204, 113, alpha);
            case "Amethyst":
                return new Color(155, 89, 182, alpha);
            case "Orange":
                return new Color(255, 165, 0, alpha);
            default:
                return new Color(255, 255, 255, alpha);
        }
    }

    public static Color getBackColor() {
        return getBackColor(100);
    }

    public static Color getBackColor(int alpha) {
        return new Color(0, 0, 0, alpha);
    }
}
