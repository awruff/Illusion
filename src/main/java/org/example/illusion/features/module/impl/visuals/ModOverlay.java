package org.example.illusion.features.module.impl.visuals;

import io.github.nevalackin.radbus.Listen;
import org.example.illusion.IllusionClient;
import org.example.illusion.event.impl.client.ModuleDisabledEvent;
import org.example.illusion.event.impl.client.ModuleEnabledEvent;
import org.example.illusion.event.impl.render.Render2DEvent;
import org.example.illusion.features.clickgui.api.setting.impl.CheckSetting;
import org.example.illusion.features.clickgui.api.setting.impl.ComboSetting;
import org.example.illusion.features.clickgui.impl.Theme;
import org.example.illusion.features.module.api.Category;
import org.example.illusion.features.module.api.Module;
import org.example.illusion.features.module.api.ModuleInfo;
import org.example.illusion.utils.ColorUtils;
import org.example.illusion.utils.FontUtils;

import java.util.ArrayList;
import java.util.Comparator;

@ModuleInfo(name = "ModOverlay", category = Category.VISUALS)
public class ModOverlay extends Module {
    private ArrayList<Module> enabled;

    private ComboSetting sorting = new ComboSetting("Sorting", this, new String[]{"Length", "Alphabetical"});
    private CheckSetting hideVisuals = new CheckSetting("Hide Visuals", this, true);

    public ModOverlay() {
        addSetting(sorting);
        addSetting(hideVisuals);
    }

    @Override
    public void onEnable() {
        enabled = new ArrayList<>();

        IllusionClient.getInstance()
                .getModuleManager().getElements()
                .forEach(module -> {
                    if (module.isEnabled()) enabled.add(module);
                });

        sort();
    }

    @Listen
    public void onRender2D(Render2DEvent event) {
        int y = 5;

        for (Module module : enabled) {
            FontUtils.drawString(module.getName(), 5, y, ColorUtils.gradient(Theme.getMainColor(), y).getRGB());
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
        sort();
    }

    @Listen
    public void onModuleDisabled(ModuleDisabledEvent event) {
        enabled.remove(event.getModule());
    }

    @Override
    public void onUpdate() {
        sort();
    }

    private void sort() {
        if (sorting.getValue().equals("Length")) {
            enabled.sort(Comparator.comparing(it -> it.getName().length()));
        } else {
            enabled.sort(Comparator.comparing(Module::getName));
        }
    }
}
