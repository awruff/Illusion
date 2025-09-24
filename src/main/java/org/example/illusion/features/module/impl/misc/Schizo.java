package org.example.illusion.features.module.impl.misc;

import com.mojang.authlib.GameProfile;
import io.github.nevalackin.radbus.Listen;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import org.example.illusion.event.impl.player.PlayerTickEvent;
import org.example.illusion.event.impl.render.Render3DEvent;
import org.example.illusion.features.module.api.Category;
import org.example.illusion.features.module.api.Module;
import org.example.illusion.features.module.api.ModuleInfo;
import org.example.illusion.utils.Wrapper;

import java.util.UUID;

@ModuleInfo(
        name = "wuh?", category = Category.MISC
)
public class Schizo extends Module {
    private EntityOtherPlayerMP fakePlayer;

    private boolean peakaBoo = false;
    private int peakaTicks = 0;

    @Override
    public void onEnable() {
        GameProfile profile = new GameProfile(UUID.randomUUID(), "The Shadows");

        fakePlayer = new EntityOtherPlayerMP(Wrapper.getWorld(), profile);
        updateLocation();
        Wrapper.getWorld().addEntityToWorld(fakePlayer.getEntityId(), fakePlayer);
    }

    @Listen
    public void onTick(PlayerTickEvent event) {
        if (Wrapper.isBBInFrustum(fakePlayer.getEntityBoundingBox())) {
            peakaBoo = ++peakaTicks > 2;
        } else if (fakePlayer.isInvisible()) {
            peakaBoo = false;
            peakaTicks = 0;
        }
    }

    @Listen
    public void onRender(Render3DEvent event) {
        fakePlayer.setInvisible(peakaBoo);

        updateLocation();
    }

    public void updateLocation() {
        EntityPlayerSP player = Wrapper.getPlayer();

        double radians = Math.toRadians(player.rotationYawHead);
        double behindX = player.posX - Math.sin(radians) * -2.5;
        double behindZ = player.posZ + Math.cos(radians) * -2.5;

        fakePlayer.setLocationAndAngles(behindX, player.posY, behindZ, -player.cameraYaw, -player.cameraPitch);
    }
}
