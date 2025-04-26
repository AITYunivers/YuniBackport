package io.github.yunivers.yunibackport_r0.structure.fortress.component;

import io.github.yunivers.yunibackport_r0.structure.StructureComponent;
import io.github.yunivers.yunibackport_r0.structure.fortress.NetherFortressStructurePieceWeight;
import io.github.yunivers.yunibackport_r0.structure.fortress.NetherFortressStructurePieces;
import io.github.yunivers.yunibackport_r0.structure.fortress.NetherFortressStructureStart;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NetherFortressComponentStartPiece extends NetherFortressComponentCrossing3
{
    public NetherFortressStructurePieceWeight field_40037_a;
    public List<NetherFortressStructurePieceWeight> field_40035_b;
    public List<NetherFortressStructurePieceWeight> field_40036_c;
    public ArrayList<StructureComponent> field_40034_d = new ArrayList<>();

    public NetherFortressComponentStartPiece(Random random, int n, int n2) {
        super(random, n, n2);
        this.field_40035_b = new ArrayList<>();
        for (NetherFortressStructurePieceWeight structureNetherBridgePieceWeight : NetherFortressStructurePieces.func_40689_a()) {
            structureNetherBridgePieceWeight.field_40698_c = 0;
            this.field_40035_b.add(structureNetherBridgePieceWeight);
        }
        this.field_40036_c = new ArrayList<>();
        for (NetherFortressStructurePieceWeight structureNetherBridgePieceWeight : NetherFortressStructurePieces.func_40687_b()) {
            structureNetherBridgePieceWeight.field_40698_c = 0;
            this.field_40036_c.add(structureNetherBridgePieceWeight);
        }
    }
}
