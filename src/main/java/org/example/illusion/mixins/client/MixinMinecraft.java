package org.example.illusion.mixins.client;

import net.minecraft.client.Minecraft;
import org.example.illusion.Illusion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Inject(method = "startGame", at = @At(value = "RETURN"))
    private void illusion$initialize(CallbackInfo ci) {
        Illusion.INSTANCE.initialize();
    }

    @Inject(method = "shutdownMinecraftApplet", at = @At(value = "HEAD"))
    private void illusion$shutdown(CallbackInfo ci) {
        Illusion.INSTANCE.shutdown();
    }
}
