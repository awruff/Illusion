package org.example.illusion.event.impl.render;

import org.example.illusion.event.Event;

public class Render2DEvent implements Event {
    private final float partialTicks;

    public Render2DEvent(final float partialTicks) {
        this.partialTicks = partialTicks;
    }

    public float getPartialTicks() {
        return partialTicks;
    }
}
