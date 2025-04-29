package org.example.illusion.event.impl.player;

import org.example.illusion.event.Event;

public final class HitDelayEvent implements Event {
    private int hitDelay = 10;

    public int getHitDelay() {
        return hitDelay;
    }

    public void setHitDelay(int hitDelay) {
        this.hitDelay = hitDelay;
    }
}
