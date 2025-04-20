package org.example.illusion.features.module.api;

import io.github.nevalackin.radbus.Listen;
import org.example.illusion.IllusionClient;
import org.example.illusion.event.impl.input.KeyPressEvent;
import org.example.illusion.features.api.Manager;
import org.example.illusion.features.module.impl.combat.Hitboxes;
import org.example.illusion.features.module.impl.combat.Reach;
import org.example.illusion.features.module.impl.misc.ClickGuiModule;
import org.example.illusion.features.module.impl.misc.TestModule;
import org.example.illusion.features.module.impl.movement.Sprint;
import org.example.illusion.features.module.impl.player.InventoryMove;
import org.example.illusion.features.module.impl.visuals.NoHurtCam;

import java.util.ArrayList;
import java.util.Arrays;

public class ModuleManager extends Manager<Module> {
    public ModuleManager() {
        super(Arrays.asList(
                new Hitboxes(),
                new Reach(),
                new ClickGuiModule(),
                new TestModule(),
                new Sprint(),
                new InventoryMove(),
                new NoHurtCam()
        ));

        IllusionClient.getInstance().getEventBus().subscribe(this);
    }

    public ArrayList<Module> getElements(Category category) {
        ArrayList<Module> result = new ArrayList<>();
        for (Module element : elements) {
            if (element.getCategory().equals(category)) {
                result.add(element);
            }
        }
        return result;
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
