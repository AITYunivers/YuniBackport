package io.github.yunivers.yunibackport_r0.events.init;

import io.github.yunivers.yunibackport_r0.YuniBackport_r0;
import io.github.yunivers.yunibackport_r0.block.NetherBrickFence;
import io.github.yunivers.yunibackport_r0.block.NetherBrickStairs;
import io.github.yunivers.yunibackport_r0.block.NetherWartCrop;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;

import static io.github.yunivers.yunibackport_lib.YuniBackport.NAMESPACE;

public class InitBlocks
{
    @EventListener
    public void initBlocks(BlockRegistryEvent event)
    {
        YuniBackport_r0.BLOCK_NETHER_BRICK = new TemplateBlock(NAMESPACE.id("nether_brick"), Material.STONE)
                .setHardness(2.0f)
                .setResistance(10.0f)
                .setSoundGroup(Block.STONE_SOUND_GROUP)
                .setLuminance(0.5f)
                .setTranslationKey(NAMESPACE.id("nether_brick"));
        YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE = new NetherBrickFence(NAMESPACE.id("nether_brick_fence"))
                .setTranslationKey(NAMESPACE.id("nether_brick_fence"));
        YuniBackport_r0.BLOCK_NETHER_BRICK_STAIRS = new NetherBrickStairs(NAMESPACE.id("nether_brick_stairs"))
                .setTranslationKey(NAMESPACE.id("nether_brick_stairs"));
        YuniBackport_r0.BLOCK_NETHER_WART_CROP = new NetherWartCrop(NAMESPACE.id("nether_wart_crop"))
                .setTranslationKey(NAMESPACE.id("nether_wart_crop"));
    }
}
