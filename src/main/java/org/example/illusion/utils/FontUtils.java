package org.example.illusion.utils;

public class FontUtils {
    public static final int HEIGHT = Wrapper.getFontRenderer().FONT_HEIGHT;

    public static int drawString(String text, float x, float y) {
        return drawString(text, x, y, -1);
    }

    public static int drawString(String text, float x, float y, int color) {
        return Wrapper.getFontRenderer().drawStringWithShadow(text, x, y, color);
    }
}
