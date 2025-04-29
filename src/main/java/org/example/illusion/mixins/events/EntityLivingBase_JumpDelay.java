package org.example.illusion.mixins.events;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import org.example.illusion.IllusionClient;
import org.example.illusion.event.impl.player.JumpDelayEvent;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EntityLivingBase.class)
public class EntityLivingBase_JumpDelay {
    @Redirect(
            method = "onLivingUpdate",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/entity/EntityLivingBase;jumpTicks:I",
                    opcode = Opcodes.PUTFIELD
            )
    )
    private void illusion$publishJumpDelay(EntityLivingBase instance, int value) {
        if (instance instanceof EntityPlayerSP) {
            JumpDelayEvent event = new JumpDelayEvent();
            IllusionClient.getInstance().getEventBus().publish(event);
            value = event.getJumpTicks();
        }
    }
}
