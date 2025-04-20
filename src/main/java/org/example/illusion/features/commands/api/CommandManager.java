package org.example.illusion.features.commands.api;

import io.github.nevalackin.radbus.Listen;
import org.example.illusion.IllusionClient;
import org.example.illusion.event.impl.player.SendMessageEvent;
import org.example.illusion.features.api.Manager;
import org.example.illusion.features.commands.impl.BindCommand;
import org.example.illusion.features.commands.impl.HelpCommand;
import org.example.illusion.features.commands.impl.ToggleCommand;
import org.example.illusion.utils.Wrapper;

import java.util.Arrays;

public class CommandManager extends Manager<Command> {
    public CommandManager() {
        super(Arrays.asList(
                new BindCommand(),
                new HelpCommand(),
                new ToggleCommand()
        ));

        IllusionClient.getInstance().getEventBus().subscribe(this);
    }

    @Listen
    public void onChatSend(SendMessageEvent event) {
        String message = event.getMessage();

        if (message.startsWith(".")) {
            event.setCancelled();
            String removed = message.substring(1);
            String[] arguments = removed.split(" ");
            if (!removed.isEmpty() && arguments.length > 0) {
                Command command = this.getElement(arguments[0]);
                if (command != null) {
                    try {
                        command.execute(arguments);
                    } catch (CommandUsageException e) {
                        Wrapper.addChatMessage("Invalid syntax. " + e.getMessage());
                    }
                } else {
                    Wrapper.addChatMessage("'" + arguments[0] + "' is not a command. Try '.help'");
                }
            } else {
                Wrapper.addChatMessage("No arguments supplied. Try '.help'");
            }
        }
    }
}
