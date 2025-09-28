package org.example.illusion.features.theme.api;

import org.example.illusion.features.api.Manager;
import org.example.illusion.features.module.impl.misc.ClickGuiModule;
import org.example.illusion.features.theme.impl.IllusionTheme;

public class ThemeManager extends Manager<Theme> {
    public ThemeManager() {
        super(
                new IllusionTheme()
        );
    }

    public Theme getCurrent() {
        return getElement(ClickGuiModule.currentTheme);
    }
}
