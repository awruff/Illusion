package org.example.illusion.modules.api;

import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;

public abstract class Module {
    /** Module name */
    private final String name;

    /** Module category */
    private final Category category;

    /** Registered settings */
    private final ArrayList<String> settings;

    /** Bind for toggling the module */
    private int bind;

    /** Whether the module is enabled */
    private boolean enabled;

    /**
     * Creates a new module.
     *
     * @param name     Module name
     * @param category Module category
     */
    public Module(final String name, final Category category) {
        this.name = name;
        this.category = category;
        this.bind = 0;
        this.settings = new ArrayList<>();
    }

    /**
     * Creates a new module with a key bind.
     *
     * @param name     Module name
     * @param category Module category
     * @param bind     Module default bind
     */
    public Module(final String name, final Category category, final int bind) {
        this.name = name;
        this.category = category;
        this.bind = bind;
        this.settings = new ArrayList<>();
    }

    /** Enables the module */
    public final void enable() {
        setEnabled(true);
    }

    /** Disables the module */
    public final void disable() {
        setEnabled(false);
    }

    /**
     * Toggles the module.
     *
     * @return new state
     */
    public final boolean toggle() {
        return setEnabled(!enabled);
    }

    /**
     * Enables or disables the module.
     *
     * @param enabled current enabled status
     */
    public final boolean setEnabled(final boolean enabled) {
        this.enabled = enabled;

        if (enabled) {
            MinecraftForge.EVENT_BUS.register(this);
            onEnable();
        } else {
            MinecraftForge.EVENT_BUS.unregister(this);
            onDisable();
        }

        return enabled;
    }

    /**
     * @return current bind
     */
    public final int getBind() {
        return bind;
    }

    /**
     * Sets the bind.
     *
     * @param bind the key
     */
    public final void setBind(final int bind) {
        this.bind = bind;
    }

    /**
     * Registers a new setting.
     *
     * @param setting Setting name
     */
    protected final void register(final String setting) {
        settings.add(setting);
    }

    /**
     * @return List of settings
     */
    public final ArrayList<String> getSettings() {
        return settings;
    }

    /** Called when the module is enabled */
    public void onEnable() {}

    /** Called when the module is disabled */
    public void onDisable() {}
}