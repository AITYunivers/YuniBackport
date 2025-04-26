package io.github.yunivers.yunibackport_lib.impl.item;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Util;

public interface YuniBackportDoorItem
{
    default void yunibackport$placeDoorBlock(World world, int x, int y, int z, int facing, Block block)
    {
        Util.assertImpl();
    }
}
