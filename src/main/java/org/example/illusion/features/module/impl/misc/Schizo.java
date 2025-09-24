package org.example.illusion.features.module.impl.misc;

import com.mojang.authlib.GameProfile;
import io.github.nevalackin.radbus.Listen;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import org.example.illusion.event.impl.render.Render3DEvent;
import org.example.illusion.features.module.api.Category;
import org.example.illusion.features.module.api.Module;
import org.example.illusion.features.module.api.ModuleInfo;
import org.example.illusion.utils.Wrapper;

import java.util.UUID;

@ModuleInfo(
        name = "meow???", category = Category.MISC
)
public class Schizo extends Module {
    private EntityOtherPlayerMP fakePlayer;

    @Override
    public void onEnable() {
        GameProfile profile = new GameProfile(UUID.fromString("f26f5917-42dc-4b74-9a7b-c8a85dd697b0"), "The Shadows");

        fakePlayer = new EntityOtherPlayerMP(Wrapper.getWorld(), profile);
        updateLocation();
        Wrapper.getWorld().addEntityToWorld(fakePlayer.getEntityId(), fakePlayer);
    }

    @Listen
    public void onRender(Render3DEvent event) {
        if (Wrapper.isBBInFrustum(fakePlayer.getEntityBoundingBox())) {
            fakePlayer.setInvisible(true);
        } else if (fakePlayer.isInvisible()) {
            fakePlayer.setInvisible(false);
        }

        updateLocation();
    }

    public void updateLocation() {
        EntityPlayerSP player = Wrapper.getPlayer();

        double radians = Math.toRadians(player.rotationYawHead);
        double behindX = player.posX - Math.sin(radians) * -2.5;
        double behindZ = player.posZ + Math.cos(radians) * -2.5;

        fakePlayer.setLocationAndAngles(behindX, player.posY, behindZ, -player.rotationYawHead, -player.rotationPitch);
    }
}
