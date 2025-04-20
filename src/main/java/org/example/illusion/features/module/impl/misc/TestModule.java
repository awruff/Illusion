package org.example.illusion.features.module.impl.misc;

import org.example.illusion.features.clickgui.api.setting.impl.CheckSetting;
import org.example.illusion.features.clickgui.api.setting.impl.ComboSetting;
import org.example.illusion.features.clickgui.api.setting.impl.SliderSetting;
import org.example.illusion.features.module.api.Category;
import org.example.illusion.features.module.api.Module;
import org.example.illusion.features.module.api.ModuleInfo;
import org.example.illusion.utils.Wrapper;
import org.lwjgl.input.Keyboard;

@ModuleInfo(name = "Test", category = Category.MISC, bind = Keyboard.KEY_R)
public class TestModule extends Module {
    public TestModule() {
        addSetting(new ComboSetting("Mode", this, new String[]{"One", "Two", "Three"}));
        addSetting(new SliderSetting("Slider", this, 1.0f, 10.0f, 5.0f));
        addSetting(new CheckSetting("Check", this, true));
    }

    @Override
    public void onEnable() {
        Wrapper.addChatMessage("Test module enabled!");
    }

    @Override
    public void onDisable() {
        Wrapper.addChatMessage("Test module disabled!");
    }
}
