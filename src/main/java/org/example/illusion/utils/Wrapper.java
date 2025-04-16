package org.example.illusion.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
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
}
