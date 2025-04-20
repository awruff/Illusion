package org.example.illusion.features.clickgui.api.component.api;

import org.example.illusion.features.module.api.Module;
import org.example.illusion.features.clickgui.impl.ClickGui;
import org.example.illusion.features.clickgui.api.setting.api.Setting;

public abstract class Component {
    public float x, y, x2, y2;
    public ClickGui parent;
    public Module module;
    public Setting setting;

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
    }

    public void mouseReleased(int mouseX, int mouseY, int state) {
    }

    public void drawScreen(int mouseX, int mouseY) {
    }

    public void keyTyped(char typedChar, int keyCode) {
    }

    public final boolean isHovering(int mouseX, int mouseY, float x, float y, float x2, float y2) {
        return (mouseX > x && mouseX < x2) && (mouseY > y && mouseY < y2);
    }
}
