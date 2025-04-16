package org.example.illusion.features.commands.api;

import org.example.illusion.features.commands.impl.Toggle;

import java.util.HashMap;

public class CommandManager {
    private final HashMap<String, Command> commands = new HashMap<>();

    public CommandManager() {
        register(new Toggle());
    }

    private void register(Command command) {
        commands.put(command.name, command);
    }

    public Command getCommand(String name) {
        return commands.get(name);
    }

    public HashMap<String, Command> getCommands() {
        return commands;
    }
}
