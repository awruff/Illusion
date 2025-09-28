package org.example.illusion.features.clickgui.api.setting.impl;

import org.example.illusion.features.clickgui.api.setting.api.Setting;
import org.example.illusion.features.module.api.Module;

public class CheckSetting extends Setting {
    private boolean enabled;

    public CheckSetting(String name, Module parent, boolean enabled) {
        super(name, parent);

        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.getParent().onUpdate();
        this.enabled = enabled;
    }
}

