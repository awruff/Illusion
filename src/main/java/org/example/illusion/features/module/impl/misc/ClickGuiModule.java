package org.example.illusion.features.module.impl.misc;

import org.example.illusion.IllusionClient;
import org.example.illusion.features.clickgui.api.setting.impl.ComboSetting;
import org.example.illusion.features.module.api.Category;
import org.example.illusion.features.module.api.Module;
import org.example.illusion.features.module.api.ModuleInfo;
import org.example.illusion.utils.Wrapper;
import org.lwjgl.input.Keyboard;

@ModuleInfo(name = "ClickGui", category = Category.MISC, bind = Keyboard.KEY_RSHIFT)
public class ClickGuiModule extends Module {
    public ComboSetting theme = new ComboSetting("Theme", this, new String[]{"Illusion", "Amethyst", "Orange", "White"});

    public ClickGuiModule() {
        addSetting(theme);
    }

    @Override
    public void onEnable() {
        Wrapper.getClient().displayGuiScreen(IllusionClient.getInstance().getClickGui());
    }

    @Override
    public void onDisable() {
        Wrapper.getClient().displayGuiScreen(null);
    }
}

