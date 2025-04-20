package org.example.illusion.features.clickgui.api.setting.impl;

import org.example.illusion.features.clickgui.api.setting.api.Setting;
import org.example.illusion.features.module.api.Module;

public class SliderSetting extends Setting {
    private final float min, max;
    private final boolean integer;

    private float value;

    public SliderSetting(String name, String description, Module parent, float min, float max) {
        this(name, description, parent, min, max, max/min);
    }

    public SliderSetting(String name, String description, Module parent, float min, float max, float value) {
        this(name, description, parent, min, max, value, false);
    }

    public SliderSetting(String name, String description, Module parent, float min, float max, float value, boolean integer) {
        super(name, description, parent);

        this.min = min;
        this.max = max;
        this.value = value;
        this.integer = integer;
    }

    public float getMin() {
        return min;
    }

    public float getMax() {
        return max;
    }

    public boolean isInteger() {
        return integer;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
