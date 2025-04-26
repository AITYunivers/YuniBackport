package io.github.yunivers.yunibackport_r0.block;

import io.github.yunivers.yunibackport_r0.YuniBackport_r0;
import net.modificationstation.stationapi.api.template.block.TemplateFenceBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class NetherBrickFence extends TemplateFenceBlock
{
    public NetherBrickFence(Identifier identifier)
    {
        super(identifier, 0);
        setHardness(2.0f);
        setResistance(10.0f);
        setSoundGroup(STONE_SOUND_GROUP);
    }

    @Override
    public int getTexture(int side)
    {
        return YuniBackport_r0.TEXTURE_NETHER_BRICK;
    }
}
