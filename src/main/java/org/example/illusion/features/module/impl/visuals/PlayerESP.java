package org.example.illusion.features.module.impl.visuals;

import io.github.nevalackin.radbus.Listen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import org.example.illusion.event.impl.render.Render2DEvent;
import org.example.illusion.event.impl.render.Render3DEvent;
import org.example.illusion.event.impl.world.WorldLoadEvent;
import org.example.illusion.features.module.api.Category;
import org.example.illusion.features.module.api.Module;
import org.example.illusion.features.module.api.ModuleInfo;
import org.example.illusion.utils.GLUtils;
import org.example.illusion.utils.RenderUtils;
import org.example.illusion.utils.Wrapper;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@ModuleInfo(name = "ESP", category = Category.VISUALS)
public class PlayerESP extends Module {
    private final Map<EntityPlayer, float[]> positions = new HashMap<>();

    // TODO: Client themes (like I made for the original illusion)
    private final Color color = new Color(255, 255, 255);
    private final Color colort = new Color(255, 255, 255, 50);

    private final Color black = new Color(0, 0, 0);

    @Listen
    public void onRender2D(Render2DEvent event) {
        for (EntityPlayer player : positions.keySet()) {
            if ((player.getDistanceToEntity(Wrapper.getPlayer()) < 1.0F && Wrapper.isInFirstPerson()) ||
                    !Wrapper.isBBInFrustum(player.getEntityBoundingBox()))
                continue;

            float[] positions = this.positions.get(player);

            RenderUtils.drawGradientRect(positions, colort.getRGB(), colort.darker().darker().darker().getRGB());

            RenderUtils.drawBox(positions, 0.0f, 1.5f, black.getRGB());
            RenderUtils.drawBox(positions, 0.5f, 0.5f, color.getRGB());
        }
    }

    @Listen
    public void onRender3D(Render3DEvent event) {
        if (!positions.isEmpty()) positions.clear();

        float partialTicks = event.getPartialTicks();

        for (EntityPlayer player : Wrapper.getLoadedPlayers()) {
            if (!Wrapper.isBBInFrustum(player.getEntityBoundingBox()) || !Wrapper.getLoadedPlayers().contains(player)) continue;

            double posX = player.prevPosX + (player.posX - player.prevPosX) * partialTicks - Wrapper.getRenderManager().viewerPosX;
            double posY = player.prevPosY + (player.posY - player.prevPosY) * partialTicks - Wrapper.getRenderManager().viewerPosY;
            double posZ = player.prevPosZ + (player.posZ - player.prevPosZ) * partialTicks - Wrapper.getRenderManager().viewerPosZ;

            AxisAlignedBB aabb = new AxisAlignedBB(
                    posX - player.width / 2.0D, posY,
                    posZ - player.width / 2.0D,
                    posX + player.width / 2.0D,
                    posY + player.height + (player.isSneaking() ? -0.2D : 0.1D),
                    posZ + player.width / 2.0D
            ).expand(0.1, 0.1, 0.1);

            double[][] vectors = {
                    {aabb.minX, aabb.minY, aabb.minZ}, {aabb.minX, aabb.maxY, aabb.minZ},
                    {aabb.minX, aabb.maxY, aabb.maxZ}, {aabb.minX, aabb.minY, aabb.maxZ},
                    {aabb.maxX, aabb.minY, aabb.minZ}, {aabb.maxX, aabb.maxY, aabb.minZ},
                    {aabb.maxX, aabb.maxY, aabb.maxZ}, {aabb.maxX, aabb.minY, aabb.maxZ}
            };

            float[] projection;
            float[] bounds = new float[]{Float.MAX_VALUE, Float.MAX_VALUE, -1.0F, -1.0F};

            for (double[] vector : vectors) {
                projection = GLUtils.project2D((float) vector[0], (float) vector[1], (float) vector[2], Wrapper.getScale());
                if (projection != null && projection[2] >= 0.0F && projection[2] < 1.0F) {
                    float pX = projection[0];
                    float pY = projection[1];
                    bounds[0] = Math.min(bounds[0], pX);
                    bounds[1] = Math.min(bounds[1], pY);
                    bounds[2] = Math.max(bounds[2], pX);
                    bounds[3] = Math.max(bounds[3], pY);
                }
            }

            positions.put(player, bounds);
        }
    }

    @Listen
    public void onWorldLoad(WorldLoadEvent event) {
        positions.clear();
    }

}
