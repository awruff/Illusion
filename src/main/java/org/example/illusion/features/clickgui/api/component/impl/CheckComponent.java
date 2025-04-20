package org.example.illusion.features.clickgui.api.component.impl;

import net.minecraft.client.gui.Gui;
import org.example.illusion.features.clickgui.api.component.api.Component;
import org.example.illusion.features.clickgui.api.setting.impl.CheckSetting;
import org.example.illusion.features.clickgui.impl.ClickGui;
import org.example.illusion.features.module.api.Module;
import org.example.illusion.utils.Wrapper;

import java.awt.*;

public class CheckComponent extends Component {
    private final CheckSetting checkSetting;

    public CheckComponent(float x, float y, ClickGui parent, Module module, CheckSetting setting) {
        this.x = x;
        this.y = y;
        this.parent = parent;
        this.module = module;
        this.setting = setting;
        this.checkSetting = setting;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY) {
        super.drawScreen(mouseX, mouseY);

        Gui.drawRect(
                (int) (parent.posX + x - 70),
                (int) (parent.posY + y),
                (int) (parent.posX + x + 10 - 70),
                (int) (parent.posY + y + 10),
                checkSetting.isEnabled() ? new Color(230,10,230).getRGB() : new Color(30,30,30).getRGB()
        );

        Wrapper.getFontRenderer().drawString(
                checkSetting.getName(),
                (int)(parent.posX + x - 55),
                (int)(parent.posY + y + 1),
                new Color(200,200,200).getRGB()
        );
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        if (isHovering(
                mouseX, mouseY,
                parent.posX + x - 70f, parent.posY + y,
                parent.posX + x + 10f - 70f, parent.posY + y + 10f
        ) && mouseButton == 0) {
            checkSetting.setEnabled(!checkSetting.isEnabled());
        }
    }
}
