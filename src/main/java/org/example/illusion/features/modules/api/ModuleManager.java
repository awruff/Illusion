package org.example.illusion.features.modules.api;

import org.example.illusion.features.modules.impl.client.TestModule;

import java.util.HashMap;

public class ModuleManager {
    private final HashMap<String, Module> modules = new HashMap<>();

    public ModuleManager() {
        register(new TestModule());
    }

    private void register(Module module) {
        modules.put(module.getName(), module);
    }

    public Module getModule(String name) {
        return modules.get(name);
    }

    public HashMap<String, Module> getModules() {
        return modules;
    }
}
