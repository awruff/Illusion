package org.example.illusion;

import io.github.nevalackin.radbus.PubSub;
import net.minecraftforge.fml.common.Mod;
import org.example.illusion.features.commands.api.CommandManager;
import org.example.illusion.features.events.api.Event;
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
    private PubSub<Event> eventBus;
    private ClickGui clickGui;
    private DefaultListeners listeners;

    public final void initialize() {
        moduleManager = new ModuleManager();
        commandManager = new CommandManager();

        eventBus = PubSub.newInstance(System.err::println);
        eventBus.subscribe(listeners = new DefaultListeners());

        clickGui = new ClickGui();
    }

    public final void shutdown() {
        moduleManager = null;
        commandManager = null;

        eventBus.unsubscribe(listeners);
        eventBus = null;

        clickGui = null;
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public PubSub<Event> getEventBus() {
        return eventBus;
    }

    public ClickGui getClickGui() {
        return clickGui;
    }
}

// TODO: Write events
