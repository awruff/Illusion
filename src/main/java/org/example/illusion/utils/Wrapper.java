package org.example.illusion.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
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
        // TODO: Write system so color codes are easier
        getPlayer().addChatMessage(new ChatComponentText("\2478[\2475Illusion\2478]\2477 " + message));
    }

    public static FontRenderer getFontRenderer() {
        return getClient().fontRendererObj;
    }
}
