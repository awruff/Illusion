package org.example.illusion.features.commands.impl;

import org.example.illusion.IllusionClient;
import org.example.illusion.features.commands.api.Command;
import org.example.illusion.features.commands.api.CommandInfo;
import org.example.illusion.features.commands.api.CommandUsageException;
import org.example.illusion.features.module.api.Module;
import org.example.illusion.utils.Wrapper;
import org.lwjgl.input.Keyboard;

@CommandInfo(name = "bind", description = "Sets a provided module's bind.")
public class BindCommand extends Command {
    @Override
    public void execute(String[] arguments) throws CommandUsageException {
        if(arguments.length != 3)
            throw new CommandUsageException(getUsage());

        Module module = IllusionClient.getInstance().getModuleManager().getElement(arguments[1]);
        int bind = Keyboard.getKeyIndex(arguments[2].toUpperCase());

        if(module == null) {
            Wrapper.addChatMessage(arguments[1] + " is an invalid module");
            return;
        }

        module.setBind(bind);
        Wrapper.addChatMessage(String.format("Bound %s to %s", module.getName(), bind == 0 ? "NONE" : arguments[2].toUpperCase()));
    }

    @Override
    public String getUsage() {
        return "bind <module> <key>";
    }
}
