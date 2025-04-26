package io.github.yunivers.yunibackport_r0.events.init;

import io.github.yunivers.yunibackport_r0.client.render.entity.BlazeEntityRenderer;
import io.github.yunivers.yunibackport_r0.client.render.entity.SmallFireballEntityRenderer;
import io.github.yunivers.yunibackport_r0.entity.mob.BlazeEntity;
import io.github.yunivers.yunibackport_r0.entity.projectile.SmallFireballEntity;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.render.entity.EntityRendererRegisterEvent;

public class InitEntityRenderers
{
    @EventListener
    public void initEntityRenderers(EntityRendererRegisterEvent event)
    {
        event.renderers.put(BlazeEntity.class, new BlazeEntityRenderer());
        event.renderers.put(SmallFireballEntity.class, new SmallFireballEntityRenderer());
    }
}
