package org.example.illusion.features.module.api;

import io.github.nevalackin.radbus.Listen;
import org.example.illusion.IllusionClient;
import org.example.illusion.event.impl.input.KeyPressEvent;
import org.example.illusion.features.api.Manager;
import org.example.illusion.features.module.impl.combat.AutoClicker;
import org.example.illusion.features.module.impl.combat.Hitboxes;
import org.example.illusion.features.module.impl.combat.NoHitDelay;
import org.example.illusion.features.module.impl.combat.Reach;
import org.example.illusion.features.module.impl.misc.ClickGuiModule;
import org.example.illusion.features.module.impl.misc.TestModule;
import org.example.illusion.features.module.impl.misc.Weapons;
import org.example.illusion.features.module.impl.movement.NoJumpDelay;
import org.example.illusion.features.module.impl.movement.Sprint;
import org.example.illusion.features.module.impl.player.InventoryMove;
import org.example.illusion.features.module.impl.visuals.ModOverlay;
import org.example.illusion.features.module.impl.visuals.NoHurtCam;
import org.example.illusion.features.module.impl.visuals.PlayerESP;

import java.util.ArrayList;
import java.util.Arrays;

public class ModuleManager extends Manager<Module> {
    public ModuleManager() {
        super(Arrays.asList(
                new AutoClicker(),
                new Hitboxes(),
                new NoHitDelay(),
                new Reach(),
                new ClickGuiModule(),
                new TestModule(),
                new Weapons(),
                new NoJumpDelay(),
                new Sprint(),
                new InventoryMove(),
//                new ModOverlay(),
                new NoHurtCam(),
                new PlayerESP()
        ));

        IllusionClient.getInstance().getEventBus().subscribe(this);
    }

    public final ArrayList<Module> getElements(Category category) {
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
