package org.example.illusion.features.clickgui.api.component.impl;

import net.minecraft.client.gui.Gui;
import org.example.illusion.features.clickgui.api.component.api.Component;
import org.example.illusion.features.clickgui.api.component.api.Frame;
import org.example.illusion.features.clickgui.api.component.impl.sub.CheckComponent;
import org.example.illusion.features.clickgui.api.component.impl.sub.ComboComponent;
import org.example.illusion.features.clickgui.api.component.impl.sub.KeybindComponent;
import org.example.illusion.features.clickgui.api.component.impl.sub.SliderComponent;
import org.example.illusion.features.clickgui.api.setting.api.Setting;
import org.example.illusion.features.clickgui.api.setting.impl.CheckSetting;
import org.example.illusion.features.clickgui.api.setting.impl.ComboSetting;
import org.example.illusion.features.clickgui.api.setting.impl.SliderSetting;
import org.example.illusion.features.clickgui.impl.ClickGui;
import org.example.illusion.features.clickgui.impl.Theme;
import org.example.illusion.features.module.api.Module;
import org.example.illusion.utils.FontUtils;
import org.example.illusion.utils.Wrapper;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;

public class ButtonComponent extends Component {
    public Module mod;
    public Frame parent;
    public int offset;
    public boolean open;
    private boolean isHovered;
    private final ArrayList<Component> subcomponents;
    private final int height;

    public ButtonComponent(Module mod, Frame parent, int offset) {
        this.mod = mod;
        this.parent = parent;
        this.offset = offset;
        this.subcomponents = new ArrayList<Component>();
        this.open = false;
        height = 12;

        int y = offset + 12;

        for (Setting setting : mod.getSettings()) {
            if (setting instanceof ComboSetting) {
                this.subcomponents.add(new ComboComponent(this, (ComboSetting) setting, y));
                y += 12;
            }

            if (setting instanceof SliderSetting) {
                this.subcomponents.add(new SliderComponent(this, (SliderSetting) setting, y));
                y += 12;
            }

            if (setting instanceof CheckSetting) {
                this.subcomponents.add(new CheckComponent(this, (CheckSetting) setting, y));
                y += 12;
            }
        }

        this.subcomponents.add(new KeybindComponent(this, mod, y));
    }

    @Override
    public void setOff(int newOff) {
        offset = newOff;
        int opY = offset + 12;
        for (Component comp : this.subcomponents) {
            comp.setOff(opY);
            opY += 12;
        }
    }

    @Override
    public void renderComponent() {
        Gui.drawRect(
                parent.getX(),
                this.parent.getY() + this.offset,
                parent.getX() + parent.getWidth(),
                this.parent.getY() + 12 + this.offset,
                this.isHovered ?
                        (this.mod.isEnabled() ? Theme.getBackColor().darker().getRGB() : Theme.getBackColor().getRGB()) :
                        (this.mod.isEnabled() ? Theme.getBackColor().darker().darker().getRGB() : Theme.getBackColor().darker().getRGB())
        );

        GL11.glPushMatrix();
        GL11.glScalef(0.5f, 0.5f, 0.5f);

        FontUtils.drawString(
                this.mod.getName(),
                (parent.getX() + 2) * 2,
                (parent.getY() + offset + 2) * 2 + 4,
                this.mod.isEnabled() ? Theme.getMainColor().getRGB() : -1
        );

        if (!this.subcomponents.isEmpty()) {
            FontUtils.drawString(
                    this.open ? "-" : "+",
                    (parent.getX() + parent.getWidth() - 10) * 2,
                    (parent.getY() + offset + 2) * 2 + 4
            );
        }

        GL11.glPopMatrix();

        if (this.open) {
            if (!this.subcomponents.isEmpty()) {
                for (Component comp : this.subcomponents) {
                    comp.renderComponent();
                }
                Gui.drawRect(
                        parent.getX() + 2,
                        parent.getY() + this.offset + 12,
                        parent.getX() + 3,
                        parent.getY() + this.offset + ((this.subcomponents.size() + 1) * 12),
                        ClickGui.color
                );
            }
        }
    }

    @Override
    public int getHeight() {
        if (this.open) {
            return (12 * (this.subcomponents.size() + 1));
        }
        return 12;
    }

    @Override
    public void updateComponent(int mouseX, int mouseY) {
        this.isHovered = isHovering(mouseX, mouseY, parent, offset);
        if (!this.subcomponents.isEmpty()) {
            for (Component comp : this.subcomponents) {
                comp.updateComponent(mouseX, mouseY);
            }
        }
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {
        if (isHovering(mouseX, mouseY, parent, offset) && button == 0) {
            this.mod.toggle();
        }
        if (isHovering(mouseX, mouseY, parent, offset) && button == 1) {
            this.open = !this.open;
            this.parent.refresh();
        }
        for (Component comp : this.subcomponents) {
            comp.mouseClicked(mouseX, mouseY, button);
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
        for (Component comp : this.subcomponents) {
            comp.mouseReleased(mouseX, mouseY, mouseButton);
        }
    }

    @Override
    public void keyTyped(char typedChar, int key) {
        for (Component comp : this.subcomponents) {
            comp.keyTyped(typedChar, key);
        }
    }
}
