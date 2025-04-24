package org.example.illusion.features.module.impl.visuals;

import io.github.nevalackin.radbus.Listen;
import org.example.illusion.event.impl.render.Render2DEvent;
import org.example.illusion.features.module.api.Category;
import org.example.illusion.features.module.api.Module;
import org.example.illusion.features.module.api.ModuleInfo;
import org.example.illusion.utils.Colors;
import org.example.illusion.utils.RenderUtils;

@ModuleInfo(name = "ModOverlay", category = Category.VISUALS)
public class ModOverlay extends Module {
    @Listen
    public void onRender2D(Render2DEvent event) {
        RenderUtils.drawString(Colors.DARK_PURPLE + "I" + Colors.DARK_GRAY + "llusion", 3, 3, -1);
    }
}
