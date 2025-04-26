package io.github.yunivers.yunibackport_lib.structure;

import io.github.yunivers.yunibackport_lib.util.WeightedRandom;
import lombok.Getter;
import net.minecraft.block.Block;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.item.DoorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.modificationstation.stationapi.impl.util.math.ChunkPos;

import java.util.List;
import java.util.Random;

public abstract class StructureComponent
{
    @Getter
    protected StructureBoundingBox boundingBox;
    protected int coordBaseMode;
    protected int field_35026_i;

    protected StructureComponent(int n) {
        this.field_35026_i = n;
        this.coordBaseMode = -1;
    }



    public void buildComponent(StructureComponent structureComponent, List<StructureComponent> list, Random random) {
    }

    public abstract boolean addComponentParts(World var1, Random var2, StructureBoundingBox var3);

    public int func_35012_c() {
        return this.field_35026_i;
    }

    public static StructureComponent getIntersectingStructureComponent(List<StructureComponent> list, StructureBoundingBox structureBoundingBox) {
        for (StructureComponent structureComponent : list) {
            if (structureComponent.getBoundingBox() == null || !structureComponent.getBoundingBox().intersectsWith(structureBoundingBox)) continue;
            return structureComponent;
        }
        return null;
    }

    public BlockPos func_40008_a_() {
        return new BlockPos(this.boundingBox.getCenterX(), this.boundingBox.getCenterY(), this.boundingBox.getCenterZ());
    }

    protected boolean isLiquidInStructureBoundingBox(World world, StructureBoundingBox structureBoundingBox) {
        int n;
        int n2;
        int n3;
        int n4 = Math.max(this.boundingBox.minX - 1, structureBoundingBox.minX);
        int n5 = Math.max(this.boundingBox.minY - 1, structureBoundingBox.minY);
        int n6 = Math.max(this.boundingBox.minZ - 1, structureBoundingBox.minZ);
        int n7 = Math.min(this.boundingBox.maxX + 1, structureBoundingBox.maxX);
        int n8 = Math.min(this.boundingBox.maxY + 1, structureBoundingBox.maxY);
        int n9 = Math.min(this.boundingBox.maxZ + 1, structureBoundingBox.maxZ);
        for (n3 = n4; n3 <= n7; ++n3) {
            for (n2 = n6; n2 <= n9; ++n2) {
                n = world.getBlockId(n3, n5, n2);
                if (n > 0 && Block.BLOCKS[n].material.isFluid()) {
                    return true;
                }
                n = world.getBlockId(n3, n8, n2);
                if (n <= 0 || !Block.BLOCKS[n].material.isFluid()) continue;
                return true;
            }
        }
        for (n3 = n4; n3 <= n7; ++n3) {
            for (n2 = n5; n2 <= n8; ++n2) {
                n = world.getBlockId(n3, n2, n6);
                if (n > 0 && Block.BLOCKS[n].material.isFluid()) {
                    return true;
                }
                n = world.getBlockId(n3, n2, n9);
                if (n <= 0 || !Block.BLOCKS[n].material.isFluid()) continue;
                return true;
            }
        }
        for (n3 = n6; n3 <= n9; ++n3) {
            for (n2 = n5; n2 <= n8; ++n2) {
                n = world.getBlockId(n4, n2, n3);
                if (n > 0 && Block.BLOCKS[n].material.isFluid()) {
                    return true;
                }
                n = world.getBlockId(n7, n2, n3);
                if (n <= 0 || !Block.BLOCKS[n].material.isFluid()) continue;
                return true;
            }
        }
        return false;
    }

    protected int getXWithOffset(int n, int n2) {
        return switch (this.coordBaseMode) {
            case 0, 2 -> this.boundingBox.minX + n;
            case 1 -> this.boundingBox.maxX - n2;
            case 3 -> this.boundingBox.minX + n2;
            default -> n;
        };
    }

    protected int getYWithOffset(int n) {
        if (this.coordBaseMode == -1) {
            return n;
        }
        return n + this.boundingBox.minY;
    }

