package org.example.illusion.impl.modules.client;

import org.example.illusion.IllusionClient;
import org.example.illusion.api.modules.Category;
import org.example.illusion.api.modules.Module;
import org.example.illusion.api.modules.ModuleInfo;
import org.example.illusion.utils.Wrapper;
import org.lwjgl.input.Keyboard;

@ModuleInfo(name = "Test", category = Category.Client, bind = Keyboard.KEY_RSHIFT)
public class TestModule extends Module {
    @Override
    public void onEnable() {
        Wrapper.getClient().displayGuiScreen(IllusionClient.getInstance().getClickGui());
    }
}
