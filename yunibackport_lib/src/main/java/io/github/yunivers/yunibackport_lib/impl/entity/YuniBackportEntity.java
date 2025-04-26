package io.github.yunivers.yunibackport_lib.impl.entity;

import net.modificationstation.stationapi.api.util.Util;

public interface YuniBackportEntity
{
    default boolean yunibackport$isFireImmune()
    {
        return Util.assertImpl();
    }

    default void yunibackport$setOnFire(int seconds)
    {
        Util.assertImpl();
    }
}
