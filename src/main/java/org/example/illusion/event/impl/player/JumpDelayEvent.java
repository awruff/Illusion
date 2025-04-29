package org.example.illusion.event.impl.player;

import org.example.illusion.event.Event;

public class JumpDelayEvent implements Event {
    private int jumpTicks = 10;

    public int getJumpTicks() {
        return jumpTicks;
    }

    public void setJumpTicks(int jumpTicks) {
        this.jumpTicks = jumpTicks;
    }
}
