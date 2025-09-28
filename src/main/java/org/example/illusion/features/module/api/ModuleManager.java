package org.example.illusion.features.module.api;

import io.github.nevalackin.radbus.Listen;
import org.example.illusion.IllusionClient;
import org.example.illusion.event.impl.input.KeyPressEvent;
import org.example.illusion.features.api.Manager;
import org.example.illusion.features.module.impl.combat.*;
import org.example.illusion.features.module.impl.misc.*;
import org.example.illusion.features.module.impl.movement.*;
import org.example.illusion.features.module.impl.player.*;
import org.example.illusion.features.module.impl.visuals.*;

import java.util.List;
import java.util.stream.Collectors;

public class ModuleManager extends Manager<Module> {
    public ModuleManager() {
        super(
                new AutoClicker(), new Hitboxes(), new NoHitDelay(), new Reach(),
                new ClickGuiModule(), new TestModule(), new Weapons(),
                new NoJumpDelay(), new Sprint(),
                new InventoryMove(),
                new ModOverlay(), new NoHurtCam(), new PlayerESP()
        );

        IllusionClient.getInstance().getEventBus().subscribe(this);
    }

    public final List<Module> getElements(Category category) {
        return elements.stream()
                .filter(element -> element.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    @Listen
    public void keyPresses(KeyPressEvent event) {
        if (event.getKey() == 0 || !event.isDown()) return;

        this.getElements().forEach(module -> {
                    if (module.getBind() == event.getKey()) module.toggle();
                });
    }
}
