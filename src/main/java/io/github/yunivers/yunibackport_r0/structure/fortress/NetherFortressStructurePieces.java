package io.github.yunivers.yunibackport_r0.structure.fortress;

import io.github.yunivers.yunibackport_r0.structure.StructureComponent;
import io.github.yunivers.yunibackport_r0.structure.fortress.component.*;

import java.util.List;
import java.util.Random;

@SuppressWarnings("rawtypes")
public class NetherFortressStructurePieces
{
    private static final NetherFortressStructurePieceWeight[] field_40692_a = new NetherFortressStructurePieceWeight[]
    {
        new NetherFortressStructurePieceWeight(NetherFortressComponentStraight.class, 30, 0, true),
        new NetherFortressStructurePieceWeight(NetherFortressComponentCrossing3.class, 10, 4),
        new NetherFortressStructurePieceWeight(NetherFortressComponentCrossing.class, 10, 4),
        new NetherFortressStructurePieceWeight(NetherFortressComponentStairs.class, 10, 3),
        new NetherFortressStructurePieceWeight(NetherFortressComponentThrone.class, 5, 2),
        new NetherFortressStructurePieceWeight(NetherFortressComponentEntrance.class, 5, 1)
    };
    private static final NetherFortressStructurePieceWeight[] field_40691_b = new NetherFortressStructurePieceWeight[]
    {
        new NetherFortressStructurePieceWeight(NetherFortressComponentCorridor5.class, 25, 0, true),
        new NetherFortressStructurePieceWeight(NetherFortressComponentCrossing2.class, 15, 5),
        new NetherFortressStructurePieceWeight(NetherFortressComponentCorridor2.class, 5, 10),
        new NetherFortressStructurePieceWeight(NetherFortressComponentCorridor.class, 5, 10),
        new NetherFortressStructurePieceWeight(NetherFortressComponentCorridor3.class, 10, 3, true),
        new NetherFortressStructurePieceWeight(NetherFortressComponentCorridor4.class, 7, 2),
        new NetherFortressStructurePieceWeight(NetherFortressComponentNetherWartRoom.class, 5, 2)
    };

    private static NetherFortressComponentPiece func_40690_b(NetherFortressStructurePieceWeight structureNetherBridgePieceWeight, List<StructureComponent> list, Random random, int n, int n2, int n3, int n4, int n5) {
        Class clazz = structureNetherBridgePieceWeight.field_40699_a;
        NetherFortressComponentPiece componentNetherBridgePiece = null;
        if (clazz == NetherFortressComponentStraight.class) {
            componentNetherBridgePiece = NetherFortressComponentStraight.func_40029_a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == NetherFortressComponentCrossing3.class) {
            componentNetherBridgePiece = NetherFortressComponentCrossing3.func_40033_a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == NetherFortressComponentCrossing.class) {
            componentNetherBridgePiece = NetherFortressComponentCrossing.func_40028_a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == NetherFortressComponentStairs.class) {
            componentNetherBridgePiece = NetherFortressComponentStairs.func_40031_a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == NetherFortressComponentThrone.class) {
            componentNetherBridgePiece = NetherFortressComponentThrone.func_40026_a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == NetherFortressComponentEntrance.class) {
            componentNetherBridgePiece = NetherFortressComponentEntrance.func_40030_a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == NetherFortressComponentCorridor5.class) {
            componentNetherBridgePiece = NetherFortressComponentCorridor5.func_40032_a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == NetherFortressComponentCorridor2.class) {
            componentNetherBridgePiece = NetherFortressComponentCorridor2.func_40041_a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == NetherFortressComponentCorridor.class) {
            componentNetherBridgePiece = NetherFortressComponentCorridor.func_40038_a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == NetherFortressComponentCorridor3.class) {
            componentNetherBridgePiece = NetherFortressComponentCorridor3.func_40042_a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == NetherFortressComponentCorridor4.class) {
            componentNetherBridgePiece = NetherFortressComponentCorridor4.func_40039_a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == NetherFortressComponentCrossing2.class) {
            componentNetherBridgePiece = NetherFortressComponentCrossing2.func_40025_a(list, random, n, n2, n3, n4, n5);
        } else if (clazz == NetherFortressComponentNetherWartRoom.class) {
            componentNetherBridgePiece = NetherFortressComponentNetherWartRoom.func_40040_a(list, random, n, n2, n3, n4, n5);
        }
        return componentNetherBridgePiece;
    }

    public static NetherFortressComponentPiece func_40688_a(NetherFortressStructurePieceWeight structureNetherBridgePieceWeight, List<StructureComponent> list, Random random, int n, int n2, int n3, int n4, int n5) {
        return func_40690_b(structureNetherBridgePieceWeight, list, random, n, n2, n3, n4, n5);
    }

    public static NetherFortressStructurePieceWeight[] func_40689_a() {
        return field_40692_a;
    }

    public static NetherFortressStructurePieceWeight[] func_40687_b() {
        return field_40691_b;
    }
}
