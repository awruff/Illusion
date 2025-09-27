package org.example.illusion.features.module.impl.visuals;

import io.github.nevalackin.radbus.Listen;
import org.example.illusion.IllusionClient;
import org.example.illusion.event.impl.client.ModuleDisabledEvent;
import org.example.illusion.event.impl.client.ModuleEnabledEvent;
import org.example.illusion.event.impl.render.Render2DEvent;
import org.example.illusion.features.clickgui.impl.Theme;
import org.example.illusion.features.module.api.Category;
import org.example.illusion.features.module.api.Module;
import org.example.illusion.features.module.api.ModuleInfo;
import org.example.illusion.utils.FontUtils;

import java.util.ArrayList;
import java.util.Comparator;

@ModuleInfo(name = "ModOverlay", category = Category.VISUALS)
public class ModOverlay extends Module {
    private ArrayList<Module> enabled;

    @Override
    public void onEnable() {
        enabled = new ArrayList<>();

        IllusionClient.getInstance()
                .getModuleManager().getElements()
                .forEach(module -> {
                    if (module.isEnabled()) enabled.add(module);
                });

        // TODO: add length sort, later
        enabled.sort(Comparator.comparing(Module::getName));
    }

    @Listen
    public void onRender2D(Render2DEvent event) {
        int y = 5;

        for (Module module : enabled) {
            FontUtils.drawString(module.getName(), 5, y, Theme.getMainColor().getRGB());
            y += FontUtils.HEIGHT + 1;
        }
    }

    @Listen
    public void onModuleEnabled(ModuleEnabledEvent event) {
        // to avoid having two "ModOverlay" modules
        // although ill probably remove the visuals category from the list in the future.
        // TODO: Visual category toggle
        if (enabled.contains(event.getModule())) return;

        enabled.add(event.getModule());
        enabled.sort(Comparator.comparing(Module::getName));
    }

    @Listen
    public void onModuleDisabled(ModuleDisabledEvent event) {
        enabled.remove(event.getModule());
    }
}
