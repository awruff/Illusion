package org.example.illusion.features.clickgui.api.component.impl;

import net.minecraft.client.gui.Gui;
import org.example.illusion.features.clickgui.api.component.api.Component;
import org.example.illusion.features.clickgui.api.setting.impl.SliderSetting;
import org.example.illusion.features.clickgui.impl.ClickGui;
import org.example.illusion.features.module.api.Module;
import org.example.illusion.utils.Wrapper;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SliderComponent extends Component {
    private boolean dragging = false;
    private float renderWidth, renderWidth2;

    private final SliderSetting sliderSetting;

    public SliderComponent(float x, float y, ClickGui parent, Module module, SliderSetting setting) {
        this.x = x;
        this.y = y;
        this.parent = parent;
        this.module = module;
        this.setting = setting;
        this.sliderSetting = setting;
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        super.mouseClicked(mouseX, mouseY, mouseButton);

        if (isHovering(
                mouseX, mouseY,
                parent.posX + x - 70, parent.posY + y + 10,
                parent.posX + x - 70 + renderWidth2, parent.posY + y + 20
        ) && mouseButton == 0) {
            dragging = true;
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int state) {
        super.mouseReleased(mouseX, mouseY, state);
        dragging = false;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY) {
        super.drawScreen(mouseX, mouseY);

        float min = sliderSetting.getMin();
        float max = sliderSetting.getMax();
        float l = 90;

        renderWidth = (l) * (sliderSetting.getValue() - min) / (max - min);
        renderWidth2 = (l) * (sliderSetting.getMax() - min) / (max - min);

        float diff = Math.min(l, Math.max(0, mouseX - (parent.posX + x - 70)));
        if (dragging) {
            if (diff == 0) {
                sliderSetting.setValue(sliderSetting.getMin());
            }
            else {
                float newValue = roundToPlace(((diff / l) * (max - min) + min));
                sliderSetting.setValue(newValue);
            }
        }

        Gui.drawRect(
                (int) (parent.posX + x - 70),
                (int) (parent.posY + y + 10),
                (int) (parent.posX + x - 70 + renderWidth2),
                (int) (parent.posY + y + 20),
                new Color(230,10,230).darker().getRGB()
        );

        Gui.drawRect(
                (int) (parent.posX + x - 70),
                (int) (parent.posY + y + 10),
                (int) (parent.posX + x - 70 + renderWidth),
                (int) (parent.posY + y + 20),
                new Color(230,10,230).getRGB()
        );

        Wrapper.getFontRenderer().drawString(
                setting.getName() + ": " + sliderSetting.getValue(),
                (int)(parent.posX + x - 70),
                (int)(parent.posY + y),
                -1
        );
    }

    private float roundToPlace(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(1, RoundingMode.HALF_UP);
        return bd.floatValue();
    }
}
