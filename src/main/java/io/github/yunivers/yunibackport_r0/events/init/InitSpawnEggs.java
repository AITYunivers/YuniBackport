package io.github.yunivers.yunibackport_r0.events.init;

import net.danygames2014.spawneggs.api.event.SpawnEggColorizationEvent;
import net.mine_diver.unsafeevents.listener.EventListener;

public class InitSpawnEggs
{
    @EventListener
    public void initSpawnEggs(SpawnEggColorizationEvent event)
    {
        event.registerSpawnEggColorHex("Blaze", 0xAA7B01, 0xF6B201, 0xFFF87E);
    }
}
