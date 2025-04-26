package io.github.yunivers.yunibackport_lib.impl.entity.projectile;

import net.minecraft.util.hit.HitResult;
import net.modificationstation.stationapi.api.util.Util;
import org.spongepowered.asm.mixin.Unique;

public interface YuniBackportFireballEntity
{
    @Unique
    default void yunibackport$onHitEntity(HitResult hit)
    {
        Util.assertImpl();
    }
}
