package org.example.illusion.modules.api;

import java.util.ArrayList;

public abstract class Module {
    private final String name;
    private final Category category;
    private final ArrayList<String> settings;
    private int bind;

    private boolean enabled;

    public Module(final String name, final Category category) {
        this.name = name;
        this.category = category;

        this.bind = 0;
        this.settings = new ArrayList<>();
    }

    public Module(final String name, final Category category, final int bind) {
        this.name = name;
        this.category = category;
        this.bind = bind;

        this.settings = new ArrayList<>();
    }

    public final void enable() {
        enabled = true;
    }

    public final void disable() {
        enabled = false;
    }

    public final boolean toggle() {
        return enabled = !enabled;
    }

    public final int getBind() {
        return bind;
    }

    public final void setBind(final int bind) {
        this.bind = bind;
    }

    protected final void register(final String setting) {
        settings.add(setting);
    }

    public final ArrayList<String> getSettings() {
        return settings;
    }
}
