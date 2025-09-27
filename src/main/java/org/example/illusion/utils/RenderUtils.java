package org.example.illusion.utils;

import static org.lwjgl.opengl.GL11.*;

public class RenderUtils {
    public static void drawBox(float[] vertices, float inset, float thickness, int color) {
        float leftStart = vertices[0] + inset;
        float leftEnd = leftStart + thickness;
        float rightEnd = vertices[2] - inset;
        float rightStart = rightEnd - thickness;
        float bottomEnd = vertices[3] - inset;
        float bottomStart = bottomEnd - thickness;
        float topStart = vertices[1] + inset;
        float topEnd = topStart + thickness;

        glDisable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glBegin(GL_QUADS);

        GLUtils.color(color);

        glVertex2f(leftStart, topStart);
        glVertex2f(leftStart, bottomEnd);
        glVertex2f(leftEnd, bottomEnd);
        glVertex2f(leftEnd, topStart);

        glVertex2f(rightStart, topStart);
        glVertex2f(rightStart, bottomEnd);
        glVertex2f(rightEnd, bottomEnd);
        glVertex2f(rightEnd, topStart);

        glVertex2f(leftEnd, topStart);
        glVertex2f(leftEnd, topEnd);
        glVertex2f(rightStart, topEnd);
        glVertex2f(rightStart, topStart);

        glVertex2f(leftEnd, bottomStart);
        glVertex2f(leftEnd, bottomEnd);
        glVertex2f(rightStart, bottomEnd);
        glVertex2f(rightStart, bottomStart);

        glEnd();
        glDisable(GL_BLEND);
        glEnable(GL_TEXTURE_2D);
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