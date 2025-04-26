package io.github.yunivers.yunibackport_r0.client.render.entity;

import io.github.yunivers.yunibackport_r0.YuniBackport_r0;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.client.StationRenderAPI;
import net.modificationstation.stationapi.api.client.texture.Sprite;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;
import org.lwjgl.opengl.GL11;

@Environment(EnvType.CLIENT)
public class SmallFireballEntityRenderer extends EntityRenderer
{
    @Override
    public void render(Entity entity, double x, double y, double z, float yaw, float pitch)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x, (float)y, (float)z);
        GL11.glEnable(32826);
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        StationRenderAPI.getBakedModelManager().getAtlas(Atlases.GAME_ATLAS_TEXTURE).bindTexture();
        Sprite sprite = Atlases.getGuiItems().getTexture(YuniBackport_r0.TEXTURE_ENTITY_FIRE_CHARGE).getSprite();;
        Tessellator var12 = Tessellator.INSTANCE;
        float var17 = 1.0F;
        float var18 = 0.5F;
        float var19 = 0.25F;
        GL11.glRotatef(180.0F - this.dispatcher.yaw, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.dispatcher.pitch, 1.0F, 0.0F, 0.0F);
        var12.startQuads();
        var12.normal(0.0F, 1.0F, 0.0F);
        var12.vertex(0.0F - var18, 0.0F - var19, 0.0, sprite.getMinU(), sprite.getMaxV());
        var12.vertex(var17 - var18, 0.0F - var19, 0.0, sprite.getMaxU(), sprite.getMaxV());
        var12.vertex(var17 - var18, 1.0F - var19, 0.0, sprite.getMaxU(), sprite.getMinV());
        var12.vertex(0.0F - var18, 1.0F - var19, 0.0, sprite.getMinU(), sprite.getMinV());
        var12.draw();
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }
}
