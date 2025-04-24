package org.example.illusion.features.module.impl.visuals;

import io.github.nevalackin.radbus.Listen;
import org.example.illusion.event.impl.render.HurtShakeEvent;
import org.example.illusion.features.module.api.Category;
import org.example.illusion.features.module.api.Module;
import org.example.illusion.features.module.api.ModuleInfo;

@ModuleInfo(name = "NoHurtCam", category = Category.VISUALS)
public class NoHurtCam extends Module {
    @Listen
    public void onHurtShake(HurtShakeEvent event) {
        event.setCancelled();
    }
}
