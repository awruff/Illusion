package org.example.illusion.features.events.impl;

import org.example.illusion.features.events.api.Event;
import org.lwjgl.input.Keyboard;

public class KeyPressEvent implements Event {
    public final int keycode;
    public final boolean state;

    public KeyPressEvent() {
        this.keycode = Keyboard.getEventKey();
        this.state = Keyboard.getEventKeyState();
    }
}
