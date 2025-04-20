package org.example.illusion.features.clickgui.api.component.impl;

import net.minecraft.client.gui.Gui;
import org.example.illusion.features.clickgui.api.component.api.Component;
import org.example.illusion.features.clickgui.api.setting.impl.ComboSetting;
import org.example.illusion.features.clickgui.impl.ClickGui;
import org.example.illusion.features.module.api.Module;
import org.example.illusion.utils.Wrapper;

import java.awt.*;

public class ComboComponent extends Component {
    private final ComboSetting comboSetting;

    public ComboComponent(float x, float y, ClickGui parent, Module module, ComboSetting setting) {
        this.x = x;
        this.y = y;
        this.parent = parent;
        this.module = module;
        this.setting = setting;
        this.comboSetting = setting;
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        if (isHovering(
                mouseX, mouseY,
                parent.posX + x - 70, parent.posY + y,
                parent.posX + x, parent.posY + y + 10
        ) && mouseButton == 0) {
            int max = comboSetting.getOptions().length;
            if (parent.modeIndex + 1 >= max) {
                parent.modeIndex = 0;
            } else {
                parent.modeIndex++;
            }
            comboSetting.setValue(comboSetting.getOptions()[(parent.modeIndex)]);
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY) {
        super.drawScreen(mouseX, mouseY);

        Gui.drawRect(
                (int) (parent.posX + x - 70f),
                (int) (parent.posY + y),
                (int) (parent.posX + x),
                (int) (parent.posY + y + 10f),
                new Color(30,30,30).getRGB()
        );

        Wrapper.getFontRenderer().drawString(
                setting.getName() + ": " + comboSetting.getValue(),
                (int)(parent.posX + x - 69),
                (int)(parent.posY + y + 1),
                new Color(200,200,200).getRGB()
        );
    }
}
