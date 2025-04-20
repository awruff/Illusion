package org.example.illusion.features.module.api;

import org.apache.commons.lang3.Validate;
import org.example.illusion.features.api.Feature;

public class Module extends Toggleable implements Feature {
    private final String name;
    private final String description;
    private final Category category;
    private int bind;

    public Module() {
        ModuleInfo info = Validate.notNull(this.getClass().getAnnotation(ModuleInfo.class), "Missing Annotation");

        this.name = info.name();
        this.description = info.description();
        this.category = info.category();
        this.bind = info.bind();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public int getBind() {
        return bind;
    }

    public void setBind(int bind) {
        this.bind = bind;
    }
}
