package org.example.illusion.features.commands.api;

import org.apache.commons.lang3.Validate;

public abstract class Command {
    public final String name;
    public final String[] aliases;
    public final String description;

    public Command() {
        CommandInfo info = Validate.notNull(this.getClass().getAnnotation(CommandInfo.class), "Missing Annotation");

        this.name = info.name();
        this.aliases = info.aliases();
        this.description = info.description();
    }

    public abstract void main(String[] args);
}