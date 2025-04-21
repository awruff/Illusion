package org.example.illusion.event.impl.render;

import org.example.illusion.event.Event;

public class Render3DEvent implements Event {
    private final float partialTicks;

    public Render3DEvent(float partialTicks) {
        this.partialTicks = partialTicks;
    }

    public float getPartialTicks() {
        return partialTicks;
    }
}
