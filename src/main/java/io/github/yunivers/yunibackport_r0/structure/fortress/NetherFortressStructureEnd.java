package io.github.yunivers.yunibackport_r0.structure.fortress;

import io.github.yunivers.yunibackport_r0.YuniBackport_r0;
import io.github.yunivers.yunibackport_r0.structure.*;
import io.github.yunivers.yunibackport_r0.structure.fortress.component.*;
import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class NetherFortressStructureEnd extends NetherFortressComponentPiece
{
    private final int seed;

    public NetherFortressStructureEnd(int n, Random random, StructureBoundingBox structureBoundingBox, int n2) {
        super(n);
        this.coordBaseMode = n2;
        this.boundingBox = structureBoundingBox;
        this.seed = random.nextInt();
    }

    public void buildComponent(StructureComponent structureComponent, List<StructureComponent> list, Random random) {
    }

    public static NetherFortressStructureEnd func_40023_a(List<StructureComponent> list, Random random, int n, int n2, int n3, int n4, int n5) {
        StructureBoundingBox structureBoundingBox = StructureBoundingBox.getComponentToAddBoundingBox(n, n2, n3, -1, -3, 0, 5, 10, 8, n4);
        if (!NetherFortressStructureEnd.func_40021_a(structureBoundingBox) || StructureComponent.getIntersectingStructureComponent(list, structureBoundingBox) != null) {
            return null;
        }
        return new NetherFortressStructureEnd(n5, random, structureBoundingBox, n4);
    }

    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureBoundingBox) {
        int n;
        int n2;
        int n3;
        Random random2 = new Random(this.seed);
        for (n3 = 0; n3 <= 4; ++n3) {
            for (n2 = 3; n2 <= 4; ++n2) {
                n = random2.nextInt(8);
                this.fillWithBlocks(world, structureBoundingBox, n3, n2, 0, n3, n2, n, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
            }
        }
        n3 = random2.nextInt(8);
        this.fillWithBlocks(world, structureBoundingBox, 0, 5, 0, 0, 5, n3, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        n3 = random2.nextInt(8);
        this.fillWithBlocks(world, structureBoundingBox, 4, 5, 0, 4, 5, n3, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        for (n3 = 0; n3 <= 4; ++n3) {
            n2 = random2.nextInt(5);
            this.fillWithBlocks(world, structureBoundingBox, n3, 2, 0, n3, 2, n2, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
        }
        for (n3 = 0; n3 <= 4; ++n3) {
            for (n2 = 0; n2 <= 1; ++n2) {
                n = random2.nextInt(3);
                this.fillWithBlocks(world, structureBoundingBox, n3, n2, 0, n3, n2, n, YuniBackport_r0.BLOCK_NETHER_BRICK.id, YuniBackport_r0.BLOCK_NETHER_BRICK.id, false);
            }
        }
        return true;
    }
}
