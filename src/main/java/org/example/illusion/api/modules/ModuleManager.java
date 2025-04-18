package org.example.illusion.api.modules;

import io.github.nevalackin.radbus.Listen;
import org.example.illusion.IllusionClient;
import org.example.illusion.api.Manager;
import org.example.illusion.impl.events.KeyPressEvent;
import org.example.illusion.impl.modules.client.TestModule;

import java.util.Arrays;

public class ModuleManager extends Manager<Module> {
    public ModuleManager() {
        super(Arrays.asList(
                new TestModule()
        ));

        IllusionClient.getInstance().getEventBus().subscribe(this);
    }

    @Override
    public Module getElement(String element) {
        return elements.stream()
                .filter(module -> module.getName().equals(element))
                .findFirst()
                .orElse(null);
    }

    @Listen
    public void keyPresses(KeyPressEvent event) {
        if (event.keycode == 0) return;

        IllusionClient.getInstance().getModuleManager().getElements()
                .forEach(module -> {
                    if (module.getBind() == event.keycode) module.toggle();
                });
    }
}
