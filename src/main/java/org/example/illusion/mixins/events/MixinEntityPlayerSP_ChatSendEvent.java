package org.example.illusion.mixins.events;

import net.minecraft.client.entity.EntityPlayerSP;
import org.example.illusion.Illusion;
import org.example.illusion.features.events.impl.ChatSendEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayerSP.class)
public class MixinEntityPlayerSP_ChatSendEvent {
    @Unique private ChatSendEvent illusion$chatSendEvent;

    @Inject(method = "sendChatMessage", at = @At("HEAD"), cancellable = true)
    private void illusion$publishChatSend(String message, CallbackInfo ci) {
        Illusion.INSTANCE.getEventBus().publish(illusion$chatSendEvent = new ChatSendEvent(message));

        if (illusion$chatSendEvent.isCancelled()) ci.cancel();
    }

    @ModifyVariable(method = "sendChatMessage", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private String illusion$setMessage(String value) {
        return illusion$chatSendEvent.message;
    }
}
