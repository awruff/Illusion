package org.example.illusion;

import net.minecraftforge.fml.common.Mod;

@Mod(
        modid = Illusion.MODID,
        name = Illusion.NAME,
        version = Illusion.VERSION
)
public class Illusion {
    public static final String MODID = "@MOD_ID@";
    public static final String NAME = "@MOD_NAME@";
    public static final String VERSION = "@MOD_VERSION@";

    @Mod.Instance(MODID)
    public static Illusion INSTANCE;

    public final void initialize() {
        // initialize stuff
    }

    public final void shutdown() {
        // uninitialize stuff (config saving, possibly self destruct?)
    }
}

// TODO: Write module manager
// TODO: Write command manager
// TODO: Write event bus
// TODO: Write events
// TODO: Write docs
