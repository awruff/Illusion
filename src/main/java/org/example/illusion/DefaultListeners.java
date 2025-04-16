package org.example.illusion;

import io.github.nevalackin.radbus.Listen;
import org.example.illusion.features.events.impl.KeyPressEvent;

// events that are registered at initialization and unregistered at shutdown.
public class DefaultListeners {
    @Listen
    public void keyPresses(KeyPressEvent event) {
        if (event.keycode == 0) return;

        Illusion.INSTANCE.getModuleManager().getModules().values()
                .forEach(module -> {
                    if (module.getBind() == event.keycode) module.toggle();
                });
    }
}
