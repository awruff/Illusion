package org.example.illusion;

import net.minecraftforge.fml.common.Mod;
import org.example.illusion.features.commands.api.CommandManager;
import org.example.illusion.features.gui.ClickGui;
import org.example.illusion.features.modules.api.ModuleManager;

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

    private ModuleManager moduleManager;
    private CommandManager commandManager;
    private ClickGui clickGui;

    public final void initialize() {
        // initialize stuff
        moduleManager = new ModuleManager();
        clickGui = new ClickGui();
    }

    public final void shutdown() {
        // uninitialize stuff (config saving, possibly self destruct?)
        moduleManager = null;
        clickGui = null;
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public ClickGui getClickGui() {
        return clickGui;
    }
}

// TODO: Write module manager
// TODO: Write command manager
// TODO: Write event bus
// TODO: Write events
// TODO: Write docs
