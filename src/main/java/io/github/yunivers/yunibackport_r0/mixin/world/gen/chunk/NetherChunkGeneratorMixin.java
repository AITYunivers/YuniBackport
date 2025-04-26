package io.github.yunivers.yunibackport_r0.mixin.world.gen.chunk;

import com.llamalad7.mixinextras.sugar.Local;
import io.github.yunivers.yunibackport_r0.structure.fortress.NetherFortressGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkSource;
import net.minecraft.world.gen.chunk.NetherChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(NetherChunkGenerator.class)
public abstract class NetherChunkGeneratorMixin implements ChunkSource
{
    @Shadow private World world;
    @Shadow private Random random;
    @Unique
    public NetherFortressGenerator fortressGenerator = new NetherFortressGenerator();

    @Inject(
        method = "getChunk",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/gen/carver/Carver;carve(Lnet/minecraft/world/chunk/ChunkSource;Lnet/minecraft/world/World;II[B)V"
        )
    )
    public void yunibackport$getChunk_generateFortress(int chunkX, int chunkZ, CallbackInfoReturnable<Chunk> cir, @Local byte[] chunKData)
    {
        fortressGenerator.carve(this, world, chunkX, chunkZ, chunKData);
    }

    @Inject(
        method = "decorate",
        at = @At("HEAD")
    )
    public void yunibackport$decorate_generateFortress(ChunkSource source, int x, int z, CallbackInfo ci)
    {
        fortressGenerator.generateStructuresInChunk(world, random, x, z);
    }
}
