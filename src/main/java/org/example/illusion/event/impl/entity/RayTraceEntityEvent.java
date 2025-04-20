package org.example.illusion.event.impl.entity;

import org.example.illusion.event.Event;

public class RayTraceEntityEvent implements Event {
    private float reach = 3.0F;
    private float borderMultiplier = 1.0F;

    public float getReach() {
        return reach;
    }

    public void setReach(float reach) {
        this.reach = reach;
    }

    public float getBorderMultiplier() {
        return borderMultiplier;
    }

    public void setBorderMultiplier(float borderMultiplier) {
        this.borderMultiplier = borderMultiplier;
    }
}
