package org.example.illusion;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(
        modid = IllusionClient.ID,
        name = IllusionClient.NAME,
        version = IllusionClient.VERSION
)
public final class IllusionClient {
    public static final String ID = "@MOD_ID@";
    public static final String NAME = "@MOD_NAME@";
    public static final String VERSION = "@MOD_VERSION@";

    @Mod.Instance(ID)
    private static IllusionClient INSTANCE;

    @Mod.EventHandler
    public void onInitialization(FMLInitializationEvent event) {
    }

    public static IllusionClient getInstance() {
        return INSTANCE;
    }
}
