package io.github.yunivers.yunibackport_r0.structure.fortress.component;

import io.github.yunivers.yunibackport_r0.YuniBackport_r0;
import io.github.yunivers.yunibackport_lib.structure.*;
import net.minecraft.block.Block;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class NetherFortressComponentThrone extends NetherFortressComponentPiece
{
    private boolean field_40027_a;

    public NetherFortressComponentThrone(int n, Random random, StructureBoundingBox structureBoundingBox, int n2) {
        super(n);
        this.coordBaseMode = n2;
        this.boundingBox = structureBoundingBox;
    }

    public static NetherFortressComponentThrone func_40026_a(List<StructureComponent> list, Random random, int n, int n2, int n3, int n4, int n5) {
        StructureBoundingBox structureBoundingBox = StructureBoundingBox.getComponentToAddBoundingBox(n, n2, n3, -2, 0, 0, 7, 8, 9, n4);
        if (!NetherFortressComponentThrone.func_40021_a(structureBoundingBox) || StructureComponent.getIntersectingStructureComponent(list, structureBoundingBox) != null) {
            return null;
        }
        return new NetherFortressComponentThrone(n5, random, structureBoundingBox, n4);
    }

    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureBoundingBox) {
        int n;
        int n2;
        this.fillWithBlocks(world, structureBoundingBox, 0, 2, 0, 6, 7, 7, 0, 0, false);
        this.fillWithBlocks(world, structureBoundingBox, 1, 0, 0, 5, 1, 7, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 1, 2, 1, 5, 2, 7, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 1, 3, 2, 5, 3, 7, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 1, 4, 3, 5, 4, 7, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 1, 2, 0, 1, 4, 2, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 5, 2, 0, 5, 4, 2, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 1, 5, 2, 1, 5, 3, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 5, 5, 2, 5, 5, 3, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 5, 3, 0, 5, 8, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 6, 5, 3, 6, 5, 8, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 1, 5, 8, 5, 5, 8, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, 0, 1, 6, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, 0, 5, 6, 3, structureBoundingBox);
        this.fillWithBlocks(world, structureBoundingBox, 0, 6, 3, 0, 6, 8, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 6, 6, 3, 6, 6, 8, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 1, 6, 8, 5, 7, 8, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 2, 8, 8, 4, 8, 8, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        if (!this.field_40027_a) {
            int n3;
            n2 = this.getYWithOffset(5);
            n = this.getXWithOffset(3, 5);
            if (structureBoundingBox.isVecInside(n, n2, n3 = this.getZWithOffset(3, 5))) {
                this.field_40027_a = true;
                world.setBlock(n, n2, n3, Block.SPAWNER.id);
                MobSpawnerBlockEntity tileEntityMobSpawner = (MobSpawnerBlockEntity)world.getBlockEntity(n, n2, n3);
                if (tileEntityMobSpawner != null) {
                    tileEntityMobSpawner.setSpawnedEntityId("Blaze");
                }
            }
        }
        for (n2 = 0; n2 <= 6; ++n2) {
            for (n = 0; n <= 6; ++n) {
                this.fillCurrentPositionBlocksDownwards(world, YuniBackport_r0.BLOCK_NETHER_BRICK.id, 0, n2, -1, n, structureBoundingBox);
            }
        }
        return true;
    }
}
