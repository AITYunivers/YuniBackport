package io.github.yunivers.yunibackport_r0.structure.fortress;

import io.github.yunivers.yunibackport_r0.entity.mob.BlazeEntity;
import io.github.yunivers.yunibackport_r0.structure.*;
import net.minecraft.entity.mob.PigZombieEntity;
import net.minecraft.world.biome.EntitySpawnGroup;
import net.minecraft.world.gen.carver.Carver;

import java.util.ArrayList;
import java.util.List;

public class NetherFortressGenerator extends StructureGenerator
{
    private final List<EntitySpawnGroup> field_40486_a = new ArrayList<>();

    public NetherFortressGenerator()
    {
        this.field_40486_a.add(new EntitySpawnGroup(BlazeEntity.class, 10));
        this.field_40486_a.add(new EntitySpawnGroup(PigZombieEntity.class, 10));
        //this.field_40486_a.add(new EntitySpawnGroup(EntityMagmaCube.class, 3, 4, 4));
    }

    public List<EntitySpawnGroup> func_40485_b()
    {
        return this.field_40486_a;
    }

    protected boolean canSpawnStructureAtCoords(int n, int n2)
    {
        int n3 = n >> 4;
        int n4 = n2 >> 4;
        this.random.setSeed((long)(n3 ^ n4 << 4) ^ this.world.getSeed());
        this.random.nextInt();
        if (this.random.nextInt(3) != 0) {
            return false;
        }
        if (n != (n3 << 4) + 4 + this.random.nextInt(8)) {
            return false;
        }
        return n2 == (n4 << 4) + 4 + this.random.nextInt(8);
    }

    protected StructureStart getStructureStart(int n, int n2)
    {
        return new NetherFortressStructureStart(this.world, this.random, n, n2);
    }
}
