package org.example.illusion.modules.api;

import net.minecraftforge.common.MinecraftForge;

import java.util.ArrayList;

public abstract class Module {
    /** The name of the module. */
    private final String name;

    /** The category this module belongs to. */
    private final Category category;

    /** A list of settings registered to this module. */
    private final ArrayList<String> settings;

    /** The bind for activating this module. */
    private int bind;

    /** Indicates if the module is currently enabled. */
    private boolean enabled;

    /**
     * Constructs a Module with a specified name and category.
     *
     * @param name     the name of the module
     * @param category the category this module belongs to
     */
    public Module(final String name, final Category category) {
        this.name = name;
        this.category = category;

        this.bind = 0;
        this.settings = new ArrayList<>();
    }

    /**
     * Constructs a Module with a specified name, category, and bind.
     *
     * @param name     the name of the module
     * @param category the category the module belongs to
     * @param bind     the bind for the module
     */
    public Module(final String name, final Category category, final int bind) {
        this.name = name;
        this.category = category;
        this.bind = bind;

        this.settings = new ArrayList<>();
    }

    /**
     * Enables the module.
     */
    public final void enable() {
        enabled = true;
    }

    /**
     * Disables the module.
     */
    public final void disable() {
        enabled = false;
    }

    /**
     * Toggles the module.
     *
     * @return the new state of the module
     */
    public final boolean toggle() {
        return enabled = !enabled;
    }

    public final void setEnabled(final boolean enabled) {
        if (this.enabled == enabled) {
            return;
        } else {
            this.enabled = enabled;
        }

        if (this.enabled) {
            MinecraftForge.EVENT_BUS.register(this);
            onEnable();
        } else {
            MinecraftForge.EVENT_BUS.unregister(this);
            onDisable();
        }
    }

    /**
     * Gets the key bind for this module.
     *
     * @return the bind keycode
     */
    public final int getBind() {
        return bind;
    }

    /**
     * Sets the key bind for this module.
     *
     * @param bind the new bind keycode
     */
    public final void setBind(final int bind) {
        this.bind = bind;
    }

    /**
     * Registers a new setting for this module.
     *
     * @param setting the setting to register
     */
    protected final void register(final String setting) {
        settings.add(setting);
    }

    /**
     * @return a list of registered settings.
     */
    public final ArrayList<String> getSettings() {
        return settings;
    }

    public void onEnable() {}
    public void onDisable() {}
}
