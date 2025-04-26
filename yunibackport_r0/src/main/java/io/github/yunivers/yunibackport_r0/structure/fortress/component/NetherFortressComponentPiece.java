package io.github.yunivers.yunibackport_r0.structure.fortress.component;

import io.github.yunivers.yunibackport_lib.structure.*;
import io.github.yunivers.yunibackport_r0.structure.fortress.*;

import java.util.List;
import java.util.Random;

public abstract class NetherFortressComponentPiece extends StructureComponent
{
    protected NetherFortressComponentPiece(int n) {
        super(n);
    }

    private int func_40017_a(List<NetherFortressStructurePieceWeight> list) {
        boolean bl = false;
        int n = 0;
        for (NetherFortressStructurePieceWeight structureNetherBridgePieceWeight : list) {
            if (structureNetherBridgePieceWeight.field_40695_d > 0 && structureNetherBridgePieceWeight.field_40698_c < structureNetherBridgePieceWeight.field_40695_d) {
                bl = true;
            }
            n += structureNetherBridgePieceWeight.field_40697_b;
        }
        return bl ? n : -1;
    }

    private NetherFortressComponentPiece func_40020_a(NetherFortressComponentStartPiece componentNetherBridgeStartPiece, List<NetherFortressStructurePieceWeight> list, List<StructureComponent> list2, Random random, int n, int n2, int n3, int n4, int n5) {
        int n6 = this.func_40017_a(list);
        boolean bl = n6 > 0 && n5 <= 30;
        int n7 = 0;
        block0: while (n7 < 5 && bl) {
            ++n7;
            int n8 = random.nextInt(n6);
            for (NetherFortressStructurePieceWeight structureNetherBridgePieceWeight : list) {
                if ((n8 -= structureNetherBridgePieceWeight.field_40697_b) >= 0) continue;
                if (!structureNetherBridgePieceWeight.func_40693_a(n5) || structureNetherBridgePieceWeight == componentNetherBridgeStartPiece.field_40037_a && !structureNetherBridgePieceWeight.field_40696_e) continue block0;
                NetherFortressComponentPiece componentNetherBridgePiece = NetherFortressStructurePieces.func_40688_a(structureNetherBridgePieceWeight, list2, random, n, n2, n3, n4, n5);
                if (componentNetherBridgePiece == null) continue;
                ++structureNetherBridgePieceWeight.field_40698_c;
                componentNetherBridgeStartPiece.field_40037_a = structureNetherBridgePieceWeight;
                if (!structureNetherBridgePieceWeight.func_40694_a()) {
                    list.remove(structureNetherBridgePieceWeight);
                }
                return componentNetherBridgePiece;
            }
        }
        return NetherFortressStructureEnd.func_40023_a(list2, random, n, n2, n3, n4, n5);
    }

    private StructureComponent func_40018_a(NetherFortressComponentStartPiece componentNetherBridgeStartPiece, List<StructureComponent> list, Random random, int n, int n2, int n3, int n4, int n5, boolean bl) {
        NetherFortressComponentPiece componentNetherBridgePiece;
        if (Math.abs(n - componentNetherBridgeStartPiece.getBoundingBox().minX) > 112 || Math.abs(n3 - componentNetherBridgeStartPiece.getBoundingBox().minZ) > 112) {
            return NetherFortressStructureEnd.func_40023_a(list, random, n, n2, n3, n4, n5);
        }
        List<NetherFortressStructurePieceWeight> list2 = componentNetherBridgeStartPiece.field_40035_b;
        if (bl) {
            list2 = componentNetherBridgeStartPiece.field_40036_c;
        }
        if ((componentNetherBridgePiece = this.func_40020_a(componentNetherBridgeStartPiece, list2, list, random, n, n2, n3, n4, n5 + 1)) != null) {
            list.add(componentNetherBridgePiece);
            componentNetherBridgeStartPiece.field_40034_d.add(componentNetherBridgePiece);
        }
        return componentNetherBridgePiece;
    }

