package org.example.illusion.event.impl.client;

import org.example.illusion.event.Event;
import org.example.illusion.features.module.api.Module;

public class ModuleDisabledEvent implements Event {
    private final Module module;

    public ModuleDisabledEvent(final Module module) {
        this.module = module;
    }

    public Module getModule() {
        return module;
    }
}