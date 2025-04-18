package org.example.illusion.impl.events;

import org.example.illusion.api.events.CancellableEvent;

public class ChatSendEvent extends CancellableEvent {
    public String message;

    public ChatSendEvent(String message) {
        this.message = message;
    }
}
