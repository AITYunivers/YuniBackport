package io.github.yunivers.yunibackport_r0.events.init;

import io.github.yunivers.yunibackport_r0.entity.mob.BlazeEntity;
import net.fabricmc.loader.api.FabricLoader;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.entity.EntityRegistry;
import net.modificationstation.stationapi.api.event.mod.InitEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.EntrypointManager;
import net.modificationstation.stationapi.api.util.Namespace;
import org.apache.logging.log4j.Logger;

import java.lang.invoke.MethodHandles;

public class InitListener {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    @SuppressWarnings("UnstableApiUsage")
    public static final Namespace NAMESPACE = Namespace.resolve();

    public static final Logger LOGGER = NAMESPACE.getLogger();

    @EventListener
    private static void serverInit(InitEvent event)
    {
        EntityRegistry.register(BlazeEntity.class, "Blaze", 100);
    }
}
