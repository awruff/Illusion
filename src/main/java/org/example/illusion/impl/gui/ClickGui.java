package org.example.illusion.impl.gui;

import net.minecraft.client.gui.GuiScreen;

public class ClickGui extends GuiScreen {
    public void drawScreen(int x, int y, float delta) {
        drawDefaultBackground();

        String debug = x + " " + y + " " + delta;

        fontRendererObj.drawString(debug, 5, 5, 0xffffff);
    }
}
