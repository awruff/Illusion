package org.example.illusion.mixins.events;

import net.minecraft.client.Minecraft;
import org.example.illusion.IllusionClient;
import org.example.illusion.event.impl.player.HitDelayEvent;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Minecraft.class)
public class Minecraft_HitDelay {
    @Redirect(
            method = "clickMouse",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/client/Minecraft;leftClickCounter:I",
                    opcode = Opcodes.PUTFIELD
            )
    )
    private void illusion$publishHitDelay(Minecraft instance, int value) {
        HitDelayEvent event = new HitDelayEvent();
        IllusionClient.getInstance().getEventBus().publish(event);
        value = event.getHitDelay();
    }
}
