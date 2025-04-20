package org.example.illusion.features.settings.impl;

import org.example.illusion.features.settings.api.Setting;

public class SliderSetting implements Setting {
    private final String name;
    private float min, max, value;

    public SliderSetting(final String name, final float min, final float max) {
        this(name, min, max, min / max * 2f);
    }

    public SliderSetting(final String name, final float min, final float max, final float value) {
        this.name = name;
        this.min = min;
        this.max = max;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    public float getMin() {
        return min;
    }

    public void setMin(final float min) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax(final float max) {
        this.max = max;
    }

    public float getValue() {
        return value;
    }

    public void setValue(final float value) {
        this.value = Math.max(min, Math.min(value, max));;
    }
}
