package org.example.illusion.utils;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.util.AxisAlignedBB;

import static org.lwjgl.opengl.GL11.*;

public class RenderUtils {
    private static final Frustum FRUSTUM = new Frustum();

    public static int drawString(String text, float x, float y) {
        return drawString(text, x, y, -1);
    }

    public static int drawString(String text, float x, float y, int color) {
        return Wrapper.getFontRenderer().drawStringWithShadow(text, x, y, color);
    }

    public static boolean isBBInFrustum(AxisAlignedBB aabb) {
        EntityPlayerSP player = Wrapper.getPlayer();
        FRUSTUM.setPosition(player.posX, player.posY, player.posZ);
        return FRUSTUM.isBoundingBoxInFrustum(aabb);
    }

    public static void drawBox(float x, float y, float x2, float y2, float inset, float thickness) {
        float leftStart = x + inset;
        float leftEnd = leftStart + thickness;

        // Left
        glVertex2f(leftStart, y + inset);
        glVertex2f(leftStart, y2 - inset);
        glVertex2f(leftEnd, y2 - inset);
        glVertex2f(leftEnd, y + inset);

        float rightEnd = x2 - inset;
        float rightStart = rightEnd - thickness;

        // Right
        glVertex2f(rightStart, y + inset);
        glVertex2f(rightStart, y2 - inset);
        glVertex2f(rightEnd, y2 - inset);
        glVertex2f(rightEnd, y + inset);

        float topStart = y + inset;
        float topEnd = topStart + thickness;

        // Top
        glVertex2f(leftEnd, topStart);
        glVertex2f(leftEnd, topEnd);
        glVertex2f(rightStart, topEnd);
        glVertex2f(rightStart, topStart);

        float bottomEnd = y2 - inset;
        float bottomStart = bottomEnd - thickness;

        // Bottom
        glVertex2f(leftEnd, bottomStart);
        glVertex2f(leftEnd, bottomEnd);
        glVertex2f(rightStart, bottomEnd);
        glVertex2f(rightStart, bottomStart);
    }
}
