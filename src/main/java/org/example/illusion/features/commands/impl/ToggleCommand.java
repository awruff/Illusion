package org.example.illusion.features.commands.impl;

import org.example.illusion.IllusionClient;
import org.example.illusion.features.commands.api.Command;
import org.example.illusion.features.commands.api.CommandInfo;
import org.example.illusion.features.commands.api.CommandUsageException;
import org.example.illusion.features.module.api.Module;
import org.example.illusion.utils.Wrapper;

@CommandInfo(name = "toggle", description = "Toggles provided module.")
public class ToggleCommand extends Command {
    @Override
    public void execute(String[] arguments) throws CommandUsageException {
        if (arguments.length == 2) {
            Module module = IllusionClient.getInstance().getModuleManager().getElement(arguments[1]);

            if (module != null) {
                module.toggle();
                Wrapper.addChatMessage("'" + module.getName() + "' has been " + (module.isEnabled() ? "enabled." : "disabled."));
                return;
            }
        }

        throw new CommandUsageException(getUsage());
    }

    @Override
    public String getUsage() {
        return "toggle <module>";
    }
}