    protected int getZWithOffset(int n, int n2) {
        switch (this.coordBaseMode) {
            case 2: {
                return this.boundingBox.maxZ - n2;
            }
            case 0: {
                return this.boundingBox.minZ + n2;
            }
            case 1:
            case 3: {
                return this.boundingBox.minZ + n;
            }
        }
        return n2;
    }

    protected int func_35009_c(int n, int n2) {
        if (n == Block.RAIL.id) {
            if (this.coordBaseMode == 1 || this.coordBaseMode == 3) {
                if (n2 == 1) {
                    return 0;
                }
                return 1;
            }
        } else if (n == Block.DOOR.id || n == Block.IRON_DOOR.id) {
            if (this.coordBaseMode == 0) {
                if (n2 == 0) {
                    return 2;
                }
                if (n2 == 2) {
                    return 0;
                }
            } else {
                if (this.coordBaseMode == 1) {
                    return n2 + 1 & 3;
                }
                if (this.coordBaseMode == 3) {
                    return n2 + 3 & 3;
                }
            }
        } else if (n == Block.COBBLESTONE_STAIRS.id || n == Block.WOODEN_STAIRS.id /*|| n == Block.stairsNetherBrick.blockID || n == Block.stairsStoneBrickSmooth.blockID*/) {
            if (this.coordBaseMode == 0) {
                if (n2 == 2) {
                    return 3;
                }
                if (n2 == 3) {
                    return 2;
                }
            } else if (this.coordBaseMode == 1) {
                if (n2 == 0) {
                    return 2;
                }
                if (n2 == 1) {
                    return 3;
                }
                if (n2 == 2) {
                    return 0;
                }
                if (n2 == 3) {
                    return 1;
                }
            } else if (this.coordBaseMode == 3) {
                if (n2 == 0) {
                    return 2;
                }
                if (n2 == 1) {
                    return 3;
                }
                if (n2 == 2) {
                    return 1;
                }
                if (n2 == 3) {
                    return 0;
                }
            }
        } else if (n == Block.LADDER.id) {
            if (this.coordBaseMode == 0) {
                if (n2 == 2) {
                    return 3;
                }
                if (n2 == 3) {
                    return 2;
                }
            } else if (this.coordBaseMode == 1) {
                if (n2 == 2) {
                    return 4;
                }
                if (n2 == 3) {
                    return 5;
                }
                if (n2 == 4) {
                    return 2;
                }
                if (n2 == 5) {
                    return 3;
                }
            } else if (this.coordBaseMode == 3) {
                if (n2 == 2) {
                    return 5;
                }
                if (n2 == 3) {
                    return 4;
                }
                if (n2 == 4) {
                    return 2;
                }
                if (n2 == 5) {
                    return 3;
                }
            }
        } else if (n == Block.BUTTON.id) {
            if (this.coordBaseMode == 0) {
                if (n2 == 3) {
                    return 4;
                }
                if (n2 == 4) {
                    return 3;
                }
            } else if (this.coordBaseMode == 1) {
                if (n2 == 3) {
                    return 1;
                }
                if (n2 == 4) {
                    return 2;
                }
                if (n2 == 2) {
                    return 3;
                }
                if (n2 == 1) {
                    return 4;
                }
            } else if (this.coordBaseMode == 3) {
                if (n2 == 3) {
                    return 2;
                }
                if (n2 == 4) {
                    return 1;
                }
                if (n2 == 2) {
                    return 3;
                }
                if (n2 == 1) {
                    return 4;
                }
            }
        }
        return n2;
    }

    protected void placeBlockAtCurrentPosition(World world, int n, int n2, int n3, int n4, int n5, StructureBoundingBox structureBoundingBox) {
        int n6 = this.getZWithOffset(n3, n5);
        int n7 = this.getYWithOffset(n4);
        int n8 = this.getXWithOffset(n3, n5);
        if (!structureBoundingBox.isVecInside(n8, n7, n6)) {
            return;
        }
        world.setBlock(n8, n7, n6, n, n2);
    }

