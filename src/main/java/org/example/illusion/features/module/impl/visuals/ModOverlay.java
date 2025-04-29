package org.example.illusion.features.module.impl.visuals;

import io.github.nevalackin.radbus.Listen;
import org.example.illusion.event.impl.render.Render2DEvent;
import org.example.illusion.features.module.api.Category;
import org.example.illusion.features.module.api.Module;
import org.example.illusion.features.module.api.ModuleInfo;

@ModuleInfo(name = "ModOverlay", category = Category.VISUALS)
public class ModOverlay extends Module {
    @Listen
    public void onRender2D(Render2DEvent event) {
    }
}
