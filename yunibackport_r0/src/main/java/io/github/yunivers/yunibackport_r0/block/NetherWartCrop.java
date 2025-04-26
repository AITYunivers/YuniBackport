package io.github.yunivers.yunibackport_r0.block;

import io.github.yunivers.yunibackport_r0.YuniBackport_r0;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.HellBiome;
import net.modificationstation.stationapi.api.template.block.TemplatePlantBlock;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Random;

public class NetherWartCrop extends TemplatePlantBlock
{
    public NetherWartCrop(Identifier identifier)
    {
        super(identifier, 0);
        setTickRandomly(true);
        setBoundingBox(0.0f, 0.0f, 0.0f, 1.0f, 0.25f, 1.0f);
        setSoundGroup(DIRT_SOUND_GROUP);
        ignoreMetaUpdates();
    }

    @Override
    protected boolean canPlantOnTop(int id)
    {
        return id == Block.SOUL_SAND.id;
    }

    @Override
    public boolean canPlaceAt(World world, int x, int y, int z)
    {
        return canPlantOnTop(world.getBlockId(x, y - 1, z));
    }

    @Override
    public void onTick(World world, int x, int y, int z, Random random)
    {
        Biome biome = world.method_1781().getBiome(x, z);
        int stage = world.getBlockMeta(x, y, z);
        if (stage < 3 && biome instanceof HellBiome && random.nextInt(10) == 0)
            world.setBlockMeta(x, y, z, stage + 1);
        super.onTick(world, x, y, z, random);
    }

    @Override
    public int getTexture(int side, int meta)
    {
        if (meta > 2)
            return YuniBackport_r0.TEXTURE_NETHER_WART_STAGE_2;
        if (meta > 0)
            return YuniBackport_r0.TEXTURE_NETHER_WART_STAGE_1;
        return YuniBackport_r0.TEXTURE_NETHER_WART_STAGE_0;
    }

    @Override
    public int getRenderType()
    {
        return 6;
    }

    @Override
    public void dropStacks(World world, int x, int y, int z, int meta, float luck)
    {
        if (world.isRemote) {
            return;
        }
        int n6 = 1;
        if (meta >= 3)
            n6 = 2 + world.random.nextInt(3);
        for (int i = 0; i < n6; ++i)
            dropStack(world, x, y, z, new ItemStack(YuniBackport_r0.ITEM_NETHER_WART));
    }

    @Override
    public int getDroppedItemId(int blockMeta, Random random)
    {
        return 0;
    }

    @Override
    public int getDroppedItemCount(Random random)
    {
        return 0;
    }
}
