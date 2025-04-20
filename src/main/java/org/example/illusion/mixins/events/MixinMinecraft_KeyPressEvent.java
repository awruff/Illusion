package org.example.illusion.mixins.events;

import net.minecraft.client.Minecraft;
import org.example.illusion.IllusionClient;
import org.example.illusion.event.impl.input.KeyPressEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft_KeyPressEvent {

    @Inject(method = "runTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;dispatchKeypresses()V"))
    private void illusion$publishKeyPress(CallbackInfo ci) {
        IllusionClient.getInstance().getEventBus().publish(new KeyPressEvent());
    }

}