    protected StructureComponent func_40022_a(NetherFortressComponentStartPiece componentNetherBridgeStartPiece, List<StructureComponent> list, Random random, int n, int n2, boolean bl) {
        return switch (this.coordBaseMode) {
            case 2 ->
                    this.func_40018_a(componentNetherBridgeStartPiece, list, random, this.boundingBox.minX + n, this.boundingBox.minY + n2, this.boundingBox.minZ - 1, this.coordBaseMode, this.func_35012_c(), bl);
            case 0 ->
                    this.func_40018_a(componentNetherBridgeStartPiece, list, random, this.boundingBox.minX + n, this.boundingBox.minY + n2, this.boundingBox.maxZ + 1, this.coordBaseMode, this.func_35012_c(), bl);
            case 1 ->
                    this.func_40018_a(componentNetherBridgeStartPiece, list, random, this.boundingBox.minX - 1, this.boundingBox.minY + n2, this.boundingBox.minZ + n, this.coordBaseMode, this.func_35012_c(), bl);
            case 3 ->
                    this.func_40018_a(componentNetherBridgeStartPiece, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY + n2, this.boundingBox.minZ + n, this.coordBaseMode, this.func_35012_c(), bl);
            default -> null;
        };
    }

    protected StructureComponent func_40019_b(NetherFortressComponentStartPiece componentNetherBridgeStartPiece, List<StructureComponent> list, Random random, int n, int n2, boolean bl) {
        return switch (this.coordBaseMode) {
            case 2 ->
                    this.func_40018_a(componentNetherBridgeStartPiece, list, random, this.boundingBox.minX - 1, this.boundingBox.minY + n, this.boundingBox.minZ + n2, 1, this.func_35012_c(), bl);
            case 0 ->
                    this.func_40018_a(componentNetherBridgeStartPiece, list, random, this.boundingBox.minX - 1, this.boundingBox.minY + n, this.boundingBox.minZ + n2, 1, this.func_35012_c(), bl);
            case 1 ->
                    this.func_40018_a(componentNetherBridgeStartPiece, list, random, this.boundingBox.minX + n2, this.boundingBox.minY + n, this.boundingBox.minZ - 1, 2, this.func_35012_c(), bl);
            case 3 ->
                    this.func_40018_a(componentNetherBridgeStartPiece, list, random, this.boundingBox.minX + n2, this.boundingBox.minY + n, this.boundingBox.minZ - 1, 2, this.func_35012_c(), bl);
            default -> null;
        };
    }

    protected StructureComponent func_40016_c(NetherFortressComponentStartPiece componentNetherBridgeStartPiece, List<StructureComponent> list, Random random, int n, int n2, boolean bl) {
        return switch (this.coordBaseMode) {
            case 2 ->
                    this.func_40018_a(componentNetherBridgeStartPiece, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY + n, this.boundingBox.minZ + n2, 3, this.func_35012_c(), bl);
            case 0 ->
                    this.func_40018_a(componentNetherBridgeStartPiece, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY + n, this.boundingBox.minZ + n2, 3, this.func_35012_c(), bl);
            case 1 ->
                    this.func_40018_a(componentNetherBridgeStartPiece, list, random, this.boundingBox.minX + n2, this.boundingBox.minY + n, this.boundingBox.maxZ + 1, 0, this.func_35012_c(), bl);
            case 3 ->
                    this.func_40018_a(componentNetherBridgeStartPiece, list, random, this.boundingBox.minX + n2, this.boundingBox.minY + n, this.boundingBox.maxZ + 1, 0, this.func_35012_c(), bl);
            default -> null;
        };
    }

    protected static boolean func_40021_a(StructureBoundingBox structureBoundingBox) {
        return structureBoundingBox != null && structureBoundingBox.minY > 10;
    }
}
