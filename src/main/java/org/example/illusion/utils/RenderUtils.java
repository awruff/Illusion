package org.example.illusion.utils;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

import static org.lwjgl.opengl.GL11.*;
import static net.minecraft.client.renderer.GlStateManager.*;

public class RenderUtils {
    private static final Tessellator tessellator = Tessellator.getInstance();
    private static final WorldRenderer renderer = tessellator.getWorldRenderer();

    public static void drawBox(float[] vertices, float inset, float thickness, int color) {
        disableTexture2D();
        enableBlend();
        blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        GLUtils.color(color);

        glLineWidth(thickness);

        renderer.begin(GL_LINE_LOOP, DefaultVertexFormats.POSITION);
        renderer.pos(vertices[0] + inset, vertices[1] + inset, 0).endVertex();
        renderer.pos(vertices[0] + inset, vertices[3] - inset, 0).endVertex();
        renderer.pos(vertices[2] - inset, vertices[3] - inset, 0).endVertex();
        renderer.pos(vertices[2] - inset, vertices[1] + inset, 0).endVertex();
        tessellator.draw();

        disableBlend();
        enableTexture2D();
    }

    public static void drawGradientRect(float[] vertices, int startColor, int endColor) {
        glDisable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glShadeModel(GL_SMOOTH);
        glBegin(GL_QUADS);

        GLUtils.color(startColor);

        glVertex2f(vertices[0], vertices[1]);

        GLUtils.color(endColor);

        glVertex2f(vertices[0], vertices[3]);
        glVertex2f(vertices[2], vertices[3]);

        GLUtils.color(startColor);

        glVertex2f(vertices[2], vertices[1]);

        glEnd();
        glDisable(GL_BLEND);
        glShadeModel(GL_FLAT);
        glEnable(GL_TEXTURE_2D);
    }
}