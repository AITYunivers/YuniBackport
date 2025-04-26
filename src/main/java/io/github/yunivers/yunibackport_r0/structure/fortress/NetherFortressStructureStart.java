package io.github.yunivers.yunibackport_r0.structure.fortress;

import io.github.yunivers.yunibackport_r0.structure.StructureComponent;
import io.github.yunivers.yunibackport_r0.structure.StructureStart;
import io.github.yunivers.yunibackport_r0.structure.fortress.component.NetherFortressComponentStartPiece;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class NetherFortressStructureStart extends StructureStart
{
    public NetherFortressStructureStart(World world, Random random, int n, int n2)
    {
        NetherFortressComponentStartPiece componentNetherBridgeStartPiece = new NetherFortressComponentStartPiece(random, (n << 4) + 2, (n2 << 4) + 2);
        this.components.add(componentNetherBridgeStartPiece);
        componentNetherBridgeStartPiece.buildComponent(componentNetherBridgeStartPiece, this.components, random);
        ArrayList<StructureComponent> arrayList = componentNetherBridgeStartPiece.field_40034_d;
        while (!arrayList.isEmpty())
        {
            int n3 = random.nextInt(arrayList.size());
            StructureComponent structureComponent = arrayList.remove(n3);
            structureComponent.buildComponent(componentNetherBridgeStartPiece, this.components, random);
        }
        this.updateBoundingBox();
        this.func_40559_a(world, random, 48, 70);
    }
}
