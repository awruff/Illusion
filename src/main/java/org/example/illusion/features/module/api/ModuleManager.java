package org.example.illusion.features.module.api;

import io.github.nevalackin.radbus.Listen;
import org.example.illusion.IllusionClient;
import org.example.illusion.event.impl.input.KeyPressEvent;
import org.example.illusion.features.api.Manager;
import org.example.illusion.features.module.impl.TestModule;

import java.util.Arrays;

public class ModuleManager extends Manager<Module> {
    public ModuleManager() {
        super(Arrays.asList(
                new TestModule()
        ));

        IllusionClient.getInstance().getEventBus().subscribe(this);
    }

    @Listen
    public void keyPresses(KeyPressEvent event) {
        if (event.getKey() == 0 || !event.isDown()) return;

        this.getElements()
                .forEach(module -> {
                    if (module.getBind() == event.getKey()) module.toggle();
                });
    }
}
