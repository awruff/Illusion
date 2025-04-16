package org.example.illusion.features.gui;

import net.minecraft.client.gui.GuiScreen;

public class ClickGui extends GuiScreen {
    public void drawScreen(int x, int y, float delta) {
        drawDefaultBackground();

        System.out.println(x + " " + y + " " + delta);
    }
}
