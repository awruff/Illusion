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
    private final ComboSetting mode = new ComboSetting("Mode", this, new String[]{"One", "Two", "Three"});
    private final SliderSetting slider = new SliderSetting("Slider", this, 1.0f, 10.0f, 5.0f);
    private final CheckSetting check = new CheckSetting("Check", this, true);

    public TestModule() {
        addSetting(mode);
        addSetting(slider);
        addSetting(check);
    }

    @Override
    public void onEnable() {
        Wrapper.addChatMessage("Test module enabled!");
    }

    @Override
    public void onDisable() {
        Wrapper.addChatMessage("Test module disabled!");
    }

    @Override
    public void onUpdate() {
        String modeText = mode.getName() + ": " + mode.getValue();
        String sliderText = slider.getName() + ": " + slider.getValue();
        String checkText = check.getName() + ": " + check.isEnabled();
        Wrapper.addChatMessage(modeText + " " + sliderText + " " + checkText);
    }
}
