package org.example.illusion.impl.commands;

import org.example.illusion.IllusionClient;
import org.example.illusion.api.commands.Command;
import org.example.illusion.api.commands.CommandInfo;
import org.example.illusion.utils.Wrapper;

import java.util.List;

@CommandInfo(name = "help", description = "Shows this menu.")
public class HelpCommand extends Command {
    @Override
    public void execute(String[] args) {
        List<Command> commands = IllusionClient.getInstance().getCommandManager().getElements();

        for (Command command : commands) {
            Wrapper.addChatMessage(command.name + " " + command.description);
        }
    }

    @Override
    public String getUsage() {
        return "help";
    }
}
