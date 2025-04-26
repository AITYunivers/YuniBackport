package io.github.yunivers.yunibackport_r0.structure.fortress.component;

import io.github.yunivers.yunibackport_r0.YuniBackport_r0;
import io.github.yunivers.yunibackport_r0.structure.*;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class NetherFortressComponentCorridor3 extends NetherFortressComponentPiece
{
    public NetherFortressComponentCorridor3(int n, Random random, StructureBoundingBox structureBoundingBox, int n2) {
        super(n);
        this.coordBaseMode = n2;
        this.boundingBox = structureBoundingBox;
    }

    public void buildComponent(StructureComponent structureComponent, List<StructureComponent> list, Random random) {
        this.func_40022_a((NetherFortressComponentStartPiece)structureComponent, list, random, 1, 0, true);
    }

    public static NetherFortressComponentCorridor3 func_40042_a(List<StructureComponent> list, Random random, int n, int n2, int n3, int n4, int n5) {
        StructureBoundingBox structureBoundingBox = StructureBoundingBox.getComponentToAddBoundingBox(n, n2, n3, -1, -7, 0, 5, 14, 10, n4);
        if (!NetherFortressComponentCorridor3.func_40021_a(structureBoundingBox) || StructureComponent.getIntersectingStructureComponent(list, structureBoundingBox) != null) {
            return null;
        }
        return new NetherFortressComponentCorridor3(n5, random, structureBoundingBox, n4);
    }

    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureBoundingBox) {
        int n = this.func_35009_c(YuniBackport_r0.BLOCK_NETHER_BRICK_STAIRS.id, 2);
        for (int i = 0; i <= 9; ++i) {
            int n2 = Math.max(1, 7 - i);
            int n3 = Math.min(Math.max(n2 + 5, 14 - i), 13);
            int n4 = i;
            this.fillWithBlocks(world, structureBoundingBox, 0, 0, n4, 4, n2, n4, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
            this.fillWithBlocks(world, structureBoundingBox, 1, n2 + 1, n4, 3, n3 - 1, n4, 0, 0, false);
            if (i <= 6) {
                this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_STAIRS.id, n, 1, n2 + 1, n4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_STAIRS.id, n, 2, n2 + 1, n4, structureBoundingBox);
                this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_STAIRS.id, n, 3, n2 + 1, n4, structureBoundingBox);
            }
            this.fillWithBlocks(world, structureBoundingBox, 0, n3, n4, 4, n3, n4, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, n2 + 1, n4, 0, n3 - 1, n4, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
            this.fillWithBlocks(world, structureBoundingBox, 4, n2 + 1, n4, 4, n3 - 1, n4, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
            if ((i & 1) == 0) {
                this.fillWithBlocks(world, structureBoundingBox, 0, n2 + 2, n4, 0, n2 + 3, n4, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
                this.fillWithBlocks(world, structureBoundingBox, 4, n2 + 2, n4, 4, n2 + 3, n4, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
            }
            for (int j = 0; j <= 4; ++j) {
                this.fillCurrentPositionBlocksDownwards(world, YuniBackport_r0.BLOCK_NETHER_BRICK.id, 0, j, -1, n4, structureBoundingBox);
            }
        }
        return true;
    }
}
