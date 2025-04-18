package org.example.illusion.api.commands;

import org.apache.commons.lang3.Validate;

public abstract class Command {
    public final String name;
    public final String description;

    public Command() {
        CommandInfo info = Validate.notNull(this.getClass().getAnnotation(CommandInfo.class), "Missing Annotation");

        this.name = info.name();
        this.description = info.description();
    }

    public abstract void execute(String[] args);

    public abstract String getUsage();
}