package org.example.illusion.features.module.impl.misc;

import org.example.illusion.features.module.api.Category;
import org.example.illusion.features.module.api.Module;
import org.example.illusion.features.module.api.ModuleInfo;
import org.example.illusion.utils.Wrapper;
import org.lwjgl.input.Keyboard;

@ModuleInfo(name = "Test", category = Category.MISC, bind = Keyboard.KEY_R)
public class TestModule extends Module {
    @Override
    public void onEnable() {
        Wrapper.addChatMessage("Test module enabled!");
    }

    @Override
    public void onDisable() {
        Wrapper.addChatMessage("Test module disabled!");
    }
}
