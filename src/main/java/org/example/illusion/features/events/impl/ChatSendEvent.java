package org.example.illusion.features.events.impl;

import org.example.illusion.features.events.api.CancellableEvent;

public class ChatSendEvent extends CancellableEvent {
    public String message;

    public ChatSendEvent(String message) {
        this.message = message;
    }
}
