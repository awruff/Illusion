package org.example.illusion.features.commands.impl;

import org.example.illusion.IllusionClient;
import org.example.illusion.features.commands.api.Command;
import org.example.illusion.features.commands.api.CommandInfo;
import org.example.illusion.utils.Wrapper;

@CommandInfo(name = "help", description = "Lists all available commands.")
public class HelpCommand extends Command {
    @Override
    public void execute(String[] arguments) {
        Wrapper.addChatMessage("Available Commands:");
        for (Command command : IllusionClient.getInstance().getCommandManager().getElements()) {
            if (command == this) continue;
            Wrapper.addChatMessage(command.getUsage() + ", " + command.getDescription());
        }
    }

    @Override
    public String getUsage() {
        return "help";
    }
}
