package org.example.illusion.mixins.events;

import net.minecraft.client.Minecraft;
import org.example.illusion.IllusionClient;
import org.example.illusion.event.impl.player.HitDelayEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class Minecraft_HitDelay {
    @Shadow private int leftClickCounter;

    @Inject(method = "clickMouse", at = @At("HEAD"))
    private void illusion$publishHitDelay(CallbackInfo ci) {
        HitDelayEvent event = new HitDelayEvent();
        IllusionClient.getInstance().getEventBus().publish(event);
        leftClickCounter = event.getHitDelay();
    }
}
