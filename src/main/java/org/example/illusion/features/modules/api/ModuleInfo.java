package org.example.illusion.features.modules.api;

import org.lwjgl.input.Keyboard;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ModuleInfo {
    String name();
    Category category();
    int bind() default Keyboard.KEY_NONE;
}
