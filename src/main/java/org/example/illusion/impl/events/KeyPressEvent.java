package org.example.illusion.impl.events;

import org.example.illusion.api.events.Event;
import org.lwjgl.input.Keyboard;

public class KeyPressEvent implements Event {
    public final int keycode;
    public final boolean state;

    public KeyPressEvent() {
        this.keycode = Keyboard.getEventKey();
        this.state = Keyboard.getEventKeyState();
    }
}
