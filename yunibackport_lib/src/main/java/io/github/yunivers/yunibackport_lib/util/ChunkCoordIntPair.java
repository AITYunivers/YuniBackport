package io.github.yunivers.yunibackport_lib.util;

import net.minecraft.util.math.BlockPos;

public class ChunkCoordIntPair
{
    public final int chunkXPos;
    public final int chunkZPos;

    public ChunkCoordIntPair(int n, int n2)
    {
        this.chunkXPos = n;
        this.chunkZPos = n2;
    }

    public static long chunkXZ2Int(int n, int n2)
    {
        return (long)n & 0xFFFFFFFFL | ((long)n2 & 0xFFFFFFFFL) << 32;
    }

    public int hashCode()
    {
        long l = ChunkCoordIntPair.chunkXZ2Int(this.chunkXPos, this.chunkZPos);
        int n = (int)l;
        int n2 = (int)(l >> 32);
        return n ^ n2;
    }

    public boolean equals(ChunkCoordIntPair other)
    {
        return other.chunkXPos == this.chunkXPos && other.chunkZPos == this.chunkZPos;
    }

    public int getCenterX()
    {
        return (this.chunkXPos << 4) + 8;
    }

    public int getCenterZ()
    {
        return (this.chunkZPos << 4) + 8;
    }

    public BlockPos toBlockPos(int y)
    {
        return new BlockPos(this.getCenterX(), y, this.getCenterZ());
    }

    public String toString() {
        return "[" + this.chunkXPos + ", " + this.chunkZPos + "]";
    }
}
