package io.github.yunivers.yunibackport_r0.item;

import io.github.yunivers.yunibackport_r0.YuniBackport_r0;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class NetherWartSeeds extends TemplateItem
{
    public NetherWartSeeds(Identifier identifier)
    {
        super(identifier);
    }

    @Override
    public boolean useOnBlock(ItemStack stack, PlayerEntity user, World world, int x, int y, int z, int side)
    {
        if (side != 1)
            return false;

        int n5 = world.getBlockId(x, y, z);
        if (n5 == Block.SOUL_SAND.id && world.isAir(x, y + 1, z))
        {
            world.setBlock(x, y + 1, z, YuniBackport_r0.BLOCK_NETHER_WART_CROP.id, 0);
            stack.count--;
            return true;
        }
        return false;
    }
}
