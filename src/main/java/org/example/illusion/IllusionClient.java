package org.example.illusion;

import io.github.nevalackin.radbus.PubSub;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.example.illusion.api.commands.CommandManager;
import org.example.illusion.api.events.types.Event;
import org.example.illusion.api.modules.ModuleManager;
import org.example.illusion.impl.gui.ClickGui;

@Mod(
        modid = IllusionClient.ID,
        name = IllusionClient.NAME,
        version = IllusionClient.VERSION
)
public final class IllusionClient {
    public static final String ID = "@MOD_ID@";
    public static final String NAME = "@MOD_NAME@";
    public static final String VERSION = "@MOD_VERSION@";

    @Mod.Instance(ID)
    private static IllusionClient INSTANCE;

    private ModuleManager moduleManager;
    private CommandManager commandManager;
    private PubSub<Event> eventBus;
    private ClickGui clickGui;

    @Mod.EventHandler
    public void onInitialization(FMLInitializationEvent event) {
        eventBus = PubSub.newInstance(System.err::println);
        moduleManager = new ModuleManager();
        commandManager = new CommandManager();
        clickGui = new ClickGui();
    }

    public static IllusionClient getInstance() {
        return INSTANCE;
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

// TODO: Write own eventbus
// TODO: Create settings api
// TODO: More events
// TODO: Click gui
