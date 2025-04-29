package org.example.illusion.mixins.events;

import net.minecraftforge.client.GuiIngameForge;
import org.example.illusion.IllusionClient;
import org.example.illusion.event.impl.render.Render2DEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GuiIngameForge.class, remap = false)
public class GuiIngameForge_Render2D {
    @Inject(
            method = "renderGameOverlay",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;enableBlend()V")
    )
    private void illusion$publishRender2D(float partialTicks, CallbackInfo ci) {
        IllusionClient.getInstance().getEventBus().publish(new Render2DEvent(partialTicks));
    }
}
