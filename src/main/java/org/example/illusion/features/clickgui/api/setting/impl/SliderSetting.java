package org.example.illusion.features.clickgui.api.setting.impl;

import org.example.illusion.features.clickgui.api.setting.api.Setting;
import org.example.illusion.features.module.api.Module;

public class SliderSetting extends Setting {
    private final float min, max;

    private float value;

    public SliderSetting(String name, Module parent, float min, float max) {
        this(name, parent, min, max, max/min);
    }

    public SliderSetting(String name, Module parent, float min, float max, float value) {
        super(name, parent);

        this.min = min;
        this.max = max;
        this.value = value;
    }

    public float getMin() {
        return min;
    }

    public float getMax() {
        return max;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.getParent().onUpdate();
        this.value = value;
    }
}
