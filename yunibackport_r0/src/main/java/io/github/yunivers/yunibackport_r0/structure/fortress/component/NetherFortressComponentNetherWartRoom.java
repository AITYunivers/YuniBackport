package io.github.yunivers.yunibackport_r0.structure.fortress.component;

import io.github.yunivers.yunibackport_r0.YuniBackport_r0;
import io.github.yunivers.yunibackport_r0.structure.*;
import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class NetherFortressComponentNetherWartRoom extends NetherFortressComponentPiece
{
    public NetherFortressComponentNetherWartRoom(int n, Random random, StructureBoundingBox structureBoundingBox, int n2) {
        super(n);
        this.coordBaseMode = n2;
        this.boundingBox = structureBoundingBox;
    }

    public void buildComponent(StructureComponent structureComponent, List<StructureComponent> list, Random random) {
        this.func_40022_a((NetherFortressComponentStartPiece)structureComponent, list, random, 5, 3, true);
        this.func_40022_a((NetherFortressComponentStartPiece)structureComponent, list, random, 5, 11, true);
    }

    public static NetherFortressComponentNetherWartRoom func_40040_a(List<StructureComponent> list, Random random, int n, int n2, int n3, int n4, int n5) {
        StructureBoundingBox structureBoundingBox = StructureBoundingBox.getComponentToAddBoundingBox(n, n2, n3, -5, -3, 0, 13, 14, 13, n4);
        if (!NetherFortressComponentNetherWartRoom.func_40021_a(structureBoundingBox) || StructureComponent.getIntersectingStructureComponent(list, structureBoundingBox) != null) {
            return null;
        }
        return new NetherFortressComponentNetherWartRoom(n5, random, structureBoundingBox, n4);
    }

    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureBoundingBox) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
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
        for (n5 = 1; n5 <= 11; n5 += 2) {
            this.fillWithBlocks(world, structureBoundingBox, n5, 10, 0, n5, 11, 0, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
            this.fillWithBlocks(world, structureBoundingBox, n5, 10, 12, n5, 11, 12, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
            this.fillWithBlocks(world, structureBoundingBox, 0, 10, n5, 0, 11, n5, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
            this.fillWithBlocks(world, structureBoundingBox, 12, 10, n5, 12, 11, n5, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
            this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK.id, 0, n5, 13, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK.id, 0, n5, 13, 12, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK.id, 0, 0, 13, n5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK.id, 0, 12, 13, n5, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, 0, n5 + 1, 13, 0, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, 0, n5 + 1, 13, 12, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, 0, 0, 13, n5 + 1, structureBoundingBox);
            this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, 0, 12, 13, n5 + 1, structureBoundingBox);
        }
        this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, 0, 0, 13, 0, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, 0, 0, 13, 12, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, 0, 0, 13, 0, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, 0, 12, 13, 0, structureBoundingBox);
        for (n5 = 3; n5 <= 9; n5 += 2) {
            this.fillWithBlocks(world, structureBoundingBox, 1, 7, n5, 1, 8, n5, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
            this.fillWithBlocks(world, structureBoundingBox, 11, 7, n5, 11, 8, n5, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        }
        n5 = this.func_35009_c(YuniBackport_r0.BLOCK_NETHER_BRICK_STAIRS.id, 3);
        for (n4 = 0; n4 <= 6; ++n4) {
            n3 = n4 + 4;
            for (n2 = 5; n2 <= 7; ++n2) {
                this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_STAIRS.id, n5, n2, 5 + n4, n3, structureBoundingBox);
            }
            if (n3 >= 5 && n3 <= 8) {
                this.fillWithBlocks(world, structureBoundingBox, 5, 5, n3, 7, n4 + 4, n3, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
            } else if (n3 >= 9 && n3 <= 10) {
                this.fillWithBlocks(world, structureBoundingBox, 5, 8, n3, 7, n4 + 4, n3, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
            }
            if (n4 < 1) continue;
            this.fillWithBlocks(world, structureBoundingBox, 5, 6 + n4, n3, 7, 9 + n4, n3, 0, 0, false);
        }
        for (n4 = 5; n4 <= 7; ++n4) {
            this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_STAIRS.id, n5, n4, 12, 11, structureBoundingBox);
        }
        this.fillWithBlocks(world, structureBoundingBox, 5, 6, 7, 5, 7, 7, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 7, 6, 7, 7, 7, 7, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, YuniBackport_r0.BLOCK_NETHER_BRICK_FENCE.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 5, 13, 12, 7, 13, 12, 0, 0, false);
        this.fillWithBlocks(world, structureBoundingBox, 2, 5, 2, 3, 5, 3, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 2, 5, 9, 3, 5, 10, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 2, 5, 4, 2, 5, 8, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 9, 5, 2, 10, 5, 3, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 9, 5, 9, 10, 5, 10, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 10, 5, 4, 10, 5, 8, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        n4 = this.func_35009_c(YuniBackport_r0.BLOCK_NETHER_BRICK_STAIRS.id, 0);
        n3 = this.func_35009_c(YuniBackport_r0.BLOCK_NETHER_BRICK_STAIRS.id, 1);
        this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_STAIRS.id, n3, 4, 5, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_STAIRS.id, n3, 4, 5, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_STAIRS.id, n3, 4, 5, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_STAIRS.id, n3, 4, 5, 10, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_STAIRS.id, n4, 8, 5, 2, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_STAIRS.id, n4, 8, 5, 3, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_STAIRS.id, n4, 8, 5, 9, structureBoundingBox);
        this.placeBlockAtCurrentPosition(world, YuniBackport_r0.BLOCK_NETHER_BRICK_STAIRS.id, n4, 8, 5, 10, structureBoundingBox);
        this.fillWithBlocks(world, structureBoundingBox, 3, 4, 4, 4, 4, 8, Block.SOUL_SAND.id, Block.SOUL_SAND.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 8, 4, 4, 9, 4, 8, Block.SOUL_SAND.id, Block.SOUL_SAND.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 3, 5, 4, 4, 5, 8, YuniBackport_r0.BLOCK_NETHER_WART_CROP.id, YuniBackport_r0.BLOCK_NETHER_WART_CROP.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 8, 5, 4, 9, 5, 8, YuniBackport_r0.BLOCK_NETHER_WART_CROP.id, YuniBackport_r0.BLOCK_NETHER_WART_CROP.id, false);
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
        return true;
    }
}
