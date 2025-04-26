package io.github.yunivers.yunibackport_r0.block;

import io.github.yunivers.yunibackport_r0.YuniBackport_r0;
import net.minecraft.world.BlockView;
import net.modificationstation.stationapi.api.template.block.TemplateStairsBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class NetherBrickStairs extends TemplateStairsBlock
{
    public NetherBrickStairs(Identifier identifier)
    {
        super(identifier, YuniBackport_r0.BLOCK_NETHER_BRICK);
		ignoreMetaUpdates();
    }

    @Override
    public int getTexture(int side, int meta)
    {
        return YuniBackport_r0.TEXTURE_NETHER_BRICK;
    }

    @Override
    public int getTexture(int side)
    {
        return YuniBackport_r0.TEXTURE_NETHER_BRICK;
    }

    @Override
    public int getTextureId(BlockView blockView, int x, int y, int z, int side)
    {
        return YuniBackport_r0.TEXTURE_NETHER_BRICK;
    }
}
