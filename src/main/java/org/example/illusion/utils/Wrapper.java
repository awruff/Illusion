package org.example.illusion.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.world.World;

/**
 * Basic abstraction for interacting with Minecraft.
 * <p>
 * Also prepares for possible multiversion support later on.
 */
public class Wrapper {
    /** @return the Minecraft client instance */
    public static Minecraft getClient() {
        return Minecraft.getMinecraft();
    }

    /** @return the local player */
    public static EntityPlayerSP getPlayer() {
        return getClient().thePlayer;
    }

    /** @return the current world */
    public static World getWorld() {
        return getClient().theWorld;
    }

    /** @return true if running in singleplayer */
    public static boolean isSinglePlayer() {
        return getClient().isIntegratedServerRunning();
    }
}
