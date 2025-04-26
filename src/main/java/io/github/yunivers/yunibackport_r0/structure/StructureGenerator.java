package io.github.yunivers.yunibackport_r0.structure;

import io.github.yunivers.yunibackport_r0.events.init.InitListener;
import io.github.yunivers.yunibackport_r0.util.ChunkCoordIntPair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkSource;
import net.minecraft.world.gen.carver.Carver;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public abstract class StructureGenerator extends Carver
{
    protected HashMap<Long, StructureStart> coordMap = new HashMap<>();
    protected World world;

    public void carve(ChunkSource iChunkProvider, World world, int n, int n2, byte[] byArray) {
        this.world = world;
        super.carve(iChunkProvider, world, n, n2, byArray);
    }

    protected void carve(World world, int n, int n2, int n3, int n4, byte[] byArray) {
        this.world = world;
        if (this.coordMap.containsKey(ChunkCoordIntPair.chunkXZ2Int(n, n2))) {
            return;
        }
        this.random.nextInt();
        if (this.canSpawnStructureAtCoords(n, n2)) {
            StructureStart structureStart = this.getStructureStart(n, n2);
            InitListener.LOGGER.info("Spawned Fortress at ({}, {}, {})", n * 16 + 8, 65, n2 * 16 + 8);
            this.coordMap.put(ChunkCoordIntPair.chunkXZ2Int(n, n2), structureStart);
        }
    }

    public boolean generateStructuresInChunk(World world, Random random, int n, int n2) {
        int n3 = (n << 4) + 8;
        int n4 = (n2 << 4) + 8;
        boolean bl = false;
        for (StructureStart structureStart : this.coordMap.values()) {
            if (!structureStart.isSizeableStructure() || !structureStart.getBoundingBox().isInsideStructureBB(n3, n4, n3 + 15, n4 + 15)) continue;
            structureStart.generateStructure(world, random, new StructureBoundingBox(n3, n4, n3 + 15, n4 + 15));
            bl = true;
        }
        return bl;
    }

    public boolean func_40483_a(int n, int n2, int n3) {
        for (StructureStart structureStart : this.coordMap.values()) {
            if (!structureStart.isSizeableStructure() || !structureStart.getBoundingBox().isInsideStructureBB(n, n3, n, n3)) continue;
            for (StructureComponent structureComponent : structureStart.func_40560_b()) {
                if (!structureComponent.getBoundingBox().isVecInside(n, n2, n3)) continue;
                return true;
            }
        }
        return false;
    }

    public BlockPos func_40484_a(World world, int n, int n2, int n3) {
        double d;
        int n4;
        int n5;
        int n6;
        BlockPos chunkPosition;
        this.world = world;
        this.random.setSeed(world.getSeed());
        long l = this.random.nextLong();
        long l2 = this.random.nextLong();
        long l3 = (long)(n >> 4) * l;
        long l4 = (long)(n3 >> 4) * l2;
        this.random.setSeed(l3 ^ l4 ^ world.getSeed());
        this.carve(world, n >> 4, n3 >> 4, 0, 0, null);
        double d2 = Double.MAX_VALUE;
        BlockPos chunkPosition2 = null;
        for (StructureStart object2 : this.coordMap.values()) {
            if (!object2.isSizeableStructure()) continue;
            chunkPosition = object2.func_40560_b().get(0).func_40008_a_();
            n6 = chunkPosition.x - n;
            n5 = chunkPosition.y - n2;
            n4 = chunkPosition.z - n3;
            d = n6 + n6 * n5 * n5 + n4 * n4;
            if (!(d < d2)) continue;
            d2 = d;
            chunkPosition2 = chunkPosition;
        }
        if (chunkPosition2 != null) {
            return chunkPosition2;
        }
        List<BlockPos> list = this.func_40482_a();
        if (list != null) {
            BlockPos object2 = null;
            for (BlockPos blockPos : list)
            {
                chunkPosition = blockPos;
                n6 = chunkPosition.x - n;
                n5 = chunkPosition.y - n2;
                n4 = chunkPosition.z - n3;
                d = n6 + n6 * n5 * n5 + n4 * n4;
                if (!(d < d2)) continue;
                d2 = d;
                object2 = chunkPosition;
            }
            return object2;
        }
        return null;
    }

    protected List<BlockPos> func_40482_a() {
        return null;
    }

    protected abstract boolean canSpawnStructureAtCoords(int var1, int var2);

    protected abstract StructureStart getStructureStart(int var1, int var2);
}
