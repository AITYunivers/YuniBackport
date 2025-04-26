package io.github.yunivers.yunibackport_r0.events.init;

import io.github.yunivers.yunibackport_r0.entity.mob.BlazeEntity;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.entity.EntityRegistry;
import net.modificationstation.stationapi.api.event.mod.InitEvent;

public class InitListener
{
    @EventListener
    private static void serverInit(InitEvent event)
    {
        EntityRegistry.register(BlazeEntity.class, "Blaze", 100);
    }
}
