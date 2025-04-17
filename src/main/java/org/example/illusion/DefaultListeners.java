package org.example.illusion;

import io.github.nevalackin.radbus.Listen;
import org.example.illusion.features.commands.api.Command;
import org.example.illusion.features.events.impl.ChatSendEvent;
import org.example.illusion.features.events.impl.KeyPressEvent;

import java.util.Arrays;

// events that are registered at initialization and unregistered at shutdown.
public class DefaultListeners {
    @Listen
    public void keyPresses(KeyPressEvent event) {
        if (event.keycode == 0) return;

        Illusion.INSTANCE.getModuleManager().getModules().values()
                .forEach(module -> {
                    if (module.getBind() == event.keycode) module.toggle();
                });
    }

    // TODO: Possibly better implementation?
    @Listen
    public void chatSent(ChatSendEvent event) {
        String message = event.message;
        if (message.startsWith(".")) {
            String[] messages = message.substring(1).split(" ");

            String cmd = messages[0];
            String[] args = Arrays.copyOfRange(messages, 1, messages.length);

            Command command = Illusion.INSTANCE.getCommandManager().getCommand(cmd);
            if (command != null) {
                command.main(args);
                event.setCancelled();
            }
        }
    }
}
