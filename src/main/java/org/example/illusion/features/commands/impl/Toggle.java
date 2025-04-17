package org.example.illusion.features.commands.impl;

import org.example.illusion.Illusion;
import org.example.illusion.features.commands.api.Command;
import org.example.illusion.features.commands.api.CommandInfo;
import org.example.illusion.features.modules.api.Module;
import org.example.illusion.utils.Wrapper;

@CommandInfo(name = "toggle", description = "Toggles the provided module.")
public class Toggle extends Command {

    // FIXME: Doesnt open the GUI
    @Override
    public void main(String[] args) {
        if (args.length != 1) {
            Wrapper.addChatMessage("Error: Invalid syntax; .toggle <module>");
            return;
        }

        Module module = Illusion.INSTANCE.getModuleManager().getModule(args[0]);

        if (module == null) {
            Wrapper.addChatMessage("Error: Invalid module.");
            return;
        }

        String value = module.toggle()? "enabled" : "disabled";
        Wrapper.addChatMessage(module.getName() + " is now " + value);
    }
}
