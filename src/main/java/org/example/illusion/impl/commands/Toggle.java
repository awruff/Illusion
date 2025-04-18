package org.example.illusion.impl.commands;

import org.example.illusion.IllusionClient;
import org.example.illusion.api.commands.Command;
import org.example.illusion.api.commands.CommandInfo;
import org.example.illusion.api.modules.Module;
import org.example.illusion.utils.Wrapper;

@CommandInfo(name = "toggle", description = "Toggles the provided module.")
public class Toggle extends Command {

    // FIXME: Can't open the GUI
    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            Wrapper.addChatMessage("Usage: " + getUsage());
            return;
        }

        Module module = IllusionClient.getInstance().getModuleManager().getElement(args[0]);

        if (module == null) {
            Wrapper.addChatMessage("Error: Invalid module.");
            return;
        }

        String value = module.toggle()? "enabled" : "disabled";
        Wrapper.addChatMessage(module.getName() + " is now " + value);
    }

    @Override
    public String getUsage() {
        return "toggle <module>";
    }
}
