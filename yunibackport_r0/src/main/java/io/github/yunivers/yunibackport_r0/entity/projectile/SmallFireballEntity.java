package io.github.yunivers.yunibackport_r0.entity.projectile;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class SmallFireballEntity extends FireballEntity
{
    public SmallFireballEntity(World world)
    {
        super(world);
        width = height = 0.3125f;
    }

    public SmallFireballEntity(World world, double x, double y, double z, double velocityX, double velocityY, double velocityZ)
    {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
        width = height = 0.3125f;
    }

    public SmallFireballEntity(World world, LivingEntity owner, double velocityX, double velocityY, double velocityZ)
    {
        super(world, owner, velocityX, velocityY, velocityZ);
        width = height = 0.3125f;
    }

    @Override
    public boolean isCollidable()
    {
        return false;
    }

    @Override
    public boolean damage(Entity damageSource, int amount)
    {
        return false;
    }

    @Override
    public void yunibackport$onHitEntity(HitResult hit)
    {
        if (!world.isRemote)
        {
            if (hit.entity != null)
            {
                if (!hit.entity.yunibackport$isFireImmune() && hit.entity.damage(this, 5))
                    hit.entity.yunibackport$setOnFire(5);
            }
            else
            {
                int x = hit.blockX;
                int y = hit.blockY;
                int z = hit.blockZ;
                switch (hit.side)
                {
                    case 0:
                        --y;
                        break;
                    case 1:
                        ++y;
                        break;
                    case 2:
                        --z;
                        break;
                    case 3:
                        ++z;
                        break;
                    case 4:
                        --x;
                        break;
                    case 5:
                        ++x;
                        break;
                }
                if (world.isAir(x, y, z))
                    world.setBlock(x, y, z, Block.FIRE.id);
            }
            markDead();
        }
    }
}
