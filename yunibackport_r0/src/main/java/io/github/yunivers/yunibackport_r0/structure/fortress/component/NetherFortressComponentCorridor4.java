package io.github.yunivers.yunibackport_r0.structure.fortress.component;

import io.github.yunivers.yunibackport_r0.YuniBackport_r0;
import io.github.yunivers.yunibackport_lib.structure.*;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class NetherFortressComponentCorridor4 extends NetherFortressComponentPiece
{
    public NetherFortressComponentCorridor4(int n, Random random, StructureBoundingBox structureBoundingBox, int n2) {
        super(n);
        this.coordBaseMode = n2;
        this.boundingBox = structureBoundingBox;
    }

    public void buildComponent(StructureComponent structureComponent, List<StructureComponent> list, Random random) {
        int n = 1;
        if (this.coordBaseMode == 1 || this.coordBaseMode == 2) {
            n = 5;
        }
        this.func_40019_b((NetherFortressComponentStartPiece)structureComponent, list, random, 0, n, random.nextInt(8) > 0);
        this.func_40016_c((NetherFortressComponentStartPiece)structureComponent, list, random, 0, n, random.nextInt(8) > 0);
    }

    public static NetherFortressComponentCorridor4 func_40039_a(List<StructureComponent> list, Random random, int n, int n2, int n3, int n4, int n5) {
        StructureBoundingBox structureBoundingBox = StructureBoundingBox.getComponentToAddBoundingBox(n, n2, n3, -3, 0, 0, 9, 7, 9, n4);
        if (!NetherFortressComponentCorridor4.func_40021_a(structureBoundingBox) || StructureComponent.getIntersectingStructureComponent(list, structureBoundingBox) != null) {
            return null;
        }
        return new NetherFortressComponentCorridor4(n5, random, structureBoundingBox, n4);
    }

    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureBoundingBox) {
        this.fillWithBlocks(world, structureBoundingBox, 0, 0, 0, 8, 1, 8, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 2, 0, 8, 5, 8, 0, 0, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 6, 0, 8, 6, 5, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 2, 0, 2, 5, 0, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 6, 2, 0, 8, 5, 0, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 1, 3, 0, 1, 4, 0, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 7, 3, 0, 7, 4, 0, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 2, 4, 8, 2, 8, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 1, 1, 4, 2, 2, 4, 0, 0, false);
        this.fillWithBlocks(world, structureBoundingBox, 6, 1, 4, 7, 2, 4, 0, 0, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 3, 8, 8, 3, 8, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 3, 6, 0, 3, 7, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 8, 3, 6, 8, 3, 7, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 3, 4, 0, 5, 5, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 8, 3, 4, 8, 5, 5, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 1, 3, 5, 2, 5, 5, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 6, 3, 5, 7, 5, 5, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 1, 4, 5, 1, 5, 5, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 7, 4, 5, 7, 5, 5, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        for (int i = 0; i <= 5; ++i) {
            for (int j = 0; j <= 8; ++j) {
                this.fillCurrentPositionBlocksDownwards(world, YuniBackport_r0.BLOCK_NETHER_BRICK.id, 0, j, -1, i, structureBoundingBox);
            }
        }
        return true;
    }
}
