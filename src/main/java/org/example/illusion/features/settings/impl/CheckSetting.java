package org.example.illusion.features.settings.impl;

import org.example.illusion.features.module.api.Toggleable;
import org.example.illusion.features.settings.api.Setting;

public class CheckSetting extends Toggleable implements Setting {
    private final String name;

    public CheckSetting(String name) {
        this(name, false);
    }

    public CheckSetting(String name, boolean enabled) {
        this.name = name;
        setEnabled(enabled);
    }

    @Override
    public String getName() {
        return name;
    }
}
