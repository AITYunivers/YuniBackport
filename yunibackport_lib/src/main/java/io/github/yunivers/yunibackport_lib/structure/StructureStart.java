package io.github.yunivers.yunibackport_r0.structure;

import lombok.Getter;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public abstract class StructureStart
{
    protected LinkedList<StructureComponent> components = new LinkedList<>();
    @Getter
    protected StructureBoundingBox boundingBox;

    protected StructureStart() {
    }

    public LinkedList<StructureComponent> func_40560_b() {
        return this.components;
    }

    public void generateStructure(World world, Random random, StructureBoundingBox structureBoundingBox) {
        Iterator<StructureComponent> iterator = this.components.iterator();
        while (iterator.hasNext())
        {
            StructureComponent structureComponent = iterator.next();
            if (!structureComponent.getBoundingBox().intersectsWith(structureBoundingBox) || structureComponent.addComponentParts(world, random, structureBoundingBox)) continue;
            iterator.remove();
        }
    }

    protected void updateBoundingBox() {
        this.boundingBox = StructureBoundingBox.getNewBoundingBox();
        for (StructureComponent structureComponent : this.components) {
            this.boundingBox.resizeBoundingBoxTo(structureComponent.getBoundingBox());
        }
    }

    protected void markAvailableHeight(World world, Random random, int n) {
        int n2 = world.getHeight() / 2 - 1 - n;
        int n3 = this.boundingBox.getYSize() + 1;
        if (n3 < n2) {
            n3 += random.nextInt(n2 - n3);
        }
        int n4 = n3 - this.boundingBox.maxY;
        this.boundingBox.offset(0, n4, 0);
        for (StructureComponent structureComponent : this.components) {
            structureComponent.getBoundingBox().offset(0, n4, 0);
        }
    }

    protected void func_40559_a(World world, Random random, int n, int n2) {
        int n3 = n2 - n + 1 - this.boundingBox.getYSize();
        int n4 = 1;
        n4 = n3 > 1 ? n + random.nextInt(n3) : n;
        int n5 = n4 - this.boundingBox.minY;
        this.boundingBox.offset(0, n5, 0);
        for (StructureComponent structureComponent : this.components) {
            structureComponent.getBoundingBox().offset(0, n5, 0);
        }
    }

    public boolean isSizeableStructure() {
        return true;
    }
}
