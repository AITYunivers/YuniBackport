package io.github.yunivers.yunibackport_r0.events.init;

import io.github.yunivers.yunibackport_r0.YuniBackport_r0;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;
import net.modificationstation.stationapi.api.client.texture.atlas.ExpandableAtlas;

import static io.github.yunivers.yunibackport_lib.YuniBackport.NAMESPACE;

public class InitTextures
{
    @EventListener
    public void initTextures(TextureRegisterEvent event)
    {
        ExpandableAtlas terrainAtlas = Atlases.getTerrain();
        ExpandableAtlas guiAtlas = Atlases.getGuiItems();
        YuniBackport_r0.TEXTURE_ENTITY_FIRE_CHARGE = guiAtlas.addTexture(NAMESPACE.id("item/fire_charge")).index;
        YuniBackport_r0.TEXTURE_NETHER_BRICK = terrainAtlas.addTexture(NAMESPACE.id("block/nether_brick")).index;
        YuniBackport_r0.TEXTURE_NETHER_WART_STAGE_0 = terrainAtlas.addTexture(NAMESPACE.id("block/nether_wart_stage_0")).index;
        YuniBackport_r0.TEXTURE_NETHER_WART_STAGE_1 = terrainAtlas.addTexture(NAMESPACE.id("block/nether_wart_stage_1")).index;
        YuniBackport_r0.TEXTURE_NETHER_WART_STAGE_2 = terrainAtlas.addTexture(NAMESPACE.id("block/nether_wart_stage_2")).index;
    }
}
