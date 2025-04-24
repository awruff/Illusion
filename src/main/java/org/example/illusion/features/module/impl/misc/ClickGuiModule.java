package org.example.illusion.features.module.impl.misc;

import org.example.illusion.IllusionClient;
import org.example.illusion.features.module.api.Category;
import org.example.illusion.features.module.api.Module;
import org.example.illusion.features.module.api.ModuleInfo;
import org.example.illusion.utils.Wrapper;
import org.lwjgl.input.Keyboard;

@ModuleInfo(name = "ClickGui", category = Category.MISC, bind = Keyboard.KEY_RSHIFT)
public class ClickGuiModule extends Module {
    @Override
    public void onEnable() {
        Wrapper.getClient().displayGuiScreen(IllusionClient.getInstance().getClickGui());
    }

    @Override
    public void onDisable() {
        Wrapper.getClient().displayGuiScreen(null);
    }
}

