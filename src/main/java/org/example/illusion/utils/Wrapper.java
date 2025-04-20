package org.example.illusion.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class Wrapper {
    public static Minecraft getClient() {
        return Minecraft.getMinecraft();
    }

    public static EntityPlayerSP getPlayer() {
        return getClient().thePlayer;
    }

    public static World getWorld() {
        return getClient().theWorld;
    }

    public static boolean isSinglePlayer() {
        return getClient().isIntegratedServerRunning();
    }

    public static void addChatMessage(String message) {
        String prefix = Colors.DARK_GRAY + "[" + Colors.DARK_PURPLE + "Illusion" + Colors.DARK_GRAY + "]" + Colors.GRAY + " ";
        getPlayer().addChatMessage(new ChatComponentText(prefix + message));
    }

    public static FontRenderer getFontRenderer() {
        return getClient().fontRendererObj;
    }

    public static GuiScreen getScreen() {
        return getClient().currentScreen;
    }

    public static GameSettings getSettings() {
        return getClient().gameSettings;
    }
}
