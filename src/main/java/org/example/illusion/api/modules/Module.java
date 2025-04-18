package org.example.illusion.api.modules;

import org.apache.commons.lang3.Validate;
import org.example.illusion.IllusionClient;

public abstract class Module {
    private final String name;
    private final Category category;

    private int bind;
    private boolean enabled;

    public Module() {
        ModuleInfo info = Validate.notNull(this.getClass().getAnnotation(ModuleInfo.class), "Missing Annotation");

        this.name = info.name();
        this.category = info.category();
        this.bind = info.bind();
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public final int getBind() {
        return bind;
    }

    public final void setBind(final int bind) {
        this.bind = bind;
    }

    public final void enable() {
        setEnabled(true);
    }

    public final void disable() {
        setEnabled(false);
    }

    public final boolean toggle() {
        return setEnabled(!enabled);
    }

    public final boolean setEnabled(final boolean enabled) {
        this.enabled = enabled;

        if (enabled) {
            IllusionClient.getInstance().getEventBus().subscribe(this);
            onEnable();
        } else {
            IllusionClient.getInstance().getEventBus().unsubscribe(this);
            onDisable();
        }

        return enabled;
    }

    public void onEnable() {}

    public void onDisable() {}
}