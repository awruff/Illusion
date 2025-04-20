package org.example.illusion.features.clickgui.impl;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import org.example.illusion.IllusionClient;
import org.example.illusion.features.clickgui.api.component.impl.CheckComponent;
import org.example.illusion.features.clickgui.api.component.impl.ComboComponent;
import org.example.illusion.features.clickgui.api.component.impl.SliderComponent;
import org.example.illusion.features.clickgui.api.setting.api.Setting;
import org.example.illusion.features.clickgui.api.setting.impl.CheckSetting;
import org.example.illusion.features.clickgui.api.setting.impl.ComboSetting;
import org.example.illusion.features.clickgui.api.setting.impl.SliderSetting;
import org.example.illusion.features.module.api.Category;
import org.example.illusion.features.module.api.Module;
import org.example.illusion.features.clickgui.api.component.api.Component;
import org.example.illusion.utils.Wrapper;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ClickGui extends GuiScreen {

    public float posX, posY, width, height, dragX, dragY;
    public boolean dragging;
    public Category selectedCategory;

    private Module selectedModule;
    public int modeIndex;

    public ArrayList<Component> components = new ArrayList<>();

    public ClickGui() {
        dragging = false;
        posX = getScaledRes().getScaledWidth() / 2f - 150f;
        posY = getScaledRes().getScaledHeight() / 2f - 100f;
        width = posX + 150 * 2f;
        height = height + 200f;
        selectedCategory = Category.COMBAT;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);

        drawDefaultBackground();

        if (dragging) {
            posX = mouseX - dragX;
            posY = mouseY - dragY;
        }
        width = posX + 150 * 2;
        height = posY + 200;

        Gui.drawRect(
                (int) posX,
                (int) (posY - 10),
                (int) width,
                (int) posY,
                new Color(100,10,100).getRGB()
        );

        Gui.drawRect(
                (int) posX,
                (int) posY,
                (int) width,
                (int) height,
                new Color(45,45,45).getRGB()
        );

        int offset = 0;

        for (Category category : Category.values()) {
            Gui.drawRect(
                    (int) posX,
                    (int) (posY + 1 + offset),
                    (int) (posX + 60),
                    (int) (posY + 15 + offset),
                    category.equals(selectedCategory) ? new Color(230,10,230).getRGB() : new Color(28,28,28).getRGB()
            );

            fontRendererObj.drawString(category.name(),(int)posX + 2, (int)(posY + 5) + offset, new Color(170,170,170).getRGB());

            offset += 15;
        }

        offset = 0;

        for (Module module : IllusionClient.getInstance().getModuleManager().getElements(selectedCategory)) {
            Gui.drawRect(
                    (int) (posX + 65),
                    (int) (posY + 1 + offset),
                    (int) (posX + 125),
                    (int) (posY + 15 + offset),
                    module.isEnabled() ? new Color(230,10,230).getRGB() : new Color(28,28,28).getRGB()
            );

            fontRendererObj.drawString(module.getName(),(int)posX + 67, (int)(posY + 5) + offset, new Color(170,170,170).getRGB());

            offset += 15;
        }

        for (Component component : components) {
            component.drawScreen(mouseX, mouseY);
        }

    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar, keyCode);

        for (Component component : components) {
            component.keyTyped(typedChar, keyCode);
        }
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        if (isInside(mouseX, mouseY, posX, posY - 10, width, posY) && mouseButton == 0) {
            dragging = true;
            dragX = mouseX - posX;
            dragY = mouseY - posY;
        }
        int offset = 0;
        for (Category category : Category.values()) {
            if (isInside(mouseX, mouseY,posX,posY + 1 + offset,posX + 60,posY + 15 + offset) && mouseButton == 0) {
                selectedCategory = category;
            }
            offset += 15;
        }
        offset = 0;
        for (Module m : IllusionClient.getInstance().getModuleManager().getElements(selectedCategory)) {
            if (isInside(mouseX, mouseY,posX + 65,posY + 1 + offset,posX + 125,posY + 15 + offset)) {
                if (mouseButton == 0) {
                    m.toggle();
                }
                if (mouseButton == 1) {
                    int sOffset = 3;
                    components.clear();
                    if (m.getSettings() != null)
                        for (Setting setting : m.getSettings()) {
                            selectedModule = m;
                            if (setting instanceof ComboSetting) {
                                components.add(new ComboComponent(275, sOffset, this, selectedModule, (ComboSetting) setting));
                                sOffset += 15;
                            }
                            if (setting instanceof CheckSetting) {
                                components.add(new CheckComponent(275, sOffset, this, selectedModule, (CheckSetting) setting));
                                sOffset += 15;
                            }
                            if (setting instanceof SliderSetting) {
                                components.add(new SliderComponent(275, sOffset, this, selectedModule, (SliderSetting) setting));
                                sOffset += 25;
                            }
                        }
                }
            }
            offset += 15;
        }
        for (Component comp : components) {
            comp.mouseClicked(mouseX, mouseY, mouseButton);
        }
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        super.mouseReleased(mouseX, mouseY, state);
        dragging = false;
        for (Component comp : components) {
            comp.mouseReleased(mouseX, mouseY, state);
        }
    }

    @Override
    public void initGui() {
        super.initGui();
        dragging = false;
    }

    @Override
    public void onGuiClosed() {
        IllusionClient.getInstance().getModuleManager().getElement("ClickGui").setEnabled(false);
    }

    public boolean isInside(int mouseX, int mouseY, double x, double y, double x2, double y2) {
        return (mouseX > x && mouseX < x2) && (mouseY > y && mouseY < y2);
    }

    public ScaledResolution getScaledRes() {
        return new ScaledResolution(Wrapper.getClient());
    }
}
