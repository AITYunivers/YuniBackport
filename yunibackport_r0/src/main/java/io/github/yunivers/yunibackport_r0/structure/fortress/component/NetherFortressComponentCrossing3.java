package io.github.yunivers.yunibackport_r0.structure.fortress.component;

import io.github.yunivers.yunibackport_r0.YuniBackport_r0;
import io.github.yunivers.yunibackport_lib.structure.*;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class NetherFortressComponentCrossing3 extends NetherFortressComponentPiece
{
    public NetherFortressComponentCrossing3(int n, Random random, StructureBoundingBox structureBoundingBox, int n2) {
        super(n);
        this.coordBaseMode = n2;
        this.boundingBox = structureBoundingBox;
    }

    protected NetherFortressComponentCrossing3(Random random, int n, int n2) {
        super(0);
        this.coordBaseMode = random.nextInt(4);
        switch (this.coordBaseMode) {
            case 0:
            case 2: {
                this.boundingBox = new StructureBoundingBox(n, 64, n2, n + 19 - 1, 73, n2 + 19 - 1);
                break;
            }
            default: {
                this.boundingBox = new StructureBoundingBox(n, 64, n2, n + 19 - 1, 73, n2 + 19 - 1);
            }
        }
    }

    public void buildComponent(StructureComponent structureComponent, List<StructureComponent> list, Random random) {
        this.func_40022_a((NetherFortressComponentStartPiece)structureComponent, list, random, 8, 3, false);
        this.func_40019_b((NetherFortressComponentStartPiece)structureComponent, list, random, 3, 8, false);
        this.func_40016_c((NetherFortressComponentStartPiece)structureComponent, list, random, 3, 8, false);
    }

    public static NetherFortressComponentCrossing3 func_40033_a(List<StructureComponent> list, Random random, int n, int n2, int n3, int n4, int n5) {
        StructureBoundingBox structureBoundingBox = StructureBoundingBox.getComponentToAddBoundingBox(n, n2, n3, -8, -3, 0, 19, 10, 19, n4);
        if (!NetherFortressComponentCrossing3.func_40021_a(structureBoundingBox) || StructureComponent.getIntersectingStructureComponent(list, structureBoundingBox) != null) {
            return null;
        }
        return new NetherFortressComponentCrossing3(n5, random, structureBoundingBox, n4);
    }

    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureBoundingBox) {
        int n;
        int n2;
        this.fillWithBlocks(world, structureBoundingBox, 7, 3, 0, 11, 4, 18, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 3, 7, 18, 4, 11, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 8, 5, 0, 10, 7, 18, 0, 0, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 5, 8, 18, 7, 10, 0, 0, false);
        this.fillWithBlocks(world, structureBoundingBox, 7, 5, 0, 7, 5, 7, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 7, 5, 11, 7, 5, 18, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 11, 5, 0, 11, 5, 7, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 11, 5, 11, 11, 5, 18, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 5, 7, 7, 5, 7, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 11, 5, 7, 18, 5, 7, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 5, 11, 7, 5, 11, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 11, 5, 11, 18, 5, 11, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 7, 2, 0, 11, 2, 5, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 7, 2, 13, 11, 2, 18, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 7, 0, 0, 11, 1, 3, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 7, 0, 15, 11, 1, 18, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        for (n2 = 7; n2 <= 11; ++n2) {
            for (n = 0; n <= 2; ++n) {
                this.fillCurrentPositionBlocksDownwards(world, YuniBackport_r0.BLOCK_NETHER_BRICK.id, 0, n2, -1, n, structureBoundingBox);
                this.fillCurrentPositionBlocksDownwards(world, YuniBackport_r0.BLOCK_NETHER_BRICK.id, 0, n2, -1, 18 - n, structureBoundingBox);
            }
        }
        this.fillWithBlocks(world, structureBoundingBox, 0, 2, 7, 5, 2, 11, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 13, 2, 7, 18, 2, 11, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 0, 0, 7, 3, 1, 11, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        this.fillWithBlocks(world, structureBoundingBox, 15, 0, 7, 18, 1, 11, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        for (n2 = 0; n2 <= 2; ++n2) {
            for (n = 7; n <= 11; ++n) {
                this.fillCurrentPositionBlocksDownwards(world, YuniBackport_r0.BLOCK_NETHER_BRICK.id, 0, n2, -1, n, structureBoundingBox);
                this.fillCurrentPositionBlocksDownwards(world, YuniBackport_r0.BLOCK_NETHER_BRICK.id, 0, 18 - n2, -1, n, structureBoundingBox);
            }
        }
        return true;
    }
}
