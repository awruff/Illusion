package org.example.illusion.features.clickgui.api.setting.impl;

import org.example.illusion.features.clickgui.api.setting.api.Setting;
import org.example.illusion.features.module.api.Module;

public class ComboSetting extends Setting {
    private final String[] options;
    private String value;

    public ComboSetting(String name, String description, Module parent, String[] options) {
        this(name, description, parent, options, options[0]);
    }

    public ComboSetting(String name, String description, Module parent, String[] options, String value) {
        super(name, description, parent);
        this.options = options;
        this.value = value;
    }

    public String[] getOptions() {
        return options;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
