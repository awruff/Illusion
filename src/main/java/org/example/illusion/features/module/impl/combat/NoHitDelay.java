package org.example.illusion.features.module.impl.combat;

import io.github.nevalackin.radbus.Listen;
import org.example.illusion.event.impl.player.HitDelayEvent;
import org.example.illusion.features.module.api.Category;
import org.example.illusion.features.module.api.Module;
import org.example.illusion.features.module.api.ModuleInfo;

@ModuleInfo(name = "NoHitDelay", category = Category.COMBAT)
public class NoHitDelay extends Module {
    @Listen
    public void onHitDelay(HitDelayEvent event) {
        event.setHitDelay(0);
    }
}
