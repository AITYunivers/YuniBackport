package io.github.yunivers.yunibackport_r0.structure.fortress.component;

import io.github.yunivers.yunibackport_r0.YuniBackport_r0;
import io.github.yunivers.yunibackport_lib.structure.*;
import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class NetherFortressComponentEntrance extends NetherFortressComponentPiece
{
    public NetherFortressComponentEntrance(int n, Random random, StructureBoundingBox structureBoundingBox, int n2) {
        super(n);
        this.coordBaseMode = n2;
        this.boundingBox = structureBoundingBox;
    }

    public void buildComponent(StructureComponent structureComponent, List<StructureComponent> list, Random random) {
        this.func_40022_a((NetherFortressComponentStartPiece)structureComponent, list, random, 5, 3, true);
    }

    public static NetherFortressComponentEntrance func_40030_a(List<StructureComponent> list, Random random, int n, int n2, int n3, int n4, int n5) {
        StructureBoundingBox structureBoundingBox = StructureBoundingBox.getComponentToAddBoundingBox(n, n2, n3, -5, -3, 0, 13, 14, 13, n4);
        if (!NetherFortressComponentEntrance.func_40021_a(structureBoundingBox) || StructureComponent.getIntersectingStructureComponent(list, structureBoundingBox) != null) {
            return null;
        }
        return new NetherFortressComponentEntrance(n5, random, structureBoundingBox, n4);
    }

    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureBoundingBox) {
        int n;
        int n2;
        this.fillWithBlocks(world, structureBoundingBox, 0, 3, 0, 12, 4, 12, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 5, 0, 12, 13, 12, 0, 0, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 5, 0, 1, 12, 12, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 11, 5, 0, 12, 12, 12, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 2, 5, 11, 4, 12, 12, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 8, 5, 11, 10, 12, 12, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 5, 9, 11, 7, 12, 12, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 2, 5, 0, 4, 12, 1, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 8, 5, 0, 10, 12, 1, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 5, 9, 0, 7, 12, 1, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 2, 11, 2, 10, 12, 10, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 5, 8, 0, 7, 8, 0, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        for (n2 = 1; n2 <= 11; n2 += 2) {
            this.fillWithBlocks(world, structureBoundingBox, n2, 10, 0, n2, 11, 0, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
            this.fillWithBlocks(world, structureBoundingBox, n2, 10, 12, n2, 11, 12, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 10, n2, 0, 11, n2, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
            this.fillWithBlocks(world, structureBoundingBox, 12, 10, n2, 12, 11, n2, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
            this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK.id, 0, n2, 13, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK.id, 0, n2, 13, 12, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK.id, 0, 0, 13, n2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK.id, 0, 12, 13, n2, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, 0, n2 + 1, 13, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, 0, n2 + 1, 13, 12, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, 0, 0, 13, n2 + 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, 0, 12, 13, n2 + 1, structureBoundingBox);
        }
        this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, 0, 0, 13, 0, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, 0, 0, 13, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, 0, 0, 13, 0, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, 0, 12, 13, 0, structureBoundingBox);
        for (n2 = 3; n2 <= 9; n2 += 2) {
            this.fillWithBlocks(world, structureBoundingBox, 1, 7, n2, 1, 8, n2, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
            this.fillWithBlocks(world, structureBoundingBox, 11, 7, n2, 11, 8, n2, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        }
        this.fillWithBlocks(world, structureBoundingBox, 4, 2, 0, 8, 2, 12, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 2, 4, 12, 2, 8, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 4, 0, 0, 8, 1, 3, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 4, 0, 9, 8, 1, 12, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 0, 4, 3, 1, 8, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 9, 0, 4, 12, 1, 8, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        for (n2 = 4; n2 <= 8; ++n2) {
            for (n = 0; n <= 2; ++n) {
                this.fillCurrentPositionBlocksDownwards(world, YuniBackport_r0.BLOCK_NETHER_BRICK.id, 0, n2, -1, n, structureBoundingBox);
                this.fillCurrentPositionBlocksDownwards(world, YuniBackport_r0.BLOCK_NETHER_BRICK.id, 0, n2, -1, 12 - n, structureBoundingBox);
            }
        }
        for (n2 = 0; n2 <= 2; ++n2) {
            for (n = 4; n <= 8; ++n) {
                this.fillCurrentPositionBlocksDownwards(world, YuniBackport_r0.BLOCK_NETHER_BRICK.id, 0, n2, -1, n, structureBoundingBox);
                this.fillCurrentPositionBlocksDownwards(world, YuniBackport_r0.BLOCK_NETHER_BRICK.id, 0, 12 - n2, -1, n, structureBoundingBox);
            }
        }
        this.fillWithBlocks(world, structureBoundingBox, 5, 5, 5, 7, 5, 7, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 6, 1, 6, 6, 4, 6, 0, 0, false);
        this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK.id, 0, 6, 0, 6, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, Block.FLOWING_LAVA.id, 0, 6, 5, 6, structureBoundingBox);
        n2 = this.getXWithOffset(6, 6);
        n = this.getYWithOffset(5);
        int n3 = this.getZWithOffset(6, 6);
        if (structureBoundingBox.isVecInside(n2, n, n3)) {
            world.instantBlockUpdateEnabled = true;
            Block.BLOCKS[Block.FLOWING_LAVA.id].onTick(world, n2, n, n3, random);
            world.instantBlockUpdateEnabled = false;
        }
        return true;
    }
}
