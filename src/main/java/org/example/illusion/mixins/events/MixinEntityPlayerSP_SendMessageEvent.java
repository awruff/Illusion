package org.example.illusion.mixins.events;

import net.minecraft.client.entity.EntityPlayerSP;
import org.example.illusion.IllusionClient;
import org.example.illusion.event.impl.player.SendMessageEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayerSP.class)
public class MixinEntityPlayerSP_SendMessageEvent {
    @Unique private SendMessageEvent illusion$chatSendEvent;

    @Inject(method = "sendChatMessage", at = @At("HEAD"), cancellable = true)
    private void illusion$publishChatSend(String message, CallbackInfo ci) {
        IllusionClient.getInstance().getEventBus().publish(illusion$chatSendEvent = new SendMessageEvent(message));

        if (illusion$chatSendEvent.isCancelled()) ci.cancel();
    }

    @ModifyVariable(method = "sendChatMessage", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private String illusion$setMessage(String value) {
        return illusion$chatSendEvent.getMessage();
    }
}
