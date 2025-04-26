package io.github.yunivers.yunibackport_r0.mixin.item;

import com.llamalad7.mixinextras.sugar.Local;
import io.github.yunivers.yunibackport_r0.impl.item.YuniBackportDoorItem;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DoorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DoorItem.class)
public abstract class DoorItemMixin implements YuniBackportDoorItem
{
    @Inject(
        method = "useOnBlock",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/util/math/MathHelper;floor(D)I"
        ),
        cancellable = true
    )
    public void yunibackport$useOnBlock_usePlaceDoorBlock(ItemStack stack, PlayerEntity user, World world, int x, int y, int z, int side, CallbackInfoReturnable<Boolean> cir, @Local Block block)
    {
        yunibackport$placeDoorBlock(world, x, y, z, MathHelper.floor((double)((user.yaw + 180.0F) * 4.0F / 360.0F) - 0.5) & 3, block);
        stack.count--;
        cir.setReturnValue(true);
    }

    @Override
    @Unique
    public void yunibackport$placeDoorBlock(World world, int x, int y, int z, int facing, Block block)
    {
        byte var10 = 0;
        byte var11 = 0;
        if (facing == 0) {
            var11 = 1;
        }

        if (facing == 1) {
            var10 = -1;
        }

        if (facing == 2) {
            var11 = -1;
        }

        if (facing == 3) {
            var10 = 1;
        }

        int var12 = (world.shouldSuffocate(x - var10, y, z - var11) ? 1 : 0) + (world.shouldSuffocate(x - var10, y + 1, z - var11) ? 1 : 0);
        int var13 = (world.shouldSuffocate(x + var10, y, z + var11) ? 1 : 0) + (world.shouldSuffocate(x + var10, y + 1, z + var11) ? 1 : 0);
        boolean var14 = world.getBlockId(x - var10, y, z - var11) == block.id || world.getBlockId(x - var10, y + 1, z - var11) == block.id;
        boolean var15 = world.getBlockId(x + var10, y, z + var11) == block.id || world.getBlockId(x + var10, y + 1, z + var11) == block.id;
        boolean var16 = false;
        if (var14 && !var15) {
            var16 = true;
        } else if (var13 > var12) {
            var16 = true;
        }

        if (var16) {
            facing = facing - 1 & 3;
            facing += 4;
        }

        world.pauseTicking = true;
        world.setBlock(x, y, z, block.id, facing);
        world.setBlock(x, y + 1, z, block.id, facing + 8);
        world.pauseTicking = false;
        world.notifyNeighbors(x, y, z, block.id);
        world.notifyNeighbors(x, y + 1, z, block.id);
    }
}
