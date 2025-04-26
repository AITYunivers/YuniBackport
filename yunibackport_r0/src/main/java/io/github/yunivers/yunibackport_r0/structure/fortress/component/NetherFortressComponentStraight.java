package io.github.yunivers.yunibackport_r0.structure.fortress.component;

import io.github.yunivers.yunibackport_r0.YuniBackport_r0;
import io.github.yunivers.yunibackport_lib.structure.*;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class NetherFortressComponentStraight extends NetherFortressComponentPiece
{
    public NetherFortressComponentStraight(int n, Random random, StructureBoundingBox structureBoundingBox, int n2) {
        super(n);
        this.coordBaseMode = n2;
        this.boundingBox = structureBoundingBox;
    }

    public void buildComponent(StructureComponent structureComponent, List<StructureComponent> list, Random random) {
        this.func_40022_a((NetherFortressComponentStartPiece)structureComponent, list, random, 1, 3, false);
    }

    public static NetherFortressComponentStraight func_40029_a(List<StructureComponent> list, Random random, int n, int n2, int n3, int n4, int n5) {
        StructureBoundingBox structureBoundingBox = StructureBoundingBox.getComponentToAddBoundingBox(n, n2, n3, -1, -3, 0, 5, 10, 19, n4);
        if (!NetherFortressComponentStraight.func_40021_a(structureBoundingBox) || StructureComponent.getIntersectingStructureComponent(list, structureBoundingBox) != null) {
            return null;
        }
        return new NetherFortressComponentStraight(n5, random, structureBoundingBox, n4);
    }

    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureBoundingBox) {
        this.fillWithBlocks(world, structureBoundingBox, 0, 3, 0, 4, 4, 18, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 1, 5, 0, 3, 7, 18, 0, 0, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 5, 0, 0, 5, 18, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 4, 5, 0, 4, 5, 18, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 2, 0, 4, 2, 5, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 2, 13, 4, 2, 18, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 4, 1, 3, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 0, 15, 4, 1, 18, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        for (int i = 0; i <= 4; ++i) {
            for (int j = 0; j <= 2; ++j) {
                this.fillCurrentPositionBlocksDownwards(world, YuniBackport_r0.BLOCK_NETHER_BRICK.id, 0, i, -1, j, structureBoundingBox);
                this.fillCurrentPositionBlocksDownwards(world, YuniBackport_r0.BLOCK_NETHER_BRICK.id, 0, i, -1, 18 - j, structureBoundingBox);
            }
        }
        this.fillWithBlocks(world, structureBoundingBox, 0, 1, 1, 0, 4, 1, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 3, 4, 0, 4, 4, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 3, 14, 0, 4, 14, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 1, 17, 0, 4, 17, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 4, 1, 1, 4, 4, 1, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 4, 3, 4, 4, 4, 4, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 4, 3, 14, 4, 4, 14, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 4, 1, 17, 4, 4, 17, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        return true;
    }
}
