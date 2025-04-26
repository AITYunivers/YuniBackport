package io.github.yunivers.yunibackport_lib.mixin.entity;

import io.github.yunivers.yunibackport_lib.impl.entity.YuniBackportEntity;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Entity.class)
public abstract class EntityMixin implements YuniBackportEntity
{
    @Shadow public int fireTicks;

    @Override
    @Unique
    public boolean yunibackport$isFireImmune()
    {
        return false;
    }

    @Override
    @Unique
    public void yunibackport$setOnFire(int seconds)
    {
        int newFireTicks = seconds * 20;
        if (fireTicks < newFireTicks)
            this.fireTicks = newFireTicks;
    }
}
