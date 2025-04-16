package org.example.illusion.features.modules.impl.client;

import org.example.illusion.Illusion;
import org.example.illusion.features.modules.api.Category;
import org.example.illusion.features.modules.api.Module;
import org.example.illusion.features.modules.api.ModuleInfo;
import org.example.illusion.utils.Wrapper;
import org.lwjgl.input.Keyboard;

@ModuleInfo(name = "Test", category = Category.Client, bind = Keyboard.KEY_RSHIFT)
public class TestModule extends Module {
    @Override
    public void onEnable() {
        Wrapper.getClient().displayGuiScreen(Illusion.INSTANCE.getClickGui());
    }
}
