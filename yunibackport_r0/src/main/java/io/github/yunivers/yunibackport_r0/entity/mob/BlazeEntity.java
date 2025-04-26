package io.github.yunivers.yunibackport_r0.entity.mob;

import io.github.yunivers.yunibackport_r0.YuniBackport_r0;
import io.github.yunivers.yunibackport_r0.entity.projectile.SmallFireballEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.MonsterEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class BlazeEntity extends MonsterEntity
{
    private float attackGaussian = 0.5f;
    private int blazeAttackCooldown;
    private int idkYet;

    public BlazeEntity(World world)
    {
        super(world);
        this.texture = "assets/yunibackport_r0/stationapi/textures/mob/blaze.png";
        maxHealth = 20;
        attackDamage = 6;
    }

    @Override
    protected void initDataTracker()
    {
        super.initDataTracker();
        this.dataTracker.startTracking(16, (byte)0);
    }

    @Override
    protected String getRandomSound()
    {
        return "mob.blaze.breathe";
    }

    @Override
    protected String getHurtSound()
    {
        return "mob.blaze.hit";
    }

    @Override
    protected String getDeathSound()
    {
        return "mob.blaze.death";
    }

    @Override
    public float getBrightnessAtEyes(float tickDelta)
    {
        return 1.0f;
    }

    @Override
    public void tickLiving()
    {
        if (!world.isRemote)
        {
            if (isWet())
                damage(1);
            blazeAttackCooldown--;
            if (blazeAttackCooldown <= 0)
            {
                blazeAttackCooldown = 100;
                attackGaussian = 0.5f + (float)random.nextGaussian() * 3.0f;
            }
            if (getTarget() != null && getTarget().y + getTarget().getEyeHeight() > y + getEyeHeight() + attackGaussian)
                velocityY += ((double)0.3f - this.velocityY) * (double)0.3f;
        }
        if (!onGround && velocityY < 0.0)
            velocityY *= 0.6;
        super.tickLiving();
    }

    @Override
    protected void attack(Entity other, float distance)
    {
        if (attackCooldown <= 0 && distance < 2.0f && other.boundingBox.maxY > this.boundingBox.minY && other.boundingBox.minY < this.boundingBox.maxY)
        {
            attackCooldown = 20;
            super.attack(other, distance);
        }
        else if (distance < 30.0f)
        {
            double d = other.x - this.x;
            double d2 = other.boundingBox.minY + (double)(other.height / 2.0f) - (this.y + (double)(this.height / 2.0f));
            double d3 = other.z - this.z;
            if (attackCooldown == 0)
            {
                ++this.idkYet;
                if (this.idkYet == 1)
                {
                    attackCooldown = 60;
                    this.setPreparingToAttack(true);
                }
                else if (this.idkYet <= 4)
                {
                    attackCooldown = 6;
                }
                else
                {
                    attackCooldown = 100;
                    this.idkYet = 0;
                    this.setPreparingToAttack(false);
                }
                if (this.idkYet > 1)
                {
                    float f2 = MathHelper.sqrt(distance) * 0.5f;
                    this.world.playSound(this, "mob.ghast.fireball", this.getSoundVolume(), (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
                    for (int i = 0; i < 1; ++i) {
                        SmallFireballEntity entitySmallFireball = new SmallFireballEntity(world, this, d + random.nextGaussian() * (double)f2, d2, d3 + random.nextGaussian() * (double)f2);
                        entitySmallFireball.y = this.y + (double)(this.height / 2.0f) + 0.5;
                        this.world.spawnEntity(entitySmallFireball);
                    }
                }
            }
            this.yaw = (float)(Math.atan2(d3, d) * 180.0 / 3.1415927410125732) - 90.0f;
            this.movementBlocked = true;
        }
    }

    public void setPreparingToAttack(boolean value)
    {
        byte flags = this.dataTracker.getByte(16);
        flags = value ? (byte)(flags | 1) : (byte)(flags & 0xFFFFFFFE);
        this.dataTracker.set(16, flags);
    }

    @Override
    public boolean isOnFire()
    {
        return (this.dataTracker.getByte(16) & 1) != 0;
    }

    @Override
    public boolean yunibackport$isFireImmune()
    {
        return true;
    }

    @Override
    protected void onLanding(float fallDistance)
    {

    }

    @Override
    protected int getDroppedItemId()
    {
        return YuniBackport_r0.ITEM_BLAZE_ROD.id;
    }

    @Override
    public void onKilledBy(Entity adversary)
    {
        if (this.scoreAmount >= 0 && adversary != null)
            adversary.updateKilledAchievement(this, this.scoreAmount);

        if (adversary != null)
            adversary.onKilledOther(this);

        this.killedByOtherEntity = true;
        if (!this.world.isRemote && adversary instanceof PlayerEntity || adversary instanceof WolfEntity wolf && wolf.isTamed())
            this.dropItems();

        this.world.broadcastEntityEvent(this, (byte)3);
    }

    @Override
    protected void dropItems()
    {
        int dropCount = this.random.nextInt(2);
        for (int i = 0; i < dropCount; i++)
            this.dropItem(YuniBackport_r0.ITEM_BLAZE_ROD.id, 1);
    }
}