    protected int getBlockIdAtCurrentPosition(World world, int n, int n2, int n3, StructureBoundingBox structureBoundingBox) {
        int n4;
        int n5;
        int n6 = this.getXWithOffset(n, n3);
        if (!structureBoundingBox.isVecInside(n6, n5 = this.getYWithOffset(n2), n4 = this.getZWithOffset(n, n3))) {
            return 0;
        }
        return world.getBlockId(n6, n5, n4);
    }

    protected void fillWithBlocks(World world, StructureBoundingBox structureBoundingBox, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, boolean bl) {
        for (int i = n2; i <= n5; ++i) {
            for (int j = n; j <= n4; ++j) {
                for (int k = n3; k <= n6; ++k) {
                    if (bl && this.getBlockIdAtCurrentPosition(world, j, i, k, structureBoundingBox) == 0) continue;
                    if (i == n2 || i == n5 || j == n || j == n4 || k == n3 || k == n6) {
                        this.placeBlockAtCurrentPosition(world, n7, 0, j, i, k, structureBoundingBox);
                        continue;
                    }
                    this.placeBlockAtCurrentPosition(world, n8, 0, j, i, k, structureBoundingBox);
                }
            }
        }
    }

    protected void fillWithRandomizedBlocks(World world, StructureBoundingBox structureBoundingBox, int n, int n2, int n3, int n4, int n5, int n6, boolean bl, Random random, StructurePieceBlockSelector structurePieceBlockSelector) {
        for (int i = n2; i <= n5; ++i) {
            for (int j = n; j <= n4; ++j) {
                for (int k = n3; k <= n6; ++k) {
                    if (bl && this.getBlockIdAtCurrentPosition(world, j, i, k, structureBoundingBox) == 0) continue;
                    structurePieceBlockSelector.selectBlocks(random, j, i, k, i == n2 || i == n5 || j == n || j == n4 || k == n3 || k == n6);
                    this.placeBlockAtCurrentPosition(world, structurePieceBlockSelector.getSelectedBlockId(), structurePieceBlockSelector.getSelectedBlockMetaData(), j, i, k, structureBoundingBox);
                }
            }
        }
    }

    protected void randomlyFillWithBlocks(World world, StructureBoundingBox structureBoundingBox, Random random, float f, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, boolean bl) {
        for (int i = n2; i <= n5; ++i) {
            for (int j = n; j <= n4; ++j) {
                for (int k = n3; k <= n6; ++k) {
                    if (random.nextFloat() > f || bl && this.getBlockIdAtCurrentPosition(world, j, i, k, structureBoundingBox) == 0) continue;
                    if (i == n2 || i == n5 || j == n || j == n4 || k == n3 || k == n6) {
                        this.placeBlockAtCurrentPosition(world, n7, 0, j, i, k, structureBoundingBox);
                        continue;
                    }
                    this.placeBlockAtCurrentPosition(world, n8, 0, j, i, k, structureBoundingBox);
                }
            }
        }
    }

    protected void randomlyPlaceBlock(World world, StructureBoundingBox structureBoundingBox, Random random, float f, int n, int n2, int n3, int n4, int n5) {
        if (random.nextFloat() < f) {
            this.placeBlockAtCurrentPosition(world, n4, n5, n, n2, n3, structureBoundingBox);
        }
    }

    protected void randomlyRareFillWithBlocks(World world, StructureBoundingBox structureBoundingBox, int n, int n2, int n3, int n4, int n5, int n6, int n7, boolean bl) {
        float f = n4 - n + 1;
        float f2 = n5 - n2 + 1;
        float f3 = n6 - n3 + 1;
        float f4 = (float)n + f / 2.0f;
        float f5 = (float)n3 + f3 / 2.0f;
        for (int i = n2; i <= n5; ++i) {
            float f6 = (float)(i - n2) / f2;
            for (int j = n; j <= n4; ++j) {
                float f7 = ((float)j - f4) / (f * 0.5f);
                for (int k = n3; k <= n6; ++k) {
                    float f8;
                    float f9 = ((float)k - f5) / (f3 * 0.5f);
                    if (bl && this.getBlockIdAtCurrentPosition(world, j, i, k, structureBoundingBox) == 0 || !((f8 = f7 * f7 + f6 * f6 + f9 * f9) <= 1.05f)) continue;
                    this.placeBlockAtCurrentPosition(world, n7, 0, j, i, k, structureBoundingBox);
                }
            }
        }
    }

