package org.example.illusion.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import java.util.List;

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

    public static List<EntityPlayer> getLoadedPlayers() {
        return getWorld().playerEntities;
    }

    public static boolean isSinglePlayer() {
        return getClient().isIntegratedServerRunning();
    }

    public static boolean isInFirstPerson() {
        return getSettings().thirdPersonView == 0;
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

    public static int getScale() {
        return getSettings().guiScale;
    }

    public static RenderManager getRenderManager() {
        return getClient().getRenderManager();
    }
}
