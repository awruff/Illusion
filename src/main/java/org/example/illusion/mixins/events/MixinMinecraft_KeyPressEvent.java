package org.example.illusion.mixins.events;

import net.minecraft.client.Minecraft;
import org.example.illusion.Illusion;
import org.example.illusion.features.events.impl.KeyPressEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft_KeyPressEvent {

    @Inject(method = "runTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Minecraft;dispatchKeypresses()V"))
    private void illusion$publishKeyPress(CallbackInfo ci) {
//        for (Module module : Illusion.INSTANCE.getModuleManager().getModules().values()) {
//            if (Keyboard.isKeyDown(module.getBind())) {
//                module.toggle();
//            }
//        }

        Illusion.INSTANCE.getEventBus().publish(new KeyPressEvent());
    }

}