    protected void clearCurrentPositionBlocksUpwards(World world, int n, int n2, int n3, StructureBoundingBox structureBoundingBox) {
        int n4;
        int n5;
        int n6 = this.getXWithOffset(n, n3);
        if (!structureBoundingBox.isVecInside(n6, n5 = this.getYWithOffset(n2), n4 = this.getZWithOffset(n, n3))) {
            return;
        }
        while (!world.isAir(n6, n5, n4) && n5 < world.getHeight()) {
            world.setBlock(n6, n5, n4, 0, 0);
            ++n5;
        }
    }

    protected void fillCurrentPositionBlocksDownwards(World world, int n, int n2, int n3, int n4, int n5, StructureBoundingBox structureBoundingBox) {
        int n6;
        int n7;
        int n8 = this.getXWithOffset(n3, n5);
        if (!structureBoundingBox.isVecInside(n8, n7 = this.getYWithOffset(n4), n6 = this.getZWithOffset(n3, n5))) {
            return;
        }
        while ((world.isAir(n8, n7, n6) || Block.BLOCKS[world.getBlockId(n8, n7, n6)].material.isFluid()) && n7 > 1) {
            world.setBlock(n8, n7, n6, n, n2);
            --n7;
        }
    }

    protected void createTreasureChestAtCurrentPosition(World world, StructureBoundingBox structureBoundingBox, Random random, int n, int n2, int n3, StructurePieceTreasure[] structurePieceTreasureArray, int n4) {
        int n5;
        int n6;
        int n7 = this.getXWithOffset(n, n3);
        if (structureBoundingBox.isVecInside(n7, n6 = this.getYWithOffset(n2), n5 = this.getZWithOffset(n, n3)) && world.getBlockId(n7, n6, n5) != Block.CHEST.id) {
            world.setBlock(n7, n6, n5, Block.CHEST.id);
            ChestBlockEntity tileEntityChest = (ChestBlockEntity) world.getBlockEntity(n7, n6, n5);
            if (tileEntityChest != null) {
                StructureComponent.fillTreasureChestWithLoot(random, structurePieceTreasureArray, tileEntityChest, n4);
            }
        }
    }

    private static void fillTreasureChestWithLoot(Random random, StructurePieceTreasure[] structurePieceTreasureArray, ChestBlockEntity tileEntityChest, int n) {
        for (int i = 0; i < n; ++i) {
            StructurePieceTreasure structurePieceTreasure = (StructurePieceTreasure)WeightedRandom.func_35735_a(random, structurePieceTreasureArray);
            int n2 = structurePieceTreasure.field_35595_c + random.nextInt(structurePieceTreasure.field_35593_e - structurePieceTreasure.field_35595_c + 1);
            if (Item.ITEMS[structurePieceTreasure.field_35596_a].getMaxCount() >= n2) {
                tileEntityChest.setStack(random.nextInt(tileEntityChest.size()), new ItemStack(structurePieceTreasure.field_35596_a, n2, structurePieceTreasure.field_35594_b));
                continue;
            }
            for (int j = 0; j < n2; ++j) {
                tileEntityChest.setStack(random.nextInt(tileEntityChest.size()), new ItemStack(structurePieceTreasure.field_35596_a, 1, structurePieceTreasure.field_35594_b));
            }
        }
    }

    protected void placeDoorAtCurrentPosition(World world, StructureBoundingBox structureBoundingBox, Random random, int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7 = this.getXWithOffset(n, n3);
        if (structureBoundingBox.isVecInside(n7, n6 = this.getYWithOffset(n2), n5 = this.getZWithOffset(n, n3))) {
            ((DoorItem)Item.IRON_DOOR).yunibackport$placeDoorBlock(world, n7, n6, n5, n4, Block.DOOR);
        }
    }
}
