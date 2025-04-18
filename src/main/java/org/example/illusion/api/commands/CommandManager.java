package org.example.illusion.api.commands;

import io.github.nevalackin.radbus.Listen;
import org.example.illusion.IllusionClient;
import org.example.illusion.api.Manager;
import org.example.illusion.impl.commands.ToggleCommand;
import org.example.illusion.impl.events.ChatSendEvent;
import org.example.illusion.utils.Wrapper;

import java.util.Arrays;

public class CommandManager extends Manager<Command> {
    public CommandManager() {
        super(Arrays.asList(
                new ToggleCommand()
        ));

        IllusionClient.getInstance().getEventBus().subscribe(this);
    }

    @Override
    public Command getElement(String element) {
        return elements.stream()
                .filter(module -> module.name.equals(element))
                .findFirst()
                .orElse(null);
    }

    @Listen
    public void onChatSend(ChatSendEvent event) {
        String message = event.message;
        if (message.startsWith(".") && message.length() > 1) {
            String[] messages = message.substring(1).split(" ");
            if (messages.length > 0) {
                String cmd = messages[0].toLowerCase();
                String[] args = Arrays.copyOfRange(messages, 1, messages.length);

                Command command = IllusionClient.getInstance().getCommandManager().getElement(cmd);
                if (command != null) {
                    command.execute(args);
                    event.setCancelled();
                } else {
                    Wrapper.addChatMessage("Unknown command: " + cmd);
                }
            }
        }
    }
}
