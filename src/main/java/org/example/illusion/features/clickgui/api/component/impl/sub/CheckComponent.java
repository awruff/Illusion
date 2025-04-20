package org.example.illusion.features.clickgui.api.component.impl.sub;

import net.minecraft.client.gui.Gui;
import org.example.illusion.features.clickgui.api.component.api.Component;
import org.example.illusion.features.clickgui.api.component.impl.ButtonComponent;
import org.example.illusion.features.clickgui.api.setting.impl.CheckSetting;
import org.example.illusion.utils.Wrapper;
import org.lwjgl.opengl.GL11;

public class CheckComponent extends Component {

    private final ButtonComponent parent;
    private final CheckSetting setting;

    private int offset;
    private int x;
    private int y;

    private boolean hovered;

    public CheckComponent(ButtonComponent parent, CheckSetting setting, int offset) {
        this.parent = parent;
        this.setting = setting;
        this.offset = offset;

        this.x = parent.parent.getX() + parent.parent.getWidth();
        this.y = parent.parent.getY() + parent.offset;
    }

    @Override
    public void renderComponent() {
        Gui.drawRect(
                parent.parent.getX() + 2,
                parent.parent.getY() + offset,
                parent.parent.getX() + parent.parent.getWidth(),
                parent.parent.getY() + offset + 12,
                this.hovered ? 0xFF222222 : 0xFF111111
        );

        Gui.drawRect(
                parent.parent.getX(),
                parent.parent.getY() + offset,
                parent.parent.getX() + 2,
                parent.parent.getY() + offset + 12,
                0xFF111111
        );

        GL11.glPushMatrix();
        GL11.glScalef(0.5f,0.5f, 0.5f);

        Wrapper.getFontRenderer().drawStringWithShadow(
                this.setting.getName(),
                (parent.parent.getX() + 10 + 4) * 2 + 5,
                (parent.parent.getY() + offset + 2) * 2 + 4,
                -1
        );

        GL11.glPopMatrix();

        Gui.drawRect(
                parent.parent.getX() + 3 + 4,
                parent.parent.getY() + offset + 3,
                parent.parent.getX() + 9 + 4,
                parent.parent.getY() + offset + 9,
                0xFF999999
        );

        if (this.setting.isEnabled()) {
            Gui.drawRect(
                    parent.parent.getX() + 4 + 4,
                    parent.parent.getY() + offset + 4,
                    parent.parent.getX() + 8 + 4,
                    parent.parent.getY() + offset + 8,
                    0xFF666666
            );
        }
    }

    @Override
    public void setOff(int newOff) {
        offset = newOff;
    }

    @Override
    public void updateComponent(int mouseX, int mouseY) {
        this.hovered = isHovering(mouseX, mouseY, parent.parent, offset);
        this.y = parent.parent.getY() + offset;
        this.x = parent.parent.getX();
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {
        if (isHovering(mouseX, mouseY, parent.parent, offset) && button == 0 && parent.open) {
            setting.setEnabled(!setting.isEnabled());
        }
    }
}