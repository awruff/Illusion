package org.example.illusion.features.commands.api;

import org.apache.commons.lang3.Validate;
import org.example.illusion.features.api.Feature;

public abstract class Command implements Feature {
    private final String name;
    private final String description;

    public Command() {
        CommandInfo info = Validate.notNull(this.getClass().getAnnotation(CommandInfo.class), "Missing Annotation");

        this.name = info.name();
        this.description = info.description();
    }

    public abstract void execute(String[] args) throws CommandUsageException;

    public abstract String getUsage();

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final String getDescription() {
        return description;
    }
}
