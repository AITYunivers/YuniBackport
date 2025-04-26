package io.github.yunivers.yunibackport_r0.structure.fortress.component;

import io.github.yunivers.yunibackport_r0.YuniBackport_r0;
import io.github.yunivers.yunibackport_r0.structure.*;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class NetherFortressComponentStairs extends NetherFortressComponentPiece
{
    public NetherFortressComponentStairs(int n, Random random, StructureBoundingBox structureBoundingBox, int n2) {
        super(n);
        this.coordBaseMode = n2;
        this.boundingBox = structureBoundingBox;
    }

    public void buildComponent(StructureComponent structureComponent, List<StructureComponent> list, Random random) {
        this.func_40016_c((NetherFortressComponentStartPiece)structureComponent, list, random, 6, 2, false);
    }

    public static NetherFortressComponentStairs func_40031_a(List<StructureComponent> list, Random random, int n, int n2, int n3, int n4, int n5) {
        StructureBoundingBox structureBoundingBox = StructureBoundingBox.getComponentToAddBoundingBox(n, n2, n3, -2, 0, 0, 7, 11, 7, n4);
        if (!NetherFortressComponentStairs.func_40021_a(structureBoundingBox) || StructureComponent.getIntersectingStructureComponent(list, structureBoundingBox) != null) {
            return null;
        }
        return new NetherFortressComponentStairs(n5, random, structureBoundingBox, n4);
    }

    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureBoundingBox) {
        this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 6, 1, 6, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 2, 0, 6, 10, 6, 0, 0, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 2, 0, 1, 8, 0, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 5, 2, 0, 6, 8, 0, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 2, 1, 0, 8, 6, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 6, 2, 1, 6, 8, 6, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 1, 2, 6, 5, 8, 6, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 3, 2, 0, 5, 4, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 6, 3, 2, 6, 5, 2, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 6, 3, 4, 6, 5, 4, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK.id, 0, 5, 2, 5, structureBoundingBox);
        this.fillWithBlocks(world, structureBoundingBox, 4, 2, 5, 4, 3, 5, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 3, 2, 5, 3, 4, 5, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 2, 2, 5, 2, 5, 5, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 1, 2, 5, 1, 6, 5, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 1, 7, 1, 5, 7, 4, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 6, 8, 2, 6, 8, 4, 0, 0, false);
        this.fillWithBlocks(world, structureBoundingBox, 2, 6, 0, 4, 8, 0, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 2, 5, 0, 4, 5, 0, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        for (int i = 0; i <= 6; ++i) {
            for (int j = 0; j <= 6; ++j) {
                this.fillCurrentPositionBlocksDownwards(world, YuniBackport_r0.BLOCK_NETHER_BRICK.id, 0, i, -1, j, structureBoundingBox);
            }
        }
        return true;
    }
}
